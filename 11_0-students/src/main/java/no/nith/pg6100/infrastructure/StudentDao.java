package no.nith.pg6100.infrastructure;

import no.nith.pg6100.entity.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class StudentDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createNamedQuery("Student.findAll", Student.class);
        return query.getResultList();
    }

    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    public void persist(Student student) {
        entityManager.persist(student);
    }
}
