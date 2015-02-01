package no.nith.pg6100.domain;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/pg6100/p2p"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "amount > 100")
})
public class MessageConsumer implements MessageListener {
    @Inject
    private MessageDao messageDao;

    @Override
    public void onMessage(Message message) {
        try {
            messageDao.storeMessage(message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
