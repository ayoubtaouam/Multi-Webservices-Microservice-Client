package com.multi.account_service.client;

import com.multi.account_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@FeignClient(url = "http://localhost:8080", value = "customer-rest-client")
public interface CustomerClient {
    @GetMapping("/customers")
    public List<Customer> getCustomers();

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);
}
