package lv.venta.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InformacijaTest {

    private Validator validator;
    private Informacija informacija;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        informacija = new Informacija(
            "Event Info",
            "Pasākuma informācija",
            "informational description for event.",
            "Šis ir informatīvs apraksts pasākumam.",
            "https://visit.jekabpils.lv/uploads/posts/large_63-839f3a6ee9.jpg"
        );
    }

    @Test
    public void testValidNosaukumsEn() {
        informacija.setNosaukumsEn("Valid Name");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertTrue(violations.isEmpty(), "There should be no violations for 'nosaukumsEn'.");
    }

    @Test
    public void testInvalidNosaukumsEn() {
        informacija.setNosaukumsEn("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertFalse(violations.isEmpty(), "There should be violations for 'nosaukumsEn'.");
        for (ConstraintViolation<Informacija> violation : violations) {
            assertEquals("Max allow symbols is 55!", violation.getMessage());
        }
    }

    @Test
    public void testValidNosaukumsLv() {
        informacija.setNosaukumsLv("Derīgs nosaukums");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'nosaukumsLv'.");
    }

    @Test
    public void testInvalidNosaukumsLv() {
        informacija.setNosaukumsLv("11111111111111111111111111111111111111111111111111133333333333333333333333333333");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'nosaukumsLv'.");
        for (ConstraintViolation<Informacija> violation : violations) {
            assertEquals("Max allow symbols is 55!", violation.getMessage());
        }
    }

    @Test
    public void testNotNullAnnotations() {
        informacija.setNosaukumsEn(null);
        informacija.setNosaukumsLv(null);
        informacija.setAprakstsEn(null);
        informacija.setAprakstsLv(null);

        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertEquals(4, violations.size());
        for (ConstraintViolation<Informacija> violation : violations) {
            assertEquals("must not be null", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsEn() {
        informacija.setAprakstsEn("This is a valid description.");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertTrue(violations.isEmpty(), "There should be no violations for 'aprakstsEn'.");
    }

    @Test
    public void testInvalidAprakstsEn() {
        informacija.setAprakstsEn("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertFalse(violations.isEmpty(), "There should be violations for 'aprakstsEn'.");
        for (ConstraintViolation<Informacija> violation : violations) {
            assertEquals("Max allow symbols is 250!", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsLv() {
        informacija.setAprakstsLv("Šis ir derīgs apraksts.");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'aprakstsLv'.");
    }

    @Test
    public void testInvalidAprakstsLv() {
        informacija.setAprakstsLv("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'aprakstsLv'.");
        for (ConstraintViolation<Informacija> violation : violations) {
            assertEquals("Max allow symbols is 250!", violation.getMessage());
        }
    }

    @Test
    public void testValidBildesUrl() {
        informacija.setBildesUrl("https://visit.jekabpils.lv/uploads/posts/large_63-839f3a6ee9.jpg");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertTrue(violations.isEmpty(), "There should be no violations for 'bildesUrl'.");
    }

    @Test
    public void testInvalidBildesUrl() {
        informacija.setBildesUrl("invalid-urla");
        Set<ConstraintViolation<Informacija>> violations = validator.validate(informacija);
        assertFalse(violations.isEmpty(), "There should be violations for 'bildesUrl'.");
        for (ConstraintViolation<Informacija> violation : violations) {
            assertEquals("must be a valid URL", violation.getMessage());
        }
    }

}
