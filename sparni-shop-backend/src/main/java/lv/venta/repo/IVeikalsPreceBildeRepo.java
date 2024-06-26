package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Veikals_kategorijas;
import lv.venta.model.Veikals_prece_bildes;

public interface IVeikalsPreceBildeRepo extends CrudRepository<Veikals_prece_bildes, Integer> {
    
	Veikals_kategorijas findByIdvpb(int idvpb);

}