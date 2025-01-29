package lv.venta.model;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PasakumiTest {

    private Validator validator;
    private Pasakumi pasakumi;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Pasakumi_kategorijas kategorija = new Pasakumi_kategorijas();
        LocalDateTime sakumaDatums = LocalDateTime.now();
        LocalDateTime beiguDatums = sakumaDatums.plusHours(2);
        
        pasakumi = new Pasakumi(
            kategorija,
            sakumaDatums,
            beiguDatums,
            "Go to Event",
            "Ejam uz pasākumu",
            LocalDateTime.now(),
            "Kaut kur",
            "Tralala i don't know what to write!I hope it works!",
            "Lūdzu nāciet uz pašakumu! Būs pīrādziņi, un tā tālāk!",
            "https://visit.jekabpils.lv/uploads/posts/large_63-839f3a6ee9.jpg"
        );
    }

    @Test
    public void testValidNosaukumsEn() {
        pasakumi.setNosaukumsEn("Man Garšo ēst");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertTrue(violations.isEmpty(), "There should be no violations for 'nosaukumsEn'.");
    }

    @Test
    public void testInvalidNosaukumsEn() {
        pasakumi.setNosaukumsEn("aw natf 7mart 42erhzzzzzzzzzzzzzzzzzzzzzzzrdddddwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertFalse(violations.isEmpty(), "There should be violations for 'nosaukumsEn'.");
        for (ConstraintViolation<Pasakumi> violation : violations) {
            assertEquals("Max allow symbols is 55!", violation.getMessage());
        }
    }

    @Test
    public void testValidNosaukumsLv() {
        pasakumi.setNosaukumsLv("Derīgs nosaukums");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļudas 'nosaukumsLv'.");
    }

    @Test
    public void testInvalidNosaukumsLv() {
        pasakumi.setNosaukumsLv("Nederīgs Nosaukumseeeeeeeeeeeeeqqqqqqqqqqqqqqqqqqqqqqqqqqqqqyyy");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai  'nosaukumsLv'.");
        for (ConstraintViolation<Pasakumi> violation : violations) {
            assertEquals("Maksimums atļauto simbolu is 55!", violation.getMessage());
        }
    }

    @Test
    public void testNotNullAnnotations() {
        pasakumi.setNosaukumsEn(null);
        pasakumi.setNosaukumsLv(null);
        pasakumi.setAprakstsEn(null);
        pasakumi.setAprakstsLv(null);

        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertEquals(4, violations.size());
        for (ConstraintViolation<Pasakumi> violation : violations) {
            assertEquals("must not be null", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsEn() {
        pasakumi.setAprakstsEn("This is a valid description.");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertTrue(violations.isEmpty(), "There should be no violations for 'aprakstsEn'.");
    }

    @Test
    public void testInvalidAprakstsEn() {
        pasakumi.setAprakstsEn("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertFalse(violations.isEmpty(), "There should be violations for 'aprakstsEn'.");
        for (ConstraintViolation<Pasakumi> violation : violations) {
            assertEquals("Max allow symbols is 250!", violation.getMessage());
        }
    }

    @Test
    public void testValidAprakstsLv() {
        pasakumi.setAprakstsLv("Šis ir derīgs apraksts.");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertTrue(violations.isEmpty(), "Šeit nevajadzētu būt kļudas 'aprakstsLv'.");
    }

    @Test
    public void testInvalidAprakstsLv() {
        pasakumi.setAprakstsLv("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Pasakumi>> violations = validator.validate(pasakumi);
        assertFalse(violations.isEmpty(), "Šeit vajadzētu būt kļūdai 'aprakstsLv'.");
        for (ConstraintViolation<Pasakumi> violation : violations) {
            assertEquals("Maksimums atļauto simbolu is 250!", violation.getMessage());
        }
    }
}
