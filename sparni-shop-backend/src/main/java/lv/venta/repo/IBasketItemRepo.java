package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.BasketItem;

public interface IBasketItemRepo extends CrudRepository<BasketItem, Integer> {

}