package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Informacijas_lapa;

public interface InformacijasLapaRepo extends CrudRepository<Informacijas_lapa, Integer> {

    Informacijas_lapa findByIdil(int idil);

}
