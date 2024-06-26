package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Informacijas_lapa_informacija;
import lv.venta.service.IInformacijasLapa_InformacijaCRUDService;

@Service
public class informacijasLapaInformacijaServiceImpl implements IInformacijasLapa_InformacijaCRUDService{

    @Autowired
    private IInformacijasLapaInformacijaRepoceRepo informacijaRepo;

    @Override
    public void create(Informacijas_lapa_informacija informacija) {
        informacijaRepo.save(informacija);
    }

    @Override
    public Informacijas_lapa_informacija retrieveById(int id) throws Exception {
        if(id < 0) throw new Exception("Id jābūt pozitīvam!");
		
		if(informacijaRepo.existsById(id))
		{
			return informacijaRepo.findById(id).get();
		}
		else
		{
			throw new Exception("Informācija ar šo id ("+id+") neeksistē!");
		}
    }

    @Override
    public ArrayList<Informacijas_lapa_informacija> retrieveAll() throws Exception {
        if(informacijaRepo.count() == 0) throw new Exception("Nav informācijas info!");
			
		return (ArrayList<Informacijas_lapa_informacija>) informacijaRepo.findAll();
    }

    @Override
    public void updateById(int id, Informacijas_lapa_informacija informacija) throws Exception {
        Informacijas_lapa_informacija informacijaForUpdate = retrieveById(id);
		
        preceForUpdate.setNosaukums(informacija.getNosaukums());
        preceForUpdate.setApraksts(informacija.getApraksts());
		informacijaRepo.save(informacijaForUpdate);
    }

    @Override
    public void deleteById(int id) throws Exception {
        Informacijas_lapa_informacija informacijaForDeletion = retrieveById(id);
		informacijaRepo.delete(informacijaForDeletion);
    }
    
}
