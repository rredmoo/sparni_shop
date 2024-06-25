package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lv.venta.model.Veikals_kategorijas;
import lv.venta.repo.IVeikalsKategorijasRepo;
import lv.venta.service.IVeikalsKategorijasCRUDSerivce;

@Service
public class kategorijasServiceImpl implements IVeikalsKategorijasCRUDSerivce {

    @Autowired
    private IVeikalsKategorijasRepo kategorijuRepo;

    @Override
    public void create(Veikals_kategorijas kategorija) {
        kategorijuRepo.save(kategorija);
    }

    @Override
    public Veikals_kategorijas retrieveById(int id) throws Exception {
        if(id < 0) throw new Exception("Id jābūt pozitīvam!");
		
		if(kategorijuRepo.existsById(id))
		{
			return kategorijuRepo.findById(id).get();
		}
		else
		{
			throw new Exception("Kategorija ar šo id ("+id+") neeksistē!");
		}
    }

    @Override
    public ArrayList<Veikals_kategorijas> retrieveAll() throws Exception {
       if(kategorijuRepo.count() == 0) throw new Exception("Nav nevienas kategorijas!");
			
		return (ArrayList<Veikals_kategorijas>) kategorijuRepo.findAll();
    }

    @Override
    public void updateById(int id, Veikals_kategorijas kategorija) throws Exception {
        Veikals_kategorijas kategorijaForUpdate = retrieveById(id);
		
        kategorijaForUpdate.setNosaukums(kategorija.getNosaukums());
        kategorijaForUpdate.setApraksts(kategorija.getNosaukums());
        
		kategorijuRepo.save(kategorijaForUpdate);
    }

    @Override
    public void deleteById(int id) throws Exception {
        Veikals_kategorijas kategorijaForDeletion = retrieveById(id);
		kategorijuRepo.delete(kategorijaForDeletion);
    }

    
}
