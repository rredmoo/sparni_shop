package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.DeliveryOptions;
import lv.venta.model.Product;

public interface IDeliveryOptionsRepo extends CrudRepository<DeliveryOptions, Integer>{

    Product findByIdPiegadesVeids(int idPiegadesVeids);
} 
