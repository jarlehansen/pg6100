package no.nith.pg6100;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class Bean {
    private EntityManager entityManager;

    @PersistenceContext(name = "cmt")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void transactionalMethod() {
        Entity entity = getEntity();
        entity.increaseCounter();
    }

    public Entity getEntity() {
        TypedQuery<Entity> query = entityManager.createNamedQuery("FindEntity", Entity.class);
        return query.getSingleResult();
    }
}
