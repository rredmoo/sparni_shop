package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Kontakti;
import lv.venta.repo.IKontaktiRepo;
import lv.venta.service.IKontaktiCRUDService;

@Service
public class KontaktiServiceImpl implements IKontaktiCRUDService {
    
    private static final Logger logger = LoggerFactory.getLogger(KontaktiServiceImpl.class);
    
    @Autowired
    private IKontaktiRepo kontaktiRepo;

    public KontaktiServiceImpl(IKontaktiRepo kontaktiRepo) {
        this.kontaktiRepo = kontaktiRepo;
    }

    @Override
    public void create(Kontakti kontakti) {
        try {
            kontaktiRepo.save(kontakti);
            logger.info("Kontakti ar ID {} tika veiksmīgi izveidoti.", kontakti.getIdk());
        } catch (Exception e) {
            logger.error("Kļūda veicot kontakti izveidi: {}", e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot izveidot kontaktu: " + e.getMessage(), e);
        }
    }

    @Override
    public Kontakti retrieveById(int id) throws Exception {
        try {
            Optional<Kontakti> optionalKontakti = kontaktiRepo.findById(id);
            if (optionalKontakti.isPresent()) {
                return optionalKontakti.get();
            } else {
                throw new Exception("Kontakti ar ID " + id + " netika atrasti.");
            }
        } catch (Exception e) {
            logger.error("Kļūda iegūstot kontaktus ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt kontaktus ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Kontakti> retrieveAll() {
        try {
            ArrayList<Kontakti> allKontakti = (ArrayList<Kontakti>) kontaktiRepo.findAll();
            if (allKontakti.isEmpty()) {
                throw new Exception("Nav nevienu kontaktu.");
            }
            return new ArrayList<>(allKontakti);
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visus kontaktus: {}", e.getMessage());
            throw new RuntimeException("Notikusi kļūda, mēģinot iegūt visus kontaktus: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Kontakti kontakti) throws Exception {
        try {
            if (kontaktiRepo.existsById(id)) {
                kontaktiRepo.save(kontakti);
                logger.info("Kontakti ar ID {} tika veiksmīgi atjaunināti.", id);
            } else {
                throw new Exception("Kontakti ar ID " + id + " netika atrasti.");
            }
        } catch (Exception e) {
            logger.error("Kļūda atjauninot kontaktus ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot atjaunināt kontaktus ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            if (kontaktiRepo.existsById(id)) {
                kontaktiRepo.deleteById(id);
                logger.info("Kontakti ar ID {} tika veiksmīgi dzēsti.", id);
            } else {
                throw new Exception("Kontakti ar ID " + id + " netika atrasti.");
            }
        } catch (Exception e) {
            logger.error("Kļūda dzēšot kontaktus ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst kontaktus ar ID " + id + ": " + e.getMessage());
        }
    }
}
