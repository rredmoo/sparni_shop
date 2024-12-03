package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.StoreCategory;

public interface IStoreCategoryRepo extends CrudRepository<StoreCategory, Integer> {
    
	StoreCategory findByIdvk(int idvk);



}