package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.model.Kontakti;

@Repository
public interface IKontaktiRepo extends CrudRepository<Kontakti, Integer> {


}
