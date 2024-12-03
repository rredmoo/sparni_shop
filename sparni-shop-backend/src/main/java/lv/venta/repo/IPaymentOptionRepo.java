package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;


import lv.venta.model.PaymentOption;
import lv.venta.model.Product;

public interface IPaymentOptionRepo extends CrudRepository<PaymentOption, Integer>{

    Product findByIdsv(int idsv);
} 
