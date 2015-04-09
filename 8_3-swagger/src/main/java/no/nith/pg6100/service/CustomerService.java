package no.nith.pg6100.service;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/customer")
@Api(value = "/customer", description = "Creates and gets customers")
public class CustomerService {
    private List<String> customers = new ArrayList<>();

    @GET
    @Produces("application/json")
    @ApiOperation(value = "Name of customer", response = String.class)
    public String getName() {
        return "{\"name\":\"Per Olsen\"}";
    }

    @GET
    public List<String> getAll() {
        return customers;
    }

    @POST
    public void addCustomer(String name) {
        customers.add(name);
    }

    @DELETE
    public void deleteCustomer(String name) {
        customers.remove(name);
    }
}
