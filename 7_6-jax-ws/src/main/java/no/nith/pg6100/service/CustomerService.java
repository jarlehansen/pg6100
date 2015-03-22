package no.nith.pg6100.service;

import no.nith.pg6100.dto.Customer;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CustomerService {
    public void create(@WebParam(name = "customer", targetNamespace = "http://service.pg6100.nith.no/") Customer customer);

    public List<Customer> getCustomers();
}
