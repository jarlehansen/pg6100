package no.nith.pg6100.infrastructure;

import no.nith.pg6100.entity.Student;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    @Rule
    public H2Setup h2Setup = new H2Setup();

    private StudentDao studentDao;

    @Before
    public void setUp() {
        studentDao = new StudentDao();
        studentDao.setEntityManager(h2Setup.entityManager());
    }

    @Test
    public void findAll() {
        List<Student> students = studentDao.findAll();
        assertEquals(3, students.size());
    }

    @Test
    public void findById() {
        Student student = studentDao.findById(1);
        assertEquals("Per", student.getName());
    }

    @Test
    public void persist() {
        Student student = new Student();
        student.setName("Pål");

        h2Setup.entityManager().getTransaction().begin();
        studentDao.persist(student);
        h2Setup.entityManager().getTransaction().commit();;

        List<Student> students = studentDao.findAll();
        assertEquals(10, student.getId());
        assertEquals(4, students.size());
    }
}