package no.nith.pg6100.service;

import no.nith.pg6100.entity.Subject;
import no.nith.pg6100.infrastructure.SubjectDao;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/subjects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubjectService {

    @Inject
    private SubjectDao subjectDao;

    @Context
    private UriInfo uriInfo;

    @GET
    public Response getAllSubjects() {
        return Response.ok(subjectDao.findAll()).build();
    }

    @GET
    @Path("/id/{id}")
    public Response getSubject(@PathParam("id") int id) {
        return Response.ok(subjectDao.findById(id)).build();
    }

    @POST
    public Response persistSubject(@Valid Subject subject) {
        subjectDao.persist(subject);
        URI uri = uriInfo.getAbsolutePathBuilder().path("id/" + subject.getId()).build();
        return Response.created(uri).build();
    }

}
