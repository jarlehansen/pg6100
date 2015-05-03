package no.nith.pg6100;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class PersonController {

    @PersistenceContext
    private EntityManager entityManager;

    private Person person = new Person();

    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Transactional
    public void persist() {
        entityManager.persist(person);
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createNamedQuery("Person.findAll", Person.class);
        return query.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
}
