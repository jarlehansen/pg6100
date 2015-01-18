package no.nith.pg6100.controller;

import no.nith.pg6100.entity.Customer;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class Controller implements Serializable {
    private String customerName = "";
    private Customer selectedCustomer = null;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Customer> getCustomers() {
        return new ArrayList<Customer>();
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void persistCustomer() {
    }

    public void deleteCustomer() {
    }
}
