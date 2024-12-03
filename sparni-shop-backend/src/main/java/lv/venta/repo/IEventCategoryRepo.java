package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.EventsCategory;



public interface IEventCategoryRepo extends CrudRepository<EventsCategory, Integer>{


    ArrayList<EventsCategory> findAll();
    EventsCategory findByIdpk(int idpk);
} 

