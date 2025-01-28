package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Basket;

public interface IBasketRepo extends CrudRepository<Basket, Integer> {

}