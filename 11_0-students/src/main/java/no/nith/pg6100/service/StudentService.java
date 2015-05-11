package no.nith.pg6100.service;

import no.nith.pg6100.entity.Student;
import no.nith.pg6100.infrastructure.StudentDao;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentService {
    @Inject
    private StudentDao studentDao;

    @Context
    private UriInfo uriInfo;

    @GET
    public Response getAllStudents() {
        return Response.ok(studentDao.findAll()).build();
    }

    @GET
    @Path("/id/{id}")
    public Response getStudent(@PathParam("id") int id) {
        return Response.ok(studentDao.findById(id)).build();
    }

    @POST
    public Response persistStudent(@Valid Student student) {
        studentDao.persist(student);
        URI uri = uriInfo.getAbsolutePathBuilder().path("id/" + student.getId()).build();
        return Response.created(uri).build();
    }
}
