package lv.venta.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lv.venta.model.Veikals_prece;
import lv.venta.service.IPreceCRUDService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("veikals")
public class ProductPageController {

    @Autowired
    private IPreceCRUDService preceCRUDService;

    @GetMapping("/all")
    public ArrayList<Veikals_prece> getPreceCRUDAll() {
        try {
            return preceCRUDService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }
}
