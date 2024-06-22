package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Piegades_Veids;
import lv.venta.model.Veikals_prece;

public interface IPiegadesVeidiRepo extends CrudRepository<Piegades_Veids, Integer>{

    Veikals_prece findByIdPiegadesVeids(int idPiegadesVeids);
} 
