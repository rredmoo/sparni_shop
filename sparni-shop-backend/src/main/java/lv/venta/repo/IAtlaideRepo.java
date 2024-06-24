package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Atlaide;
import java.util.ArrayList;


public interface IAtlaideRepo extends CrudRepository<Atlaide, Integer> {

    Atlaide findByIda(int ida);
    Atlaide findByAtlaidesApmers(int atlaidesApmers);
    ArrayList<Atlaide> findByAtlaidesApmersGreaterThan(int atlaidesApmers);
    ArrayList<Atlaide> findByAtlaidesApmersLessThan(int atlaidesApmers);
    

}