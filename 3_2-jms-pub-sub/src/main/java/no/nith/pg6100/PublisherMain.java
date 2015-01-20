package no.nith.pg6100;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;

public class PublisherMain {

    public static void main(String[] args) throws JMSException, NamingException {
        Context context = new InitialContext();
        TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
        TopicConnection connection = connectionFactory.createTopicConnection();
        connection.start();

        TopicSession session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
        Topic destination = session.createTopic("PG6100/pub-sub");

        MessageProducer producer = session.createProducer(destination);

        for (int i = 1; i <= 10; i++) {
            producer.send(session.createTextMessage("Message created " + new Date()));
            System.out.println(String.format("Message number %d sent", i));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {
            }
        }


        connection.close();
    }
}
