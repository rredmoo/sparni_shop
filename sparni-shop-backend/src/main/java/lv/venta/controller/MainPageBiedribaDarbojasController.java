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

import lv.venta.model.MainPage_BiedribaDarbojas;
import lv.venta.service.IMainPageBiedribasDarbojasCRUDService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mainpage/biedribadarbojas")
public class MainPageBiedribaDarbojasController {

    private final IMainPageBiedribasDarbojasCRUDService biedribaDarbojasService;

    @Autowired
    public MainPageBiedribaDarbojasController(IMainPageBiedribasDarbojasCRUDService biedribaDarbojasService) {
        this.biedribaDarbojasService = biedribaDarbojasService;
    }

    @PostMapping
    public ResponseEntity<String> createBiedribaDarbojas(@RequestBody MainPage_BiedribaDarbojas biedribaDarbojas) {
        biedribaDarbojasService.create(biedribaDarbojas);
        return ResponseEntity.status(HttpStatus.CREATED).body("MainPage_BiedribaDarbojas created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<MainPage_BiedribaDarbojas> retrieveBiedribaDarbojasById(@PathVariable int id) {
        try {
            MainPage_BiedribaDarbojas biedribaDarbojas = biedribaDarbojasService.retrieveById(id);
            return ResponseEntity.ok(biedribaDarbojas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MainPage_BiedribaDarbojas>> retrieveAllBiedribaDarbojas() {
        try {
            List<MainPage_BiedribaDarbojas> allBiedribaDarbojas = biedribaDarbojasService.retrieveAll();
            return ResponseEntity.ok(allBiedribaDarbojas);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBiedribaDarbojasById(@PathVariable int id, @RequestBody MainPage_BiedribaDarbojas biedribaDarbojas) {
        try {
            biedribaDarbojasService.updateById(id, biedribaDarbojas);
            return ResponseEntity.ok("MainPage_BiedribaDarbojas updated successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBiedribaDarbojasById(@PathVariable int id) {
        try {
            biedribaDarbojasService.deleteById(id);
            return ResponseEntity.ok("MainPage_BiedribaDarbojas deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
