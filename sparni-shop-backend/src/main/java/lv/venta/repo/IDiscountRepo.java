package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Discount;
import java.util.ArrayList;


public interface IDiscountRepo extends CrudRepository<Discount, Integer> {

    Discount findByIda(int ida);
    Discount findByAtlaidesApmers(int atlaidesApmers);
    ArrayList<Discount> findByAtlaidesApmersGreaterThan(int atlaidesApmers);
    ArrayList<Discount> findByAtlaidesApmersLessThan(int atlaidesApmers);
    

}