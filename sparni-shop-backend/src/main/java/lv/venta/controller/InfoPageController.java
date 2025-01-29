package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lv.venta.model.Informacija;
import lv.venta.service.IInformacijaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("informacija")
public class InfoPageController {

    @Autowired
    private IInformacijaService crudService;

    @GetMapping("/all")
    public ResponseEntity<ArrayList<Informacija>> getInfoAll() {
        try {
            ArrayList<Informacija> info = crudService.retrieveAll();
            if (info.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Informacija> getInformacijaById(@PathVariable int id) {
        try {
            Informacija informacija = crudService.retrieveById(id);
            return ResponseEntity.ok(informacija);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> postInformacijaAdd(@Valid @RequestBody Informacija informacija) {
        try {
            crudService.create(informacija);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Void> getInformacijaUpdateById(@PathVariable int id) {
        try {
            crudService.retrieveById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Void> postInformacijaUpdateById(@PathVariable int id, @Valid @RequestBody Informacija informacija) {
        try {
            crudService.updateById(id, informacija);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> getInformacijaDeleteById(@PathVariable int id) {
        try {
            crudService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
