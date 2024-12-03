package lv.venta.repo;


import java.time.LocalDateTime;
import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Event;

public interface IEventRepo extends CrudRepository<Event, Integer> {
    
    Event findByIdPasakumi(int idPasakumi);
    ArrayList<Event> findByIdPasakumiKategorijas_Idpk(int idpk);
    ArrayList<Event> findByNosaukumsContainingIgnoreCaseOrAprakstsContainingIgnoreCase(String nosaukums, String apraksts);
    ArrayList<Event> findBySakumaDatumsBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    
}
