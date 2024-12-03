package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.Contacts;

@Repository
public interface IContactRepo extends CrudRepository<Contacts, Integer> {


	ArrayList<Contacts> findByNosaukums(String nosaukums);
	
	ArrayList<Contacts> findByInformacija(String informacija);
	
}
