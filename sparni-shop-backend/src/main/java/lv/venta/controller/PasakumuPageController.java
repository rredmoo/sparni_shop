package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ArrayList<Pasakumi> getPasakumiCRUDAll() {
        try {
            return crudService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/all/{id}") 
	public Pasakumi getPasakumiById(@PathVariable int id) {
		try {
			return crudService.retrieveById(id);
		} catch (Exception e) {
			return null;
		}
	}

 
	@PostMapping("/add")
	public void postPasakumiAdd(@Valid Pasakumi pasakums) {
		try{
			crudService.create(pasakums);
		}catch (Exception e){

		}
	}


    @GetMapping("/update/{id}")  
	public void getPasakumiUpdateById(@PathVariable int id) {
		try {
			
			crudService.retrieveById(id);
		} catch (Exception e) {
			
		}
	}

	@PostMapping("/update/{id}")
	public void postPasakumiUpdateById(@PathVariable int id, @Valid Pasakumi pasakumi) {
		
			try {
				crudService.updateById(id,pasakumi);
			} catch (Exception e) {
			
			}
		}

	
	
	@GetMapping("/delete/{id}")
	public void getPasakumiDeleteById(@PathVariable int id) {
		
		try {
			
			crudService.deleteById(id);
		} catch (Exception e) {
	
		}
		
	}
}
