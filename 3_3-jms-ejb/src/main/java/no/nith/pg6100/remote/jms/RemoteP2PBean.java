package no.nith.pg6100.remote.jms;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
public class RemoteP2PBean {
    @Inject
    @PG6100ConnectionFactory("http-remoting://127.0.0.1:8080")
    private JMSContext context;

    @Inject
    @PG6100Queue("pg6100-p2p")
    private Queue destination;


    public void send(String message) {
        context.createProducer().send(destination, message);
    }

    public String consume() {
        try (JMSConsumer consumer = context.createConsumer(destination)) {
            Message message = consumer.receive();
            return ((TextMessage) message).getText();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
