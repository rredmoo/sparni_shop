package lv.venta.controller;

import java.sql.Driver;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.model.Veikals_prece;
import lv.venta.repo.IPreceRepo;
import lv.venta.service.IPreceCRUDService;

@Controller
@RequestMapping("veikals")
public class ProductPageController {

    // @Autowired
    // private IPreceRepo preceRepo;

    // @Autowired
    // private IPreceCRUDService preceCRUDService;

    @GetMapping("/all")
    public String getPreceCRUDAll(Model model) {

        try {
            // ArrayList<Veikals_prece> alldrivers = preceCRUDService.retrieveAll();
            // model.addAttribute("mydata", alldrivers);
            // model.addAttribute("msg", "All Drivers");
            return "error-page";
        } catch (Exception e) {
            model.addAttribute("mydata", e.getMessage());
            return "error-page";
        }
    }

    // @GetMapping("/all/{id}")
    // public String getDriverCRUDByID(@PathVariable("id") int id, Model model) {

    //     try {
    //         Driver driver = preceCRUDService.retrieveById(id);
    //         long driverCount = driverRepo.count();
    //         model.addAttribute("mydata", driver);
    //         model.addAttribute("msg",
    //                 "Driver: " + driver.getFirstName() + " " + driver.getLastName() + " with ID: " + driver.getIdp());
    //         model.addAttribute("totalDriverCount",
    //                 "Total driver count: " + driverCount + "<br>To check other drivers click on the button below");
    //         return "driver-show-all";
    //     } catch (Exception e) {
    //         model.addAttribute("mydata", e.getMessage());
    //         return "error-page";
    //     }
    // }

    // @GetMapping("/remove/{id}")
    // public String getDriverCRUDDeleteById(@PathVariable("id") int id, Model model) {

    //     try {
    //         preceCRUDService.deleteById(id);
    //         ArrayList<Driver> alldrivers = preceCRUDService.retrieveAll();
    //         model.addAttribute("mydata", alldrivers);
    //         return "driver-show-all";
    //     } catch (Exception e) {
    //         model.addAttribute("mydata", e.getMessage());
    //         return "error-page";
    //     }

    // }

    // @GetMapping("/add")
    // public String getDriverAdd(Model model) {
    //     model.addAttribute("driver", new Driver());
    //     return "driver-add-page";
    // }

    // @PostMapping("/add")
    // public String postProductCRUDInsert(@Valid Driver driver, BindingResult result) {
    //     if (result.hasErrors()) {
    //         return "driver-add-page";
    //     } else {
    //         preceCRUDService.create(driver);
    //         return "redirect:/driver/show/all";
    //     }
    // }

    // @GetMapping("/update/{id}")
    // public String getDriverUpdateById(@PathVariable("id") int id, Model model) {
    //     try {
    //         Driver driverForUpdating = preceCRUDService.retrieveById(id);
    //         model.addAttribute("driver", driverForUpdating);
    //         model.addAttribute("id", id);
    //         return "driver-update-page";
    //     } catch (Exception e) {
    //         model.addAttribute("mydata", e.getMessage());
    //         return "error-page";
    //     }
    // }

    // @PostMapping("/update/{id}")
    // public String postDriverUpdateById(@PathVariable("id") int id, @Valid Driver driver, BindingResult result,
    //         Model model) {
    //     if (result.hasErrors()) {
    //         return "driver-update-page";
    //     } else {

    //         try {
    //             preceCRUDService.updateById(id, driver);
    //             return "redirect:/driver/show/all/" + id;
    //         } catch (Exception e) {
    //             model.addAttribute("mydata", e.getMessage());
    //             return "error-page";
    //         }
    //     }

    // }
}
