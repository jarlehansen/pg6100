package no.nith.pg6100.dao;

import no.nith.pg6100.entity.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CustomerDao {

    @PersistenceContext(name = "customer")
    private EntityManager entityManager;

    public List<Customer> getAll() {
        TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.getAll", Customer.class);
        return query.getResultList();
    }

    public Customer get(int id) {
        return entityManager.find(Customer.class, id);
    }

    public void delete(int id) {
        entityManager.remove(get(id));
    }

    public Customer create(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }
}
