package lv.venta.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Veikals_preceTest {

    private Validator validator;
    private Veikals_prece veikalsPrece;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Pirkums_Elements pirkumsElements = new Pirkums_Elements();
        
        
        Veikals_kategorijas kategorija = Veikals_kategorijas.Bikses; 
       
        
        Atlaide atlaide = new Atlaide();

        veikalsPrece = new Veikals_prece(
            "Coat",
            "Jakas",
            "English.",
            "Latviski.",
            10,
            50.0f,
            pirkumsElements,
            List.of(kategorija),
            "https://visit.jekabpils.lv/uploads/posts/large_63-839f3a6ee9.jpg",
            atlaide
        );
    }

    @Test
    public void testValidNosaukumsEn() {
        veikalsPrece.setNosaukumsEn("Valid");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertTrue(violations.isEmpty(), "There should be no violations for 'nosaukumsEn'.");
    }

    @Test
    public void testInvalidNosaukumsEn() {
        veikalsPrece.setNosaukumsEn("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertFalse(violations.isEmpty(), "There should be violations for 'nosaukumsEn'.");
        for (ConstraintViolation<Veikals_prece> violation : violations) {
            assertEquals("Max allow symbols is 55!", violation.getMessage());
        }
    }

    @Test
    public void testValidNosaukumsLv() {
        veikalsPrece.setNosaukumsLv("Derīgs");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'nosaukumsLv'.");
    }

    @Test
    public void testInvalidNosaukumsLv() {
        veikalsPrece.setNosaukumsLv("11111111111111111111111111111111111111111111111111133333333333333333333333333333");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'nosaukumsLv'.");
        for (ConstraintViolation<Veikals_prece> violation : violations) {
            assertEquals("Max allow symbols is 55!", violation.getMessage());
        }
    }

    @Test
    public void testValidDaudzums() {
        veikalsPrece.setDaudzums(10);
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertTrue(violations.isEmpty(), "There should be no violations for 'daudzums'.");
    }

    @Test
    public void testInvalidDaudzums() {
        veikalsPrece.setDaudzums(600);
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertFalse(violations.isEmpty(), "There should be violations for 'daudzums'.");
        for (ConstraintViolation<Veikals_prece> violation : violations) {
            assertEquals("must be less than or equal to 500", violation.getMessage());
        }
    }

    @Test
    public void testValidCena() {
        veikalsPrece.setCena(50.0f);
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertTrue(violations.isEmpty(), "There should be no violations for 'cena'.");
    }

    @Test
    public void testInvalidCena() {
        veikalsPrece.setCena(1500.0f);
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertFalse(violations.isEmpty(), "There should be violations for 'cena'.");
        for (ConstraintViolation<Veikals_prece> violation : violations) {
            assertEquals("must be less than or equal to 1000", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsEn() {
        veikalsPrece.setAprakstsEn("Valid description.");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertTrue(violations.isEmpty(), "There should be no violations for 'aprakstsEn'.");
    }

    @Test
    public void testInvalidAprakstsEn() {
        veikalsPrece.setAprakstsEn("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertFalse(violations.isEmpty(), "There should be violations for 'aprakstsEn'.");
        for (ConstraintViolation<Veikals_prece> violation : violations) {
            assertEquals("Max allow symbols is 255!", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsLv() {
        veikalsPrece.setAprakstsLv("Šis ir derīgs apraksts.");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļūdas 'aprakstsLv'.");
    }

    @Test
    public void testInvalidAprakstsLv() {
        veikalsPrece.setAprakstsLv("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'aprakstsLv'.");
        for (ConstraintViolation<Veikals_prece> violation : violations) {
            assertEquals("Max allow symbols is 255!", violation.getMessage());
        }
    }

    @Test
    public void testNotNullAnnotations() {
        veikalsPrece.setNosaukumsEn(null);
        veikalsPrece.setNosaukumsLv(null);
        veikalsPrece.setAprakstsEn(null);
        veikalsPrece.setAprakstsLv(null);

        Set<ConstraintViolation<Veikals_prece>> violations = validator.validate(veikalsPrece);
        assertEquals(4, violations.size());
        for (ConstraintViolation<Veikals_prece> violation : violations) {
            assertEquals("must not be null", violation.getMessage());
        }
    }

 
    @Test
    public void testRelationshipWithPirkumsElements() {
        Pirkums_Elements pirkumsElements = new Pirkums_Elements();
        veikalsPrece.setPirkums_Elements(pirkumsElements);
        assertEquals(pirkumsElements, veikalsPrece.getPirkums_Elements(), "Relationship with 'Pirkums_Elements' should be properly managed.");
    }

    @Test
    public void testRelationshipWithVeikalsKategorijas() {
        Veikals_kategorijas kategorija = Veikals_kategorijas.Bikses;
        veikalsPrece.setVeikals_kategorija(List.of(kategorija));

        assertEquals(1, veikalsPrece.getVeikals_kategorija().size(), "Relationship with 'Veikals_kategorijas' should be properly managed.");
    }
}
