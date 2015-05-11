package no.nith.pg6100.entity;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class SubjectTest {
    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void violations_forNullName() {
        Subject subject = new Subject();
        subject.setShortName("PG6200");

        Set<ConstraintViolation<Subject>> violations = validator.validate(subject);
        assertEquals(1, violations.size());
    }

    @Test
    public void violations_forNullShortName() {
        Subject subject = new Subject();
        subject.setName("Enterprise programmering 3");

        Set<ConstraintViolation<Subject>> violations = validator.validate(subject);
        assertEquals(1, violations.size());
    }

    @Test
    public void violations_forInvalidShortName() {
        Subject subject = new Subject();
        subject.setShortName("PG");
        subject.setName("Enterprise programmering 3");

        Set<ConstraintViolation<Subject>> violations = validator.validate(subject);
        assertEquals(1, violations.size());
    }
}