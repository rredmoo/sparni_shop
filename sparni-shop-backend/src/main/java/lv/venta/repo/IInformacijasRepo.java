package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Informacija;


public interface IInformacijasRepo extends CrudRepository<Informacija, Integer> {
    
    Informacija findById(int id);

}
