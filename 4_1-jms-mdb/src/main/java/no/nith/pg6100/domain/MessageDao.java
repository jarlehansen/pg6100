package no.nith.pg6100.domain;

import no.nith.pg6100.entity.ReceivedMessage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class MessageDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void storeMessage(String text) {
        ReceivedMessage message = new ReceivedMessage();
        message.setMessage(text);
        entityManager.persist(message);
    }

    public String getLatestMessage() {
        TypedQuery<ReceivedMessage> query = entityManager.createNamedQuery("ReceivedMessage.findLatest", ReceivedMessage.class);
        List<ReceivedMessage> resultList = query.getResultList();
        if (resultList.size() == 0)
            return "";
        else
            return resultList.get(0).getMessage();
    }
}
