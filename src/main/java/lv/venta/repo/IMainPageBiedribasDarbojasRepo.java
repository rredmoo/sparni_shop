package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.MainPage_BiedribaDarbojas;

@Repository
public interface IMainPageBiedribasDarbojasRepo extends CrudRepository< MainPage_BiedribaDarbojas , Integer> {
	
	
}
