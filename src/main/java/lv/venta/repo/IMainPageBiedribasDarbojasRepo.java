package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.MainPage_BiedribaDarbojas;

@Repository
public interface IMainPageBiedribasDarbojasRepo extends CrudRepository< MainPage_BiedribaDarbojas , Integer> {
	
	
	MainPage_BiedribaDarbojas findByNosaukums(String nosaukums);
	
	ArrayList<MainPage_BiedribaDarbojas> findByAprakstsContaining(String keyword);
	
	int countByDalibniekuSkaitsGreaterThan(int minParticipants);
	
	
}
