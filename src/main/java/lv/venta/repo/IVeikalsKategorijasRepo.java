package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Veikals_kategorijas;

public interface IVeikalsKategorijasRepo extends CrudRepository<Veikals_kategorijas, Integer> {
    
	Veikals_kategorijas findByIdvk(int idvk);



}