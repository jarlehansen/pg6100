package no.nith.pg6100;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MyDao {
    private List<String> entities;

    @PostConstruct
    public void init() {
        entities = new ArrayList<>();
        entities.add("test1");
        entities.add("test2");
        entities.add("test3");
    }


    public List<String> getAll() {
        return entities;
    }
}
