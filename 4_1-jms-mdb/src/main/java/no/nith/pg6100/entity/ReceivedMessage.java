package no.nith.pg6100.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "ReceivedMessage.findLatest", query = "select r from ReceivedMessage r order by r.id desc")
public class ReceivedMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
