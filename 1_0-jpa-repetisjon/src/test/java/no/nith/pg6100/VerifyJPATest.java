package no.nith.pg6100;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerifyJPATest extends AbstractH2DB {

    @Before
    public void setUp() {
        createEntityManager();
    }

    @After
    public void tearDown() {
        closeEntityManager();
    }

    @Test
    public void initializeDatabase_customer() {
        TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.findAll", Customer.class);
        List<Customer> customers = query.getResultList();

        assertEquals(3, customers.size());
    }

    @Test
    public void initializeDatabase_item() {
        TypedQuery<Item> query = entityManager.createNamedQuery("Item.findAll", Item.class);
        List<Item> items = query.getResultList();

        assertEquals(4, items.size());
    }

    @Test
    public void initializeDatabase_receipt() {
        TypedQuery<Receipt> query = entityManager.createNamedQuery("Receipt.findAll", Receipt.class);
        List<Receipt> receipts = query.getResultList();

        assertEquals(3, receipts.size());
    }
}
