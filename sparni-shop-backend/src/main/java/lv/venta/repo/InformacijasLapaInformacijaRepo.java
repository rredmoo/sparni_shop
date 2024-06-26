package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Informacijas_lapa;
import lv.venta.model.Informacijas_lapa_informacija;

public interface InformacijasLapaInformacijaRepo extends CrudRepository<Informacijas_lapa_informacija, Integer> {

    Informacijas_lapa findByIdili(int idili);

    ArrayList<Informacijas_lapa_informacija> findByNosaukumsContaining(String keyword);
}