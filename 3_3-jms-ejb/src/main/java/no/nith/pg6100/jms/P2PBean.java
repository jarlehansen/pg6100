package no.nith.pg6100.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
public class P2PBean {
    @Inject
    @JMSConnectionFactory("ConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "java:/jms/queue/pg6100/p2p")
    private Queue destination;

    public void send(String message) {
        context.createProducer().send(destination, message);
    }

    public String consume() {
        try {
            Message message = context.createConsumer(destination).receive(1000);
            return ((TextMessage) message).getText();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}

