package no.nith.pg6100.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@SequenceGenerator(name = "SEQ_STUDENT", initialValue = 10)
@NamedQuery(name = "Student.findAll", query = "select s from Student s")
@XmlRootElement
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STUDENT")
    private int id;

    @NotNull
    private String name;

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
