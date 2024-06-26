package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Informacijas_lapa_informacija;

public interface IInformacijasLapaInformacijaRepo extends CrudRepository<Informacijas_lapa_informacija, Integer> {

    Informacija_lapa findByID_InformacijasLapa_informacija(int ID_InformacijasLapa_informacija);

    ArrayList<Informacijas_lapa_informacija> findByNosaukumsContaining(String keyword);
}