package no.nith.pg6100;

import javax.persistence.*;

@javax.persistence.Entity
@NamedQuery(name = "FindEntity", query = "select t from Entity t")
public class Entity {
    @Id
    private int id;

    private int counter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increaseCounter() {
        counter++;
    }
}
