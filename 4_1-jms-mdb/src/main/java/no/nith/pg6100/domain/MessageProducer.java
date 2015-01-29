package no.nith.pg6100.domain;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class MessageProducer {

    @Inject
    @JMSConnectionFactory("ConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "java:/jms/queue/pg6100/p2p")
    private Queue destination;

    public void send(String message) {
        context.createProducer().send(destination, message);
    }
}
