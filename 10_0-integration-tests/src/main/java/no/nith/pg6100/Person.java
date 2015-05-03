package no.nith.pg6100;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
@SequenceGenerator(name = "SEQ_PERSON", initialValue = 10)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSON")
    private int id;

    private String name;

    public Person() {
    }

    public Person(String name) {
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}