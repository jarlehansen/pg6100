package no.nith.pg6100;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class SubscriberMain implements MessageListener {

    private TopicConnection connection;
    private TopicSubscriber subscriber;

    public SubscriberMain(String subscriberName) throws NamingException, JMSException {
        Context context = new InitialContext();
        TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
        connection = connectionFactory.createTopicConnection();
        connection.setClientID(subscriberName);
        connection.start();

        TopicSession session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
        Topic destination = session.createTopic("PG6100/pub-sub");

        subscriber = session.createDurableSubscriber(destination, subscriberName);
        subscriber.setMessageListener(this);
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println("MessageId:" + message.getJMSMessageID() + " Received:" + ((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() throws JMSException {
        System.out.println("Stopping message listener");
        subscriber.close();
        connection.close();
    }

    public static void main(String[] args) throws JMSException, NamingException {
        SubscriberMain subscriber1 = new SubscriberMain("subscriber1");
        SubscriberMain subscriber2 = new SubscriberMain("subscriber2");
        new Scanner(System.in).nextLine();
        subscriber1.close();
        subscriber2.close();
    }
}
