package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.venta.model.MainPage_ParMums;

@Repository
public interface IMainPageParMumsRepo extends CrudRepository<MainPage_ParMums, Integer> {
	
	
	ArrayList<MainPage_ParMums> findByIdmppm(int idmppm);

	ArrayList<MainPage_ParMums> findByIdmppmAndSomeOtherField(int idmppm, String someOtherFieldValue);
	
	@Query("SELECT m FROM MainPage_ParMums m WHERE m.someField = :value")
	ArrayList<MainPage_ParMums> findBySomeField(@Param("value") String value);

	int countBySomeField(String value);
	
}
