package no.nith.pg6100;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {
    @Context
    private UriInfo uriInfo;

    private static final Map<Integer, Customer> customers = new HashMap<>();

    static {
        customers.put(0, new Customer("Per Olsen"));
    }

    public CustomerService() {
    }

    @GET
    @Path("{index}")
    public Customer getCustomer(@PathParam("index") int index) {
        return customers.get(index);
    }


    @DELETE
    @Path("{index}")
    public Response deleteCustomer(@PathParam("index") int index) {
        customers.remove(index);
        return Response.noContent().build();
    }

    @PUT
    public Response newCustomer(Customer customer) {
        return createCustomer(customer);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response newCustomer(@FormParam("name") String name) {
        return createCustomer(new Customer(name));
    }

    private Response createCustomer(Customer customer) {
        Optional<Integer> nextIndex = customers.keySet().stream().max(Comparator.<Integer>naturalOrder());
        customers.put(nextIndex.get() + 1, customer);
        URI uri = uriInfo.getAbsolutePathBuilder().path("/customer/" + (customers.size() - 1)).build();
        return Response.created(uri).build();
    }
}
