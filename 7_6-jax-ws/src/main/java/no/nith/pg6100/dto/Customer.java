package no.nith.pg6100.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private String name;

    private CustomerType customerType;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
