package no.nith.pg6100;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class P2PMain {

    public static void main(String[] args) throws NamingException, JMSException, IOException {
        Context context = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = session.createQueue("PG6100/p2p");

        MessageProducer producer = session.createProducer(destination);
        producer.send(session.createTextMessage("Message created " + new Date()));
        System.out.println("Message sent");
        System.out.println("Press any key to consume message");
        new Scanner(System.in).nextLine();

        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive();
        if (message instanceof TextMessage) {
            System.out.println("Received: " + ((TextMessage) message).getText());
        }

        connection.close();
    }
}
