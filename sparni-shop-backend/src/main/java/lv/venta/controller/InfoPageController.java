package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lv.venta.model.Informacija;

import lv.venta.service.IInformacijaService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("informacija")
public class InfoPageController {

    @Autowired
    private IInformacijaService crudService;

	@GetMapping("/all")
    public ResponseEntity<ArrayList<Informacija>> getInfoAll() {
        try {
            ArrayList<Informacija> info = crudService.retrieveAll();
            if (info.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/all/{id}") 
	public Informacija getInformacijaById(@PathVariable int id) {
		try {
			return crudService.retrieveById(id);
		} catch (Exception e) {
			return null;
		}
	}

 
	@PostMapping("/add")
	public void postInformacijaAdd(@Valid Informacija informacija) {
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
	public void postInformacijaUpdateById(@PathVariable int id, @Valid Informacija informacija) {
		
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
