package lv.venta.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AtlaideTest {

    private Validator validator;
    private Atlaide atlaide;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        atlaide = new Atlaide(50, LocalDateTime.now(), LocalDateTime.now().plusDays(1));
    }

    @Test
    public void testValidAtlaidesApmers() {
        atlaide.setAtlaidesApmers(25);
        Set<ConstraintViolation<Atlaide>> violations = validator.validate(atlaide);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'atlaidesApmers'.");
    }

    @Test
    public void testInvalidAtlaidesApmersNegative() {
        atlaide.setAtlaidesApmers(-10);
        Set<ConstraintViolation<Atlaide>> violations = validator.validate(atlaide);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdas 'atlaidesApmers'.");
        for (ConstraintViolation<Atlaide> violation : violations) {
            assertEquals("must be greater than or equal to 0", violation.getMessage());
        }
    }

    @Test
    public void testInvalidAtlaidesApmersTooHigh() {
        atlaide.setAtlaidesApmers(150);
        Set<ConstraintViolation<Atlaide>> violations = validator.validate(atlaide);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdas'atlaidesApmers'.");
        for (ConstraintViolation<Atlaide> violation : violations) {
            assertEquals("must be less than or equal to 100", violation.getMessage());
        }
    }

    @Test
    public void testValidDates() {
        atlaide.setSakumaDatums(LocalDateTime.now());
        atlaide.setBeiguDatums(LocalDateTime.now().plusDays(10));
        Set<ConstraintViolation<Atlaide>> violations = validator.validate(atlaide);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas for valid dates.");
    }

    @Test
    public void testRelationshipWithVeikalsPrece() {
        Veikals_prece veikalsPrece = new Veikals_prece();
        atlaide.setVeikals_prece(List.of(veikalsPrece));
        assertEquals(1, atlaide.getVeikals_prece().size(), "Relationship with 'Veikals_prece' should be properly managed.");
    }
}
