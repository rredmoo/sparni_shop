package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Veikals_prece;
import lv.venta.repo.IPreceRepo;
import lv.venta.service.IPreceCRUDService;

@Service
public class preceServiceImpl implements IPreceCRUDService{

    @Autowired
    private IPreceRepo preceRepo;

    @Override
    public void create(Veikals_prece prece) {
        preceRepo.save(prece);
    }

    @Override
    public Veikals_prece retrieveById(int id) throws Exception {
        if(id < 0) throw new Exception("Id jābūt pozitīvam!");
		
		if(preceRepo.existsById(id))
		{
			return preceRepo.findById(id).get();
		}
		else
		{
			throw new Exception("Prece ar šo id ("+id+") neeksistē!");
		}
    }

    @Override
    public ArrayList<Veikals_prece> retrieveAll() throws Exception {
        if(preceRepo.count() == 0) throw new Exception("Nav nevienas preces!");
			
		return (ArrayList<Veikals_prece>) preceRepo.findAll();
    }

    @Override
    public void updateById(int id, Veikals_prece prece) throws Exception {
       Veikals_prece preceForUpdate = retrieveById(id);
		
        preceForUpdate.setNosaukums(prece.getNosaukums());
        preceForUpdate.setApraksts(prece.getApraksts());
        preceForUpdate.setDaudzums(prece.getDaudzums());
        preceForUpdate.setCena(prece.getCena());
        preceForUpdate.setPirkums_Elements(prece.getPirkums_Elements());
        preceForUpdate.setVeikals_kategorijas(prece.getVeikals_kategorijas());
        preceForUpdate.setVeikals_prece_bildes(prece.getVeikals_prece_bildes());
        preceForUpdate.getIdAtlaide();
    
		
		preceRepo.save(preceForUpdate);
    }

    @Override
    public void deleteById(int id) throws Exception {
        Veikals_prece preceForDeletion = retrieveById(id);
		preceRepo.delete(preceForDeletion);
    }

    @Override
    public ArrayList<Veikals_prece> retrieveAllAsc() throws Exception {
        try {
            ArrayList<Veikals_prece> allAscPreces = preceRepo.OrderByCenaAsc();
            return allAscPreces;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Veikals_prece> retrieveAllDsc() throws Exception {
        try {
            ArrayList<Veikals_prece> allDescPreces = preceRepo.OrderByCenaDesc();
            return allDescPreces;
        } catch (Exception e) {
            return null;
        }
    }

    
}
