package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.MainPage_ParMums;

@Repository
public interface IMainPageParMumsRepo extends CrudRepository<MainPage_ParMums, Integer> {
	
	
}
