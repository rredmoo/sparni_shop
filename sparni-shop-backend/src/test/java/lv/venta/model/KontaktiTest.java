package lv.venta.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class KontaktiTest {

    private Validator validator;
    private Kontakti kontakti;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        kontakti = new Kontakti(
            "Contact Info",
            "Kontaktinformācija",
            "28205210."
        );
    }

    @Test
    public void testValidNosaukumsEn() {
        kontakti.setNosaukumsEn("Valid Name");
        Set<ConstraintViolation<Kontakti>> violations = validator.validate(kontakti);
        assertTrue(violations.isEmpty(), "There should be no violations for 'nosaukumsEn'.");
    }

    @Test
    public void testInvalidNosaukumsEn() {
        kontakti.setNosaukumsEn("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        Set<ConstraintViolation<Kontakti>> violations = validator.validate(kontakti);
        assertFalse(violations.isEmpty(), "There should be violations for 'nosaukumsEn'.");
        for (ConstraintViolation<Kontakti> violation : violations) {
            assertEquals("Max allow symbols is 50!", violation.getMessage());
        }
    }

    @Test
    public void testValidNosaukumsLv() {
        kontakti.setNosaukumsLv("Derīgs nosaukums");
        Set<ConstraintViolation<Kontakti>> violations = validator.validate(kontakti);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'nosaukumsLv'.");
    }

    @Test
    public void testInvalidNosaukumsLv() {
        kontakti.setNosaukumsLv("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        Set<ConstraintViolation<Kontakti>> violations = validator.validate(kontakti);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'nosaukumsLv'.");
        for (ConstraintViolation<Kontakti> violation : violations) {
            assertEquals("Max allow symbols is 50!", violation.getMessage());
        }
    }

    @Test
    public void testNotNullAnnotations() {
        kontakti.setNosaukumsEn(null);
        kontakti.setNosaukumsLv(null);
        kontakti.setInformacija(null);

        Set<ConstraintViolation<Kontakti>> violations = validator.validate(kontakti);
        assertEquals(3, violations.size());
        for (ConstraintViolation<Kontakti> violation : violations) {
            assertEquals("must not be null", violation.getMessage());
        }
    }

    @Test
    public void testValidInformacija() {
        kontakti.setInformacija("This is valid contact information.");
        Set<ConstraintViolation<Kontakti>> violations = validator.validate(kontakti);
        assertTrue(violations.isEmpty(), "There should be no violations for 'informacija'.");
    }

    @Test
    public void testInvalidInformacija() {
        kontakti.setInformacija("11111111111114444444444444444444444444444444444444444444411111111111111111111111111111111111111111111111111112222222222222222222222222222222222222222222222222222222222222222222222222222211111111111111111111111111111111111111111111111111133333333333333333333333333333");
        Set<ConstraintViolation<Kontakti>> violations = validator.validate(kontakti);
        assertFalse(violations.isEmpty(), "There should be violations for 'informacija'.");
        for (ConstraintViolation<Kontakti> violation : violations) {
            assertEquals("Max allow symbols is 50!", violation.getMessage());
        }
    }
}
