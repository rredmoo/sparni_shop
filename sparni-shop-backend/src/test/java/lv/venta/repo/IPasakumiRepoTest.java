package lv.venta.repo;

import lv.venta.model.Pasakumi;
import lv.venta.model.Pasakumi_kategorijas;
import lv.venta.model.Veikals_kategorijas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IPasakumiRepoTest {

    @Autowired
    private IPasakumiRepo pasakumiRepo;

    private Pasakumi pasakumi;

    @BeforeEach
    public void setUp() {
        // Set up the Pasakumi_kategorijas
        
        Pasakumi_kategorijas kategorija = new Pasakumi_kategorijas(); 

        // Set up Pasakumi
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
    public void testFindByIdPasakumi() {
        pasakumiRepo.save(pasakumi);

        Pasakumi found = pasakumiRepo.findByIdPasakumi(pasakumi.getIdPasakumi());
        assertNotNull(found);
        assertEquals(pasakumi.getIdPasakumi(), found.getIdPasakumi());
    }

    @Test
    public void testFindByIdPasakumiKategorijas_Idpk() {
        pasakumiRepo.save(pasakumi);
        List<Pasakumi> foundList = pasakumiRepo.findByIdPasakumiKategorijas_Idpk(pasakumi.getIdPasakumiKategorijas().getIdpk());
        assertFalse(foundList.isEmpty());
    }

    @Test
    public void testFindByNosaukumsLvContainingIgnoreCaseOrNosaukumsEnContainingIgnoreCase() {
        pasakumiRepo.save(pasakumi);

        List<Pasakumi> foundList = pasakumiRepo.findByNosaukumsLvContainingIgnoreCaseOrNosaukumsEnContainingIgnoreCase("Event", "Go");
        assertFalse(foundList.isEmpty());
        assertTrue(foundList.size() > 0);
    }

    @Test
    public void testFindBySakumaDatumsBetween() {
        pasakumiRepo.save(pasakumi);
        LocalDateTime startOfDay = LocalDateTime.now().minusDays(1);
        LocalDateTime endOfDay = LocalDateTime.now().plusDays(1);

        List<Pasakumi> foundList = pasakumiRepo.findBySakumaDatumsBetween(startOfDay, endOfDay);
        assertFalse(foundList.isEmpty());
    }
}
