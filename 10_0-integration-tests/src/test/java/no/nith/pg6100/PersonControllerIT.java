package no.nith.pg6100;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonControllerIT {

    @Rule
    public H2Setup h2Setup = new H2Setup();

    private PersonController personController;

    @Before
    public void setUp() {
        personController = new PersonController();
        personController.setEntityManager(h2Setup.entityManager());
    }

    @Test
    public void addPerson() {
        Person person = new Person("Per");
        personController.setPerson(person);
        personController.persist();

        Person result = personController.findById(person.getId());
        assertTrue(person.getId() > 0);
        assertEquals("Per", result.getName());
    }

    @Test
    public void findAll() {
        List<Person> persons = personController.findAll();
        assertEquals(4, persons.size());
    }
}
