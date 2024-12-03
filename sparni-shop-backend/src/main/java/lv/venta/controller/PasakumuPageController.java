package lv.venta.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lv.venta.model.Pasakumi;
import lv.venta.model.Pasakumi_kategorijas;
import lv.venta.repo.IPasakumiRepo;
import lv.venta.service.IPasakumiCRUDService;
import lv.venta.service.IPasakumiKategorijasService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("pasakumi")
public class PasakumuPageController {

    @Autowired
    private IPasakumiCRUDService crudService;

	@Autowired
    private IPasakumiKategorijasService kategorijasService;


	 @Autowired
    private IPasakumiRepo pasakumiRepo;


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

	@GetMapping("/sort/category/{categoryId}")
    public ArrayList<Pasakumi> getPasakumiByCategoryId(@PathVariable int categoryId) {
        try {
            return crudService.retrieveByCategoryId(categoryId); 
        } catch (Exception e) {
            return null;
        }
	
	}

	  @GetMapping("/categories")
    public ArrayList<Pasakumi_kategorijas> getAllCategories() {
        return kategorijasService.retrieveAllCategories();
    }

	@GetMapping("/search")
	public ArrayList<Pasakumi> searchEvents(String term) {
    try {
       
        ArrayList<Pasakumi> events = pasakumiRepo.findByNosaukumsLvContainingIgnoreCaseOrNosaukumsEnContainingIgnoreCase(term, term);

        
        return new ArrayList<>(events);
    } catch (Exception e) {
       
        System.err.println("Error: " + e.getMessage());
        return new ArrayList<>();  
    }
}

 @GetMapping("/filter-by-date")
    public ResponseEntity<ArrayList<Pasakumi>> getEventsByDate(@RequestParam("date") String dateString) {
        try {
            
            LocalDate date = LocalDate.parse(dateString);

            
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime endOfDay = date.atTime(23, 59, 59);

            
            ArrayList<Pasakumi> events = crudService.retrieveByLaiks(startOfDay, endOfDay);

            
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            return ResponseEntity.status(500).build(); 
        }
    }

}