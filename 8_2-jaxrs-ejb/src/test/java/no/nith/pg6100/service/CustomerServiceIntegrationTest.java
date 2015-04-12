package no.nith.pg6100.service;

import no.nith.pg6100.entity.Customer;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class CustomerServiceIntegrationTest {
    private static final String BASE_URL = "http://localhost:8080/8_2-jaxrs-ejb-1.0-SNAPSHOT";


    @Test
    public void getCustomerById() {
        Response response = ClientBuilder.newClient()
                .target(BASE_URL + "/customers/0").request().get();
        Customer customer = response.readEntity(Customer.class);
        System.out.println(customer);

        assertEquals(Response.Status.OK, response.getStatusInfo());
        assertEquals(0, customer.getId());
        assertEquals("Per Olsen", customer.getName());
    }
}