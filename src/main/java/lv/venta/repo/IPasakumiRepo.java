package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Pasakumi;

public interface IPasakumiRepo extends CrudRepository<Pasakumi, Integer> {
    
    Pasakumi findByIdPasakumi(int idPasakumi);

}
