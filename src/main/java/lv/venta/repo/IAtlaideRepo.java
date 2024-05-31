package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Atlaide;

public interface IAtlaideRepo extends CrudRepository<Atlaide, Integer> {
    
    Atlaide findByIda(int ida);



}