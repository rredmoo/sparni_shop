package lv.venta.controller;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.model.Veikals_prece;
import lv.venta.service.IPreceCRUDService;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("veikals")
public class ProductPageController {

    @Autowired
    private IPreceCRUDService preceCRUDService;

    @Autowired
    private IPreceCRUDService preceService;

    @GetMapping("/all")
    public ArrayList<Veikals_prece> getPreceCRUDAll() {
        try {
            return preceCRUDService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/prece/{id}")
    public void updatePrece(@PathVariable int id, @RequestBody Veikals_prece prece) {
        try {
            preceService.updateById(id, prece);
        } catch (Exception e) {

        }

    }

    @GetMapping("/prece/all")
    public ArrayList<Veikals_prece> getAllPrece() {
        try {
            return preceService.retrieveAll();
        } catch (Exception e) {

            return null;
        }
    }

    @PostMapping("/prece/create")
    public void createPrece(@RequestBody Veikals_prece prece) {
        try {
            preceService.create(prece);

        } catch (Exception e) {

        }
    }

    @DeleteMapping("/prece/{id}")
    public void deletePreceById(@PathVariable int id) {
        try {
            preceService.deleteById(id);

        } catch (Exception e) {

        }
    }

    @GetMapping("/price/asc")
    public ArrayList<Veikals_prece> getProductsAsc() {
        try {
            return preceService.retrieveAllAsc();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/price/desc")
    public ArrayList<Veikals_prece> getProductsDsc() {
        try {
            return preceService.retrieveAllDsc();
        } catch (Exception e) {
            return null;
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Item not found");
    }

}
