package no.nith.pg6100;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerService {

    @GET
    public Response getName() {
        throw new IllegalStateException("Test exception");
    }
}
