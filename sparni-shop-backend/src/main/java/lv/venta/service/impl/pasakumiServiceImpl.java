package lv.venta.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Pasakumi;
import lv.venta.repo.IPasakumiRepo;
import lv.venta.service.IPasakumiCRUDService;

@Service
public class pasakumiServiceImpl implements IPasakumiCRUDService {

    private static final Logger logger = LoggerFactory.getLogger(pasakumiServiceImpl.class);

    @Autowired
    private IPasakumiRepo pasakumuRepo;

    @Override
    public void create(Pasakumi pasakums) {
        try {
            pasakumuRepo.save(pasakums);
            logger.info("Pasākums ar nosaukumu '{}' veiksmīgi izveidots.", pasakums.getNosaukums());
        } catch (Exception e) {
            logger.error("Kļūda izveidojot pasākumu: {}", e.getMessage());
            throw new RuntimeException("Notikusi kļūda, mēģinot izveidot pasākumu: " + e.getMessage(), e);
        }
    }

    @Override
    public Pasakumi retrieveById(int id) throws Exception {
        try {
            if (id < 0) {
                throw new Exception("ID jābūt pozitīvam!");
            }

            if (pasakumuRepo.existsById(id)) {
                return pasakumuRepo.findById(id).get();
            } else {
                throw new Exception("Pasākums ar šo ID (" + id + ") neeksistē!");
            }
        } catch (Exception e) {
            logger.error("Kļūda iegūstot pasākumu ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt pasākumu ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Pasakumi> retrieveAll() throws Exception {
        try {
            if (pasakumuRepo.count() == 0) {
                throw new Exception("Nav neviena pasākuma!");
            }
            return (ArrayList<Pasakumi>) pasakumuRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visus pasākumus: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visus pasākumus: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Pasakumi pasakums) throws Exception {
        try {
            Pasakumi pasakumsForUpdate = retrieveById(id);

            pasakumsForUpdate.setSakumaDatums(pasakums.getSakumaDatums());
            pasakumsForUpdate.setBeiguDatums(pasakums.getBeiguDatums());
            pasakumsForUpdate.setNosaukums(pasakums.getNosaukums());
            pasakumsForUpdate.setLaiks(pasakums.getLaiks());
            pasakumsForUpdate.setVieta(pasakums.getVieta());
            pasakumsForUpdate.setApraksts(pasakums.getApraksts());
            pasakumsForUpdate.setBildesUrl(pasakums.getBildesUrl());

            pasakumuRepo.save(pasakumsForUpdate);
            logger.info("Pasākums ar ID {} veiksmīgi atjaunināts.", id);
        } catch (Exception e) {
            logger.error("Kļūda atjauninot pasākumu ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot atjaunināt pasākumu ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            Pasakumi pasakumsForDeletion = retrieveById(id);
            pasakumuRepo.delete(pasakumsForDeletion);
            logger.info("Pasākums ar ID {} veiksmīgi dzēsts.", id);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot pasākumu ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst pasākumu ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Pasakumi> retrieveByCategoryId(int categoryId) throws Exception {
        try {
            ArrayList<Pasakumi> events = pasakumuRepo.findByIdPasakumiKategorijas_Idpk(categoryId);
            if (events.isEmpty()) {
                throw new Exception("Nav neviena pasākuma šajā kategorijā!");
            }
            return events;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot pasākumus pēc kategorijas ID {}: {}", categoryId, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt pasākumus pēc kategorijas ID: " + categoryId, e);
        }
    }

    @Override
    public ArrayList<Pasakumi> retrieveByLaiks(LocalDateTime startOfDay, LocalDateTime endOfDay) throws Exception {
        try {
            return pasakumuRepo.findBySakumaDatumsBetween(startOfDay, endOfDay);
        } catch (Exception e) {
            logger.error("Kļūda iegūstot pasākumus pēc datuma intervāla {} - {}: {}", startOfDay, endOfDay, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt pasākumus pēc datuma intervāla: " + startOfDay + " - " + endOfDay, e);
        }
    }
}
