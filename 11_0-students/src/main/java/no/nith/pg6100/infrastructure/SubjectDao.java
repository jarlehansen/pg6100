package no.nith.pg6100.infrastructure;

import no.nith.pg6100.entity.Subject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class SubjectDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Subject> findAll() {
        TypedQuery<Subject> query = entityManager.createNamedQuery("Subject.findAll", Subject.class);
        return query.getResultList();
    }

    public Subject findById(int id) {
        return entityManager.find(Subject.class, id);
    }

    public void persist(Subject subject) {
        entityManager.persist(subject);
    }
}
