package no.nith.pg6100;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class PersonControllerTest {

    @Inject
    private PersonController personController;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).addPackage(PersonController.class.getPackage()).addAsResource("META-INF/persistence.xml");
    }

    @Test
    public void findAll() {
        List<Person> persons = personController.findAll();
        assertEquals(4, persons.size());
    }

    @Test
    public void findById() {
        Person person = personController.findById(3);
        assertEquals("Marianne", person.getName());
    }

    @Test
    public void persist() {
        Person person = new Person("Petter");
        personController.setPerson(person);
        personController.persist();

        List<Person> persons = personController.findAll();
        Person persistedPerson = personController.findById(person.getId());

        assertTrue(person.getId() > 0);
        assertEquals(5, persons.size());
        assertEquals("Petter", persistedPerson.getName());
    }
}
