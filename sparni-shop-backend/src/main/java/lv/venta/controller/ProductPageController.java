package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.model.Atlaide;
import lv.venta.model.Veikals_prece;
import lv.venta.service.IAtlaideService;
import lv.venta.service.IPreceCRUDService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("veikals")
public class ProductPageController {

    @Autowired
    private IAtlaideService atlaideService;

    @Autowired
    private IPreceCRUDService preceService;

    @GetMapping("/all")
    public ArrayList<Atlaide> getPreceCRUDAll() {
        try {
            return atlaideService.retrieveAll();
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

}
