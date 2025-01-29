package lv.venta.service.impl;

import lv.venta.model.Informacija;
import lv.venta.repo.IInformacijasRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;


public class InformacijasServiceImplTest {

    @Mock
    private IInformacijasRepo informacijasRepo;

    @InjectMocks
    private InformacijasServiceImpl informacijasService;

    private Informacija informacija;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

       
        informacija = new Informacija(
            "Event Info",
            "Pasākuma informācija",
            "informational description for event.",
            "Šis ir informatīvs apraksts pasākumam.",
            "https://visit.jekabpils.lv/uploads/posts/large_63-839f3a6ee9.jpg"
        );
    }

    @Test
    public void testCreate() {

    when(informacijasRepo.save(any(Informacija.class))).thenReturn(informacija);
    informacijasService.create(informacija);

    verify(informacijasRepo, times(1)).save(any(Informacija.class));
}

 
    @Test
    public void testRetrieveById_Success() throws Exception {

        when(informacijasRepo.existsById(1)).thenReturn(true);
        when(informacijasRepo.findById(1)).thenReturn(informacija);

       
        Informacija result = informacijasService.retrieveById(1);

    
        assertNotNull(result);
        assertEquals(informacija.getNosaukumsEn(), result.getNosaukumsEn());
        assertEquals(informacija.getNosaukumsLv(), result.getNosaukumsLv());
    }

    @Test
    public void testRetrieveById_NotFound() {
        
        when(informacijasRepo.existsById(1)).thenReturn(false);

        Exception exception = assertThrows(Exception.class, () -> {
            informacijasService.retrieveById(1);
        });

        assertEquals("Notikusi kļūda, mēģinot iegūt informāciju ar ID 1: Informācija ar šo id (1) neeksistē!", exception.getMessage());
    }

    @Test
    public void testRetrieveAll_Success() throws Exception {
       
        ArrayList<Informacija> informacijasList = new ArrayList<>();
        informacijasList.add(informacija);
        when(informacijasRepo.count()).thenReturn(1L);
        when(informacijasRepo.findAll()).thenReturn(informacijasList);

     
        ArrayList<Informacija> result = informacijasService.retrieveAll();

       
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(informacija, result.get(0));
    }

    @Test
    public void testRetrieveAll_NoInfo() throws Exception {
       
        when(informacijasRepo.count()).thenReturn(0L);

        
        Exception exception = assertThrows(Exception.class, () -> {
            informacijasService.retrieveAll();
        });

        assertEquals("Notikusi kļūda, mēģinot iegūt visas informācijas: Nav nevienas informācijas!", exception.getMessage());
    }

    @Test
    public void testUpdateById_Success() throws Exception {
    
        Informacija updatedInfo = new Informacija(
            "Updated", "Atjaunināts",
            "Updated", "Atjauninats",
            "https://visit.jekabpils.lv/uploads/posts/large_63-839f3a6ee9.jpg"
        );

        when(informacijasRepo.existsById(1)).thenReturn(true);
        when(informacijasRepo.findById(1)).thenReturn(informacija);

        
        informacijasService.updateById(1, updatedInfo);

        verify(informacijasRepo, times(1)).save(any(Informacija.class));
    }

    @Test
    public void testDeleteById_Success() throws Exception {
  
        when(informacijasRepo.existsById(1)).thenReturn(true);
        when(informacijasRepo.findById(1)).thenReturn(informacija);

        informacijasService.deleteById(1);

        verify(informacijasRepo, times(1)).delete(informacija);
    }

    @Test
    public void testDeleteById_NotFound() {
        
        when(informacijasRepo.existsById(1)).thenReturn(false);

       
        Exception exception = assertThrows(Exception.class, () -> {
            informacijasService.deleteById(1);
        });

        assertEquals("Notikusi kļūda, mēģinot dzēst informāciju ar ID 1: Notikusi kļūda, mēģinot iegūt informāciju ar ID 1: Informācija ar šo id (1) neeksistē!", exception.getMessage());
    }
}
