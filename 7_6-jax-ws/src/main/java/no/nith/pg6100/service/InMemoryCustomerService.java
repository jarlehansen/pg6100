package no.nith.pg6100.service;

import no.nith.pg6100.dto.Customer;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "CustomerService")
public class InMemoryCustomerService implements CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void create(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
