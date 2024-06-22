package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Atlaide;
import java.util.List;

public interface IAtlaideRepo extends CrudRepository<Atlaide, Integer> {

    Atlaide findByIda(int ida);

    Atlaide findByAtlaidesApmers(int atlaidesApmers);

}