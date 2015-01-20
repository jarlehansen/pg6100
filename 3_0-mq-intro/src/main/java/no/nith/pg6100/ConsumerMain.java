package no.nith.pg6100;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerMain {

    public static void main(String[] args) throws JMSException, InterruptedException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = session.createQueue("PG6100");
        MessageConsumer consumer = session.createConsumer(destination);

        Message message = consumer.receive(1000);
        if (message instanceof TextMessage) {
            System.out.println(((TextMessage) message).getText());
        }

        consumer.close();
        session.close();
        connection.close();
    }
}
