package com.multi.account_service.web;

import com.multi.account_service.client.CustomerClient;
import com.multi.account_service.model.Customer;
import com.multi.customer_service.stub.CustomerServiceGrpc;
import com.multi.customer_service.stub.CustomerServiceOuterClass;
import com.multi.customer_service.web.CustomerSOAPController;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController @RequestMapping("account-service")
public class AccountController {
    private RestTemplate restTemplate;

    public AccountController(RestTemplate restTemplate, CustomerClient customerClient, CustomerSOAPController customerSOAPController) {
        this.restTemplate = restTemplate;
        this.customerClient = customerClient;
        this.customerSOAPController = customerSOAPController;
    }

    private CustomerClient customerClient;
    private CustomerSOAPController customerSOAPController;
    @GrpcClient(value = "customerService")
    private CustomerServiceGrpc.CustomerServiceBlockingStub stub;

    //---------------------------Rest Template--------------------------------------------
    @GetMapping("customers/restTemplate")
    public List<Customer> customerListRestTemplate() {
        Customer[] customers = restTemplate.getForObject("http://localhost:8080/customers", Customer[].class);
        return List.of(customers);
    }

    @GetMapping("customer/restTemplate/{id}")
    public Customer customerRestTemplateById(@PathVariable Long id) {
        Customer customer = restTemplate.getForObject("http://localhost:8080/customers/"+id, Customer.class);
        return customer;
    }

    //-----------------------------Web Client----------------------------------------------
    @GetMapping("customers/webClient")
    public Flux<Customer> customerFlux() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        Flux<Customer> customerFlux = webClient.get().uri("/customers").retrieve().bodyToFlux(Customer.class);
        return customerFlux;
    }

    @GetMapping("customer/webClient/{id}")
    public Mono<Customer> customerMono(@PathVariable Long id) {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
        Mono<Customer> customerMono = webClient.get().uri("/customers/"+id).retrieve().bodyToMono(Customer.class);
        return customerMono;
    }

    //-------------------------------Open Feign--------------------------------------------------
    @GetMapping("customers/openFeign")
    public List<Customer> customerListOpenFeign() {
        return customerClient.getCustomers();
    }

    @GetMapping("customer/openFeign/{id}")
    public Customer customerByIdOpenFeign(@PathVariable Long id){
        return customerClient.getCustomerById(id);
    }

    //--------------------------------GraphQL--------------------------------------------------
    @GetMapping("customers/graphQL")
    public Mono<List<Customer>> customersGraphQL() {
        HttpGraphQlClient client = HttpGraphQlClient.builder()
                .url("http://localhost:8080/graphql")
                .build();
        var httpRequestDocument = """
                query {
                  allCustomers {
                    email, name
                  }
                }
                """;
        Mono<List<Customer>> customers = client.document(httpRequestDocument)
                .retrieve("allCustomers")
                .toEntityList(Customer.class);
        return customers;
    }

    @GetMapping("customer/graphQL/{id}")
    public Mono<Customer> customerByIdGraphQl(@PathVariable Long id) {
        HttpGraphQlClient client = HttpGraphQlClient.builder()
                .url("http://localhost:8080/graphql")
                .build();
        var httpRequestDocument = """
                query($id:Int) {
                    customerById(id:$id){
                        id, name, email
                    }
                }
                """;
        Mono<Customer> customer = client.document(httpRequestDocument)
                .variable("id", id)
                .retrieve("customerById")
                .toEntity(Customer.class);
        return customer;
    }
    //-----------------------------------SOAP---------------------------------------------
    @GetMapping("customers/soap")
    public List<Customer> soapCustomers() {
        List<com.multi.customer_service.web.Customer> customersSoap = customerSOAPController.allCustomers();
        return customersSoap.stream().map(s -> {
            Customer c = new Customer();
            c.setId(s.getId());
            c.setName(s.getName());
            c.setEmail(s.getEmail());
            return c;
        }).collect(Collectors.toList());
    }

    @GetMapping("customer/soap/{id}")
    public Customer soapCustomerById(@PathVariable Long id) {
        com.multi.customer_service.web.Customer customer = customerSOAPController.customerById(id);
        Customer c = new Customer(customer.getId(), customer.getName(), customer.getEmail());
        return c;
    }

    //--------------------------------------GRPC----------------------------------------------
    @GetMapping("customer/grpc")
    public List<Customer> grpcCustomers() {
        CustomerServiceOuterClass.GetCustomerResponse response = stub.getAllCustomers(CustomerServiceOuterClass.GetAllCustomersRequest.newBuilder().build());
        List<CustomerServiceOuterClass.Customer> customersList = response.getCustomersList();
        return customersList.stream().map(c -> {
            return new Customer(c.getId(), c.getName(), c.getEmail());
        }).collect(Collectors.toList());
    }

    @GetMapping("customer/grpc/{id}")
    public Customer grpcCustomerById(@PathVariable Long id) {
        CustomerServiceOuterClass.GetCustomerByIdResponse response = stub.getCustomerById(CustomerServiceOuterClass.GetCustomerByIdRequest.newBuilder().setCustomerId(id).build());
        CustomerServiceOuterClass.Customer customer = response.getCustomer();
        return new Customer(customer.getId(), customer.getName(), customer.getEmail());
    }
}
