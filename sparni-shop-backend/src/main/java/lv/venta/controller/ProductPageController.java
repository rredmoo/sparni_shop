package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.model.Atlaide;
import lv.venta.service.IAtlaideService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("veikals")
public class ProductPageController {

    @Autowired
    private IAtlaideService atlaideService;

    @GetMapping("/all")
    public ArrayList<Atlaide> getPreceCRUDAll() {
        try {
            return atlaideService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }
}
