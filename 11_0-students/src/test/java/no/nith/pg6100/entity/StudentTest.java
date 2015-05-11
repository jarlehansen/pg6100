package no.nith.pg6100.entity;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void violations_forNullName() {
        Student student = new Student();
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        assertEquals(1, violations.size());
    }

    @Test
    public void noViolations_forName() {
        Student student = new Student();
        student.setName("Pål");
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        assertEquals(0, violations.size());
    }

}