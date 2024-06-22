package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Kontakti;
import lv.venta.repo.IKontaktiRepo;
import lv.venta.service.IKontaktiCRUDService;

@Service
public class KontaktiServiceImpl implements IKontaktiCRUDService {
	
	@Autowired
    private IKontaktiRepo kontaktiRepo;

    
    
    public KontaktiServiceImpl(IKontaktiRepo kontaktiRepo) {
        this.kontaktiRepo = kontaktiRepo;
    }

    @Override
    public void create(Kontakti kontakti) {
        kontaktiRepo.save(kontakti);
    }

    @Override
    public Kontakti retrieveById(int id) throws Exception {
        Optional<Kontakti> optionalKontakti = kontaktiRepo.findById(id);
        if (optionalKontakti.isPresent()) {
            return optionalKontakti.get();
        } else {
            throw new Exception("Kontakti with ID " + id + " not found.");
        }
    }

    @Override
    public ArrayList<Kontakti> retrieveAll() {
    	ArrayList<Kontakti> allKontakti = (ArrayList<Kontakti>) kontaktiRepo.findAll();
        return new ArrayList<>(allKontakti);
    }

    @Override
    public void updateById(int id, Kontakti kontakti) throws Exception {
        if (kontaktiRepo.existsById(id)) {
            kontaktiRepo.save(kontakti);
        } else {
            throw new Exception("Kontakti with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        if (kontaktiRepo.existsById(id)) {
            kontaktiRepo.deleteById(id);
        } else {
            throw new Exception("Kontakti with ID " + id + " not found.");
        }
    }
}
