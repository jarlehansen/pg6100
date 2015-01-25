package no.nith.pg6100.remote.jms;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

@ApplicationScoped
public class PG6100RemoteConnectionFactory {

    private JMSContext context = null;
    private Queue queue = null;

    @Produces
    @PG6100ConnectionFactory
    public JMSContext context(InjectionPoint injectionPoint) throws IOException, NamingException {
        if (context == null) {
            PG6100ConnectionFactory annotation = injectionPoint.getAnnotated().getAnnotation(PG6100ConnectionFactory.class);
            String providerUrl = annotation.value();

            Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
            properties.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, providerUrl));
            properties.put(Context.URL_PKG_PREFIXES,  "org.jboss.ejb.client.naming");

            InitialContext initialContext = new InitialContext(properties);
            ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");
            context = connectionFactory.createContext();
        }
        return context;
    }

    @Produces
    @PG6100Queue
    public Queue queue(InjectionPoint injectionPoint) {
        if (queue == null) {
            PG6100Queue annotation = injectionPoint.getAnnotated().getAnnotation(PG6100Queue.class);
            String queueName = annotation.value();
            if (queueName == null || queueName.length() == 0)
                throw new IllegalArgumentException(String.format("%s must specify queue name", PG6100Queue.class.getSimpleName()));

            queue = context.createQueue(queueName);
        }

        return queue;
    }

    @PreDestroy
    public void closeContext() {
        context.close();
    }
}
