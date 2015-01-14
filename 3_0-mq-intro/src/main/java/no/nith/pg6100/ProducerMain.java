package no.nith.pg6100;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ProducerMain {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = session.createQueue("PG6100");
        MessageProducer messageProducer = session.createProducer(destination);

        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("Test message for Active MQ");
        messageProducer.send(textMessage);
        connection.close();
    }
}
