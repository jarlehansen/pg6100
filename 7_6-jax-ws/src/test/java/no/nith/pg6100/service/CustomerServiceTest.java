package no.nith.pg6100.service;

import no.nith.pg6100.dto.Customer;
import no.nith.pg6100.dto.CustomerType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerServiceTest {

//    @Test
//    public void create() {
//        Customer customer = new Customer();
//        customer.setCustomerType(CustomerType.BRONZE);
//        customer.setName("Per");
//
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        factory.setServiceClass(InMemoryCustomerService.class);
//        factory.setAddress("http://localhost:8080/7_6-jax-ws-1.0-SNAPSHOT/CustomerService?wsdl");
//
//        CustomerService customerService = factory.create(CustomerService.class);
//        customerService.create(customer);
//
//        List<Customer> customers = customerService.getCustomers();
//
//        assertEquals(1, customers.size());
//        assertEquals("Per", customers.get(0).getName());
//    }
}
