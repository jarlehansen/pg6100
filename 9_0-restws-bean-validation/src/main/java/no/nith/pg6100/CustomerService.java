package no.nith.pg6100;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerService {

    @GET
    @Path("{index}")
    public Response getCustomer(@PathParam("index") @Pattern(regexp = "\\d", message = "Index must be a number") String index) {
        return Response.ok(new Customer("Per")).build();
    }

    @PUT
    public Response validateCustomer(@Valid Customer customer) {
        return Response.ok().build();
    }
}
