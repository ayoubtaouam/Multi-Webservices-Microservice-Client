
package com.multi.customer_service.web;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.multi.customer_service.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AllCustomers_QNAME = new QName("http://web.customer_service.multi.com/", "allCustomers");
    private final static QName _AllCustomersResponse_QNAME = new QName("http://web.customer_service.multi.com/", "allCustomersResponse");
    private final static QName _CustomerById_QNAME = new QName("http://web.customer_service.multi.com/", "customerById");
    private final static QName _CustomerByIdResponse_QNAME = new QName("http://web.customer_service.multi.com/", "customerByIdResponse");
    private final static QName _SaveCustomer_QNAME = new QName("http://web.customer_service.multi.com/", "saveCustomer");
    private final static QName _SaveCustomerResponse_QNAME = new QName("http://web.customer_service.multi.com/", "saveCustomerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.multi.customer_service.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AllCustomers }
     * 
     */
    public AllCustomers createAllCustomers() {
        return new AllCustomers();
    }

    /**
     * Create an instance of {@link AllCustomersResponse }
     * 
     */
    public AllCustomersResponse createAllCustomersResponse() {
        return new AllCustomersResponse();
    }

    /**
     * Create an instance of {@link CustomerById }
     * 
     */
    public CustomerById createCustomerById() {
        return new CustomerById();
    }

    /**
     * Create an instance of {@link CustomerByIdResponse }
     * 
     */
    public CustomerByIdResponse createCustomerByIdResponse() {
        return new CustomerByIdResponse();
    }

    /**
     * Create an instance of {@link SaveCustomer }
     * 
     */
    public SaveCustomer createSaveCustomer() {
        return new SaveCustomer();
    }

    /**
     * Create an instance of {@link SaveCustomerResponse }
     * 
     */
    public SaveCustomerResponse createSaveCustomerResponse() {
        return new SaveCustomerResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link CustomerDTO }
     * 
     */
    public CustomerDTO createCustomerDTO() {
        return new CustomerDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllCustomers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AllCustomers }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.multi.com/", name = "allCustomers")
    public JAXBElement<AllCustomers> createAllCustomers(AllCustomers value) {
        return new JAXBElement<AllCustomers>(_AllCustomers_QNAME, AllCustomers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllCustomersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AllCustomersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.multi.com/", name = "allCustomersResponse")
    public JAXBElement<AllCustomersResponse> createAllCustomersResponse(AllCustomersResponse value) {
        return new JAXBElement<AllCustomersResponse>(_AllCustomersResponse_QNAME, AllCustomersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerById }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.multi.com/", name = "customerById")
    public JAXBElement<CustomerById> createCustomerById(CustomerById value) {
        return new JAXBElement<CustomerById>(_CustomerById_QNAME, CustomerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.multi.com/", name = "customerByIdResponse")
    public JAXBElement<CustomerByIdResponse> createCustomerByIdResponse(CustomerByIdResponse value) {
        return new JAXBElement<CustomerByIdResponse>(_CustomerByIdResponse_QNAME, CustomerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.multi.com/", name = "saveCustomer")
    public JAXBElement<SaveCustomer> createSaveCustomer(SaveCustomer value) {
        return new JAXBElement<SaveCustomer>(_SaveCustomer_QNAME, SaveCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://web.customer_service.multi.com/", name = "saveCustomerResponse")
    public JAXBElement<SaveCustomerResponse> createSaveCustomerResponse(SaveCustomerResponse value) {
        return new JAXBElement<SaveCustomerResponse>(_SaveCustomerResponse_QNAME, SaveCustomerResponse.class, null, value);
    }

}
