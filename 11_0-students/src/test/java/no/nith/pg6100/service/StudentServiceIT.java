package no.nith.pg6100.service;

import no.nith.pg6100.entity.Student;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static no.nith.pg6100.service.TestConstants.BASE_URL;
import static org.jboss.resteasy.util.HttpResponseCodes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentServiceIT {

    @Test
    public void getAllStudents() {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/students").request().get();
        assertEquals(SC_OK, response.getStatus());

        List<Student> students = response.readEntity(new GenericType<List<Student>>() {
        });
        assertTrue(students.size() > 0);
    }

    @Test
    public void getStudent() {
        Response response = ClientBuilder.newClient().target(BASE_URL + "/students/id/1").request().get();
        assertEquals(SC_OK, response.getStatus());

        Student student = response.readEntity(Student.class);
        assertEquals("Per", student.getName());
    }

    @Test
    public void persistStudent() {
        Student student = new Student();
        student.setName("Pål");

        Response response = ClientBuilder.newClient().target(BASE_URL + "/students").request()
                .post(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(SC_CREATED, response.getStatus());

        String location = response.getHeaderString("Location");
        Response studentResponse = ClientBuilder.newClient().target(location).request().head();
        assertEquals(SC_OK, studentResponse.getStatus());
    }

    @Test
    public void persistStudent_invalidInput() {
        Student student = new Student();

        Response response = ClientBuilder.newClient().target(BASE_URL + "/students").request()
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(SC_BAD_REQUEST, response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}