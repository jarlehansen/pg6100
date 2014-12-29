package no.nith.pg6100;

import org.h2.tools.Server;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public abstract class AbstractH2DB {
    private static Server server;

    protected EntityManagerFactory factory;
    protected EntityManager entityManager;

    @BeforeClass
    public static void startDb() throws SQLException {
        server = Server.createTcpServer("-tcpAllowOthers");
        server.start();
    }

    @AfterClass
    public static void showdownDb() {
        server.shutdown();
    }

    protected void createEntityManager() {
        factory = Persistence.createEntityManagerFactory("jpa-repetisjon");
        entityManager = factory.createEntityManager();
    }

    protected void closeEntityManager() {
        entityManager.close();
        factory.close();
    }
}
