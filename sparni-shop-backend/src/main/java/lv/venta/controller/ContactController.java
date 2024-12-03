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

import lv.venta.model.Contacts;
import lv.venta.service.IContactCRUDService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("kontakti")
public class ContactController {

    @Autowired
    private final IContactCRUDService kontaktiService;

    public ContactController(IContactCRUDService kontaktiService) {
        this.kontaktiService = kontaktiService;
    }

    @PostMapping
    public ResponseEntity<String> createKontakti(@RequestBody Contacts kontakti) {
        kontaktiService.create(kontakti);
        return ResponseEntity.status(HttpStatus.CREATED).body("Kontakti created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacts> retrieveKontaktiById(@PathVariable int id) {
        try {
            Contacts kontakti = kontaktiService.retrieveById(id);
            return ResponseEntity.ok(kontakti);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contacts>> retrieveAllKontakti() {
        List<Contacts> allKontakti = null;
        try {
            allKontakti = kontaktiService.retrieveAll();
        } catch (Exception ex) {
        }
        return ResponseEntity.ok(allKontakti);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateKontaktiById(@PathVariable int id, @RequestBody Contacts kontakti) {
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
