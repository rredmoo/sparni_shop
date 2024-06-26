package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Informacijas_lapa;

public interface IInformacijasLapaRepo extends CrudRepository<Informacijas_lapa, Integer> {

    Informacijas_lapa findByID_InformacijasLapa(int ID_InformacijasLapa);

}
