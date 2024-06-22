package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.venta.model.Kontakti;

@Repository
public interface IKontaktiRepo extends CrudRepository<Kontakti, Integer> {


	ArrayList<Kontakti> findByNosaukums(String nosaukums);
	
	ArrayList<Kontakti> findByInformacija(String informacija);
	
	@Query("SELECT k FROM Kontakti k WHERE k.nosaukums LIKE %:keyword%")
	ArrayList<Kontakti> findByKeyword(@Param("keyword") String keyword);


	
}
