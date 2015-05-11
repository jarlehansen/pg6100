package no.nith.pg6100.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@SequenceGenerator(name = "SEQ_SUBJECT", initialValue = 10)
@NamedQuery(name = "Subject.findAll", query = "select s from Subject s")
@XmlRootElement
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUBJECT")
    private int id;

    @NotNull
    private String name;

    @NotNull
    @Size(min = 4, max = 6)
    private String shortName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(inverseJoinColumns = { @JoinColumn(name = "Student_id", referencedColumnName = "id") })
    private List<Student> students;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
