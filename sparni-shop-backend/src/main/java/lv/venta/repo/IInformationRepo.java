package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Information;


public interface IInformationRepo extends CrudRepository<Information, Integer> {
    
    Information findById(int id);

}
