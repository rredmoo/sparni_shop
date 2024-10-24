package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Pasakumi_kategorijas;



public interface IPasakumiKategorijasRepo extends CrudRepository<Pasakumi_kategorijas, Integer>{


    ArrayList<Pasakumi_kategorijas> findAll();
    Pasakumi_kategorijas findByIdpk(int idpk);
} 

