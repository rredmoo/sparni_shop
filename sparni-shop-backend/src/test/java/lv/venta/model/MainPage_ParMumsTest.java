package lv.venta.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainPage_ParMumsTest {

    private MainPage_ParMums mainPageParMums;
    private Veikals_prece veikalsPrece;
    private Pasakumi pasakumi;
    private MainPage_BiedribaDarbojas mainPageBiedribasDarbojas;
    private Kontakti kontakti;

    @BeforeEach
    public void setUp() {
        veikalsPrece = new Veikals_prece();
        pasakumi = new Pasakumi();
        mainPageBiedribasDarbojas = new MainPage_BiedribaDarbojas();
        kontakti = new Kontakti();
        
        mainPageParMums = new MainPage_ParMums();
        mainPageParMums.setVeikalsPrece(veikalsPrece);
        mainPageParMums.setPasakumi(pasakumi);
        mainPageParMums.setMainPageBiedribasDarbojas(mainPageBiedribasDarbojas);
        mainPageParMums.setKontakti(kontakti);
    }

    @Test
    public void testVeikalsPrece() {
        assertEquals(veikalsPrece, mainPageParMums.getVeikalsPrece());
    }

    @Test
    public void testPasakumi() {
        assertEquals(pasakumi, mainPageParMums.getPasakumi());
    }

    @Test
    public void testMainPageBiedribasDarbojas() {
        assertEquals(mainPageBiedribasDarbojas, mainPageParMums.getMainPageBiedribasDarbojas());
    }

    @Test
    public void testKontakti() {
        assertEquals(kontakti, mainPageParMums.getKontakti());
    }
}
