package lv.venta.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import lv.venta.model.Informacija;
import lv.venta.service.IInformacijaService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InfoPageController.class)
public class InfoPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IInformacijaService crudService;

    private Informacija informacija;

    @BeforeEach
    public void setUp() {
        informacija = new Informacija(
            "Event Info",
            "Pasākuma informācija",
            "informational description for event.",
            "Šis ir informatīvs apraksts pasākumam.",
            "https://visit.jekabpils.lv/uploads/posts/large_63-839f3a6ee9.jpg"
        );
    }

    @Test
    public void testGetInfoAll() throws Exception {
        ArrayList<Informacija> infoList = new ArrayList<>();
        infoList.add(informacija);

        when(crudService.retrieveAll()).thenReturn(infoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/informacija/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nosaukumsEn").value(informacija.getNosaukumsEn()));

        verify(crudService, times(1)).retrieveAll();
    }

    @Test
    public void testGetInformacijaById() throws Exception {
        when(crudService.retrieveById(informacija.getId_info())).thenReturn(informacija);

        mockMvc.perform(MockMvcRequestBuilders.get("/informacija/all/{id}", informacija.getId_info()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nosaukumsEn").value(informacija.getNosaukumsEn()));

        verify(crudService, times(1)).retrieveById(informacija.getId_info());
    }

    @Test
    public void testPostInformacijaAdd() throws Exception {
        doNothing().when(crudService).create(any(Informacija.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/informacija/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(informacija)))
                .andExpect(status().isCreated());

        verify(crudService, times(1)).create(any(Informacija.class));
    }

    @Test
    public void testGetInformacijaUpdateById() throws Exception {
        when(crudService.retrieveById(informacija.getId_info())).thenReturn(informacija);

        mockMvc.perform(MockMvcRequestBuilders.get("/informacija/update/{id}", informacija.getId_info()))
                .andExpect(status().isOk());

        verify(crudService, times(1)).retrieveById(informacija.getId_info());
    }

    @Test
    public void testPostInformacijaUpdateById() throws Exception {
        doNothing().when(crudService).updateById(anyInt(), any(Informacija.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/informacija/update/{id}", informacija.getId_info())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(informacija)))
                .andExpect(status().isOk());

        verify(crudService, times(1)).updateById(anyInt(), any(Informacija.class));
    }

    @Test
    public void testGetInformacijaDeleteById() throws Exception {
        doNothing().when(crudService).deleteById(informacija.getId_info());

        mockMvc.perform(MockMvcRequestBuilders.get("/informacija/delete/{id}", informacija.getId_info()))
                .andExpect(status().isOk());

        verify(crudService, times(1)).deleteById(informacija.getId_info());
    }
}
