package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Pasakumi_kategorijas;
import lv.venta.model.Veikals_prece;

public interface IPasakumiKategorijasRepo extends CrudRepository<Pasakumi_kategorijas, Integer>{

    Veikals_prece findByIdpk(int idpk);
} 
