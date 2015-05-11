package no.nith.pg6100.infrastructure;

import no.nith.pg6100.entity.Subject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubjectDaoTest {

    @Rule
    public H2Setup h2Setup = new H2Setup();

    private SubjectDao subjectDao;

    @Before
    public void setUp() {
        subjectDao = new SubjectDao();
        subjectDao.setEntityManager(h2Setup.entityManager());
    }

    @Test
    public void findAll() {
        List<Subject> subjects = subjectDao.findAll();
        assertEquals(3, subjects.size());
    }

    @Test
    public void findById() {
        Subject subject = subjectDao.findById(1);
        assertEquals("Enterprise programmering 2", subject.getName());
        assertEquals("PG6100", subject.getShortName());
    }

    @Test
    public void persist() {
        Subject subject = new Subject();
        subject.setName("Enterprise programmering 3");
        subject.setShortName("PG6200");

        h2Setup.entityManager().getTransaction().begin();
        subjectDao.persist(subject);
        h2Setup.entityManager().getTransaction().commit();

        List<Subject> subjects = subjectDao.findAll();
        assertEquals(10, subject.getId());
        assertEquals(4, subjects.size());
    }

}