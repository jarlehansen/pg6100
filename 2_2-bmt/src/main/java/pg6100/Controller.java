package pg6100;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.SystemException;

@Model
public class Controller {
    private Bean bean;

    @Inject
    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public Entity getEntity() {
        return bean.getEntity();
    }

    public void withTransaction() throws SystemException {
        bean.transactionalMethod();
    }

    public void withoutTransaction() {
        Entity entity = bean.getEntity();
        entity.increaseCounter();
    }
}
