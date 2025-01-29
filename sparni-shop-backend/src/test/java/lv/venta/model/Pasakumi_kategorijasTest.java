package lv.venta.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Pasakumi_kategorijasTest {

    private Validator validator;
    private Pasakumi_kategorijas pasakumiKategorijas;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        pasakumiKategorijas = new Pasakumi_kategorijas(
            "Latviski jĀ",
            "english Bro",
            "Šis ir pasākuma kategorijas apraksts.",
            "This is an event category description."
        );
    }

    @Test
    public void testValidNosaukumsLv() {
        pasakumiKategorijas.setNosaukumsLv("Labs nosaukums");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'nosaukumsLv'.");
    }

    @Test
    public void testInvalidNosaukumsLv() {
        pasakumiKategorijas.setNosaukumsLv("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'nosaukumsLv'.");
        for (ConstraintViolation<Pasakumi_kategorijas> violation : violations) {
            assertEquals("Max allow symbols is 55!", violation.getMessage());
        }
    }

    @Test
    public void testValidNosaukumsEn() {
        pasakumiKategorijas.setNosaukumsEn("Good");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertTrue(violations.isEmpty(), "There should be no violations for 'nosaukumsEn'.");
    }

    @Test
    public void testInvalidNosaukumsEn() {
        pasakumiKategorijas.setNosaukumsEn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertFalse(violations.isEmpty(), "There should be violations for 'nosaukumsEn'.");
        for (ConstraintViolation<Pasakumi_kategorijas> violation : violations) {
            assertEquals("Max allow symbols is 55!", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsLv() {
        pasakumiKategorijas.setAprakstsLv("Šis ir derīgs apraksts.");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'aprakstsLv'.");
    }

    @Test
    public void testInvalidAprakstsLv() {
        pasakumiKategorijas.setAprakstsLv("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'aprakstsLv'.");
        for (ConstraintViolation<Pasakumi_kategorijas> violation : violations) {
            assertEquals("Max allow symbols is 255!", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsEn() {
        pasakumiKategorijas.setAprakstsEn("This is a valid description.");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertTrue(violations.isEmpty(), "There should be no violations for 'aprakstsEn'.");
    }

    @Test
    public void testInvalidAprakstsEn() {
        pasakumiKategorijas.setAprakstsEn("Invalid*Description!!!");
        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertFalse(violations.isEmpty(), "There should be violations for 'aprakstsEn'.");
        for (ConstraintViolation<Pasakumi_kategorijas> violation : violations) {
            assertEquals("Max allow symbols is 255!", violation.getMessage());
        }
    }

    @Test
    public void testNotNullAnnotations() {
        pasakumiKategorijas.setNosaukumsLv(null);
        pasakumiKategorijas.setNosaukumsEn(null);
        pasakumiKategorijas.setAprakstsLv(null);
        pasakumiKategorijas.setAprakstsEn(null);

        Set<ConstraintViolation<Pasakumi_kategorijas>> violations = validator.validate(pasakumiKategorijas);
        assertEquals(4, violations.size());
        for (ConstraintViolation<Pasakumi_kategorijas> violation : violations) {
            assertEquals("must not be null", violation.getMessage());
        }
    }


}
