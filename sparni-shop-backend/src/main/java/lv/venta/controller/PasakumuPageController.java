package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lv.venta.model.Pasakumi;
import lv.venta.service.IPasakumiCRUDService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("pasakumi")
public class PasakumuPageController {

    @Autowired
    private IPasakumiCRUDService crudService;

    @GetMapping("/all")
    public String getPasakumiAll(Model model) {
		try {
			ArrayList<Pasakumi> allPasakumi = crudService.retrieveAll();
			model.addAttribute("mydata", allPasakumi);
			model.addAttribute("msg", "Visi pasakumi");
			return "pasakumi-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}


    @GetMapping("/all/{id}") 
	public String getPasakumiById(@PathVariable("id") int id, Model model) {
		try {
			Pasakumi foundPasakums = crudService.retrieveById(id);
			model.addAttribute("mydata", foundPasakums);
			return "pasakumi-one-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}

   @GetMapping("/add") 
	public String getPasakumiAdd(Model model) {

		model.addAttribute("pasakumi", new Pasakumi());
		return "pasakumi-add-page"; 

	}

	@PostMapping("/add")
	public String postPasakumiAdd(@Valid Pasakumi pasakumi, BindingResult result) {
		
		if (result.hasErrors()) {
			return "pasakumi-add-page";
		} else {
			crudService.create(pasakumi);
			return "redirect:/pasakumi/all";
		}

	}


    @GetMapping("/update/{id}") // 
	public String getPasakumiUpdateById(@PathVariable("id") int id, Model model) {
		try {
			Pasakumi pasakumsForUpdating = crudService.retrieveById(id);
			model.addAttribute("pasakumi", pasakumsForUpdating);
			model.addAttribute("id", id);
			return "pasakumi-update-page"; 
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}

	@PostMapping("/update/{id}")
	public String postPasakumiUpdateById(@PathVariable("id") int id, @Valid Pasakumi pasakumi, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "pasakumi-update-page";
		} else {

			try {
				crudService.updateById(id, pasakumi);
				return "redirect:/pasakumi/all/" + id;
			} catch (Exception e) {
				model.addAttribute("mydata", e.getMessage());
				return "error-page";
			}
		}

	}
	
	@GetMapping("/delete/{id}")
	public String getPasakumiDeleteById(@PathVariable("id") int id, Model model) {
		
		try {
			crudService.deleteById(id);
			ArrayList<Pasakumi> allPasakumi= crudService.retrieveAll();
			model.addAttribute("mydata", allPasakumi);
			return "pasakumi-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
		
	}
}
