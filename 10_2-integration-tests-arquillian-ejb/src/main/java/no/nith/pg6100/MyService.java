package no.nith.pg6100;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class MyService {

    @Inject
    private MyDao myDao;

    public List<String> allEntities() {
        return myDao.getAll();
    }

    public String findByIndex(int index) {
        List<String> entities = myDao.getAll();
        return entities.get(index);
    }
}
