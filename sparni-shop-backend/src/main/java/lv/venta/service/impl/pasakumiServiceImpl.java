package lv.venta.service.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Pasakumi;
import lv.venta.repo.IPasakumiRepo;
import lv.venta.service.IPasakumiCRUDService;


@Service
public class pasakumiServiceImpl implements IPasakumiCRUDService{

    @Autowired
    private IPasakumiRepo pasakumuRepo;

    @Override
    public void create(Pasakumi pasakums) {
 
    pasakumuRepo.save(pasakums);
    
    }

    @Override
    public Pasakumi retrieveById(int id) throws Exception {
        if(id < 0) throw new Exception("Id jābūt pozitīvam!");
		
		if(pasakumuRepo.existsById(id))
		{
			return pasakumuRepo.findById(id).get();
		}
		else
		{
			throw new Exception("Pasākums ar šo id ("+id+") neeksistē!");
		}
    }

    @Override
    public ArrayList<Pasakumi> retrieveAll() throws Exception {
       
		if(pasakumuRepo.count() == 0) throw new Exception("Nav neviena pasākuma!");
			
		return (ArrayList<Pasakumi>) pasakumuRepo.findAll();
    }

    @Override
    public void updateById(int id, Pasakumi pasakums) throws Exception {
      

		Pasakumi pasakumsForUpdate = retrieveById(id);
		
        pasakumsForUpdate.setSakumaDatums(pasakums.getSakumaDatums());
        pasakumsForUpdate.setBeiguDatums(pasakums.getBeiguDatums());
        pasakumsForUpdate.setNosaukums(pasakums.getNosaukums());
        pasakumsForUpdate.setLaiks(pasakums.getLaiks());
        pasakumsForUpdate.setVieta(pasakums.getVieta());
        pasakumsForUpdate.setApraksts(pasakums.getApraksts());
        pasakumsForUpdate.setBildesUrl(pasakums.getBildesUrl());
		
		
		pasakumuRepo.save(pasakumsForUpdate);
    }

    @Override
    public void deleteById(int id) throws Exception {
     
		Pasakumi pasakumsForDeletion = retrieveById(id);
		pasakumuRepo.delete(pasakumsForDeletion);
    }

   

}
