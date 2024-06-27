package lv.venta.service.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Informacija;
import lv.venta.repo.IInformacijasRepo;
import lv.venta.service.IInformacijaService;


@Service
public class InformacijasServiceImpl implements IInformacijaService{

    @Autowired
    private IInformacijasRepo infoRepo;

    @Override
    public void create(Informacija informacija) {
 
    infoRepo.save(informacija);
    
    }

    @Override
    public Informacija retrieveById(int id) throws Exception {
        if(id < 0) throw new Exception("Id jābūt pozitīvam!");
		
		if(infoRepo.existsById(id))
		{
			return infoRepo.findById(id);
		}
		else
		{
			throw new Exception("Informācija ar šo id ("+id+") neeksistē!");
		}
    }

    @Override
    public ArrayList<Informacija> retrieveAll() throws Exception {
       
		if(infoRepo.count() == 0) throw new Exception("Nav nevienas informācijas!");
			
		return (ArrayList<Informacija>) infoRepo.findAll();
    }

    @Override
    public void updateById(int id, Informacija informacija) throws Exception {
      

		Informacija infoForUpdate = retrieveById(id);
		
        infoForUpdate.setNosaukums(informacija.getNosaukums());
        infoForUpdate.setApraksts(informacija.getApraksts());
        infoForUpdate.setBildesUrl(informacija.getBildesUrl());
       
		
		
		infoRepo.save(infoForUpdate);
    }

    @Override
    public void deleteById(int id) throws Exception {
     
		Informacija infoForDeletion = retrieveById(id);
		infoRepo.delete(infoForDeletion);
    }

   

}
