package pg6100;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class Bean {
    private EntityManager entityManager;
    private UserTransaction userTransaction;

    @PersistenceContext(name = "bmt")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Resource
    public void setUserTransaction(UserTransaction userTransaction) {
        this.userTransaction = userTransaction;
    }

    public void transactionalMethod() throws SystemException {
        try {
            userTransaction.begin();
            Entity entity = getEntity();
            entity.increaseCounter();
            userTransaction.commit();
        } catch (Exception e) {
            userTransaction.rollback();
        }
    }

    public Entity getEntity() {
        TypedQuery<Entity> query = entityManager.createNamedQuery("FindEntity", Entity.class);
        return query.getSingleResult();
    }
}
