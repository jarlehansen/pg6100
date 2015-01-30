package no.nith.pg6100.domain;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
public class MessageProducer {

    @Inject
    @JMSConnectionFactory("ConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "java:/jms/queue/pg6100/p2p")
    private Queue destination;

    public void send(String message) {
        try {
            TextMessage textMessage = context.createTextMessage(message);
            textMessage.setIntProperty("amount", 200);
            context.createProducer().send(destination, textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
