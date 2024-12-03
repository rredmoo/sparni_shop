package lv.venta.repo;


import java.time.LocalDateTime;
import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Pasakumi;

public interface IPasakumiRepo extends CrudRepository<Pasakumi, Integer> {

    Pasakumi findByIdPasakumi(int idPasakumi);

    ArrayList<Pasakumi> findByIdPasakumiKategorijas_Idpk(int idpk);

  
     ArrayList<Pasakumi> findByNosaukumsLvContainingIgnoreCaseOrNosaukumsEnContainingIgnoreCase(String nosaukumsLv, String nosaukumsEn);
   
    ArrayList<Pasakumi> findBySakumaDatumsBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    
}

