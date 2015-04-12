package no.nith.pg6100.service;

import no.nith.pg6100.dao.CustomerDao;
import no.nith.pg6100.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {
    @Inject
    private CustomerDao customerDao;

    @Context
    private UriInfo uriInfo;

    public CustomerService() {
    }

    @GET
    public Response getAll() {
        return Response.ok(customerDao.getAll()).build();
    }

    @GET

    @Path("{index}")
    public Response getCustomer(@PathParam("index") int index) {
        return Response.ok(customerDao.get(index)).build();
    }

    @DELETE
    @Path("{index}")
    public Response deleteCustomer(@PathParam("index") int index) {
        customerDao.delete(index);
        return Response.noContent().build();
    }

    @PUT
    public Response newCustomer(Customer customer) {
        Customer persistedCustomer = customerDao.create(customer);
        URI uri = uriInfo.getAbsolutePathBuilder().path("/customer/" + persistedCustomer.getId()).build();
        return Response.created(uri).build();
    }
}
