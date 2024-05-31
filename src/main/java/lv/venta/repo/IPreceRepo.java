package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Veikals_prece;

public interface IPreceRepo extends CrudRepository<Veikals_prece, Integer> {
    
    Veikals_prece findByIdvp(int idvp);



}