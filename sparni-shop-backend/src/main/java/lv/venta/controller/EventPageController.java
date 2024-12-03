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
import lv.venta.model.Event;
import lv.venta.model.EventsCategory;
import lv.venta.repo.IEventRepo;
import lv.venta.service.IEventCRUDService;
import lv.venta.service.IEventCategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("pasakumi")
public class EventPageController {

    @Autowired
    private IEventCRUDService crudService;

	@Autowired
    private IEventCategoryService kategorijasService;


	 @Autowired
    private IEventRepo pasakumiRepo;


	@GetMapping("/all")
    public ArrayList<Event> getPasakumiCRUDAll() {
        try {
            return crudService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/all/{id}") 
	public Event getPasakumiById(@PathVariable int id) {
		try {
			return crudService.retrieveById(id);
		} catch (Exception e) {
			return null;
		}
	}

 
	@PostMapping("/add")
	public void postPasakumiAdd(@Valid Event pasakums) {
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
	public void postPasakumiUpdateById(@PathVariable int id, @Valid Event pasakumi) {
		
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
    public ArrayList<Event> getPasakumiByCategoryId(@PathVariable int categoryId) {
        try {
            return crudService.retrieveByCategoryId(categoryId); 
        } catch (Exception e) {
            return null;
        }
	
	}

	  @GetMapping("/categories")
    public ArrayList<EventsCategory> getAllCategories() {
        return kategorijasService.retrieveAllCategories();
    }

	@GetMapping("/search")
	public ArrayList<Event> searchEvents(@RequestParam("term") String term) {
    try {
       
        ArrayList<Event> events = pasakumiRepo.findByNosaukumsContainingIgnoreCaseOrAprakstsContainingIgnoreCase(term, term);

        
        return new ArrayList<>(events);
    } catch (Exception e) {
       
        System.err.println("Error: " + e.getMessage());
        return new ArrayList<>();  
    }
}

 @GetMapping("/filter-by-date")
    public ResponseEntity<ArrayList<Event>> getEventsByDate(@RequestParam("date") String dateString) {
        try {
            
            LocalDate date = LocalDate.parse(dateString);

            
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime endOfDay = date.atTime(23, 59, 59);

            
            ArrayList<Event> events = crudService.retrieveByLaiks(startOfDay, endOfDay);

            
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            return ResponseEntity.status(500).build(); 
        }
    }

}
