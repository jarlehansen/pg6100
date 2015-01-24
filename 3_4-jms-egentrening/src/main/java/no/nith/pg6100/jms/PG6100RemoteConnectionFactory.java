package no.nith.pg6100.jms;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

@ApplicationScoped
public class PG6100RemoteConnectionFactory {

    private ConnectionFactory connectionFactory = null;

    @Produces
    @PG6100ConnectionFactory
    ConnectionFactory connectionFactory(InjectionPoint injectionPoint) throws IOException, NamingException {
        if (connectionFactory == null) {
            PG6100ConnectionFactory annotation = injectionPoint.getAnnotated().getAnnotation(PG6100ConnectionFactory.class);
            String providerUrl = annotation.value();

            Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
            properties.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, providerUrl));

            InitialContext initialContext = new InitialContext(properties);
            connectionFactory = (ConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");
        }
        return connectionFactory;
    }
}
