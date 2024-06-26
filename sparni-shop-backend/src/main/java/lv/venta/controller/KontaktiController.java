package lv.venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.model.Kontakti;
import lv.venta.service.IKontaktiCRUDService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/kontakti")
public class KontaktiController {

    @Autowired
    private final IKontaktiCRUDService kontaktiService;

    public KontaktiController(IKontaktiCRUDService kontaktiService) {
        this.kontaktiService = kontaktiService;
    }

    @PostMapping
    public ResponseEntity<String> createKontakti(@RequestBody Kontakti kontakti) {
        kontaktiService.create(kontakti);
        return ResponseEntity.status(HttpStatus.CREATED).body("Kontakti created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kontakti> retrieveKontaktiById(@PathVariable int id) {
        try {
            Kontakti kontakti = kontaktiService.retrieveById(id);
            return ResponseEntity.ok(kontakti);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Kontakti>> retrieveAllKontakti() {
        List<Kontakti> allKontakti = null;
        try {
            allKontakti = kontaktiService.retrieveAll();
        } catch (Exception ex) {
        }
        return ResponseEntity.ok(allKontakti);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateKontaktiById(@PathVariable int id, @RequestBody Kontakti kontakti) {
        try {
            kontaktiService.updateById(id, kontakti);
            return ResponseEntity.ok("Kontakti updated successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKontaktiById(@PathVariable int id) {
        try {
            kontaktiService.deleteById(id);
            return ResponseEntity.ok("Kontakti deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
