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
import lv.venta.model.Information;

import lv.venta.service.IInformationService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("informacija")
public class InfoPageController {

    @Autowired
    private IInformationService crudService;

	@GetMapping("/all")
    public ArrayList<Information> getInfoAll() {
        try {
            return crudService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/all/{id}") 
	public Information getInformacijaById(@PathVariable int id) {
		try {
			return crudService.retrieveById(id);
		} catch (Exception e) {
			return null;
		}
	}

 
	@PostMapping("/add")
	public void postInformacijaAdd(@Valid Information informacija) {
		try{
			crudService.create(informacija);
		}catch (Exception e){

		}
	}


    @GetMapping("/update/{id}")  
	public void getInformacijaUpdateById(@PathVariable int id) {
		try {
			
			crudService.retrieveById(id);
		} catch (Exception e) {
			
		}
	}

	@PostMapping("/update/{id}")
	public void postInformacijaUpdateById(@PathVariable int id, @Valid Information informacija) {
		
			try {
				crudService.updateById(id,informacija);
			} catch (Exception e) {
			
			}
		}

	
	
	@GetMapping("/delete/{id}")
	public void getInformacijaDeleteById(@PathVariable int id) {
		
		try {
			
			crudService.deleteById(id);
		} catch (Exception e) {
	
		}
		
	}
}
