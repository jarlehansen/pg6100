package no.nith.pg6100;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Main {

    public static final String FILTER = "JMSPriority=6 AND amount > 200";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = session.createQueue("PG6100");

        sendMessage(session, destination);
        consumeMessage(session, destination);

        connection.close();
    }

    private static void sendMessage(Session session, Queue destination) throws JMSException {
        MessageProducer producer = session.createProducer(destination);

        MyMessage myMessage = new MyMessage();
        myMessage.setMessage("This is my message");

        ObjectMessage objectMessage = session.createObjectMessage(myMessage);
        objectMessage.setIntProperty("amount", 201);

        producer.setPriority(6);
        producer.send(objectMessage);
        System.out.println("Message sent");
    }

    private static void consumeMessage(Session session, Queue destination) throws JMSException {
        MessageConsumer consumer = session.createConsumer(destination, FILTER);

        Message message = consumer.receive(1000);
        if (message instanceof ObjectMessage) {
            MyMessage myMessage = (MyMessage) ((ObjectMessage) message).getObject();
            System.out.println("Priority: " + message.getJMSPriority());
            System.out.println(myMessage);
        }
    }


}
