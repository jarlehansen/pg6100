package no.nith.pg6100.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQuery(name = "Customer.getAll", query = "select c from Customer c")
@XmlRootElement
public class Customer {
    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ", initialValue = 1)
    private int id;

    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
