package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Veikals_prece;
import lv.venta.repo.IPreceRepo;
import lv.venta.service.IPreceCRUDService;

@Service
public class preceServiceImpl implements IPreceCRUDService {

    private static final Logger logger = LoggerFactory.getLogger(preceServiceImpl.class);

    @Autowired
    private IPreceRepo preceRepo;

    @Override
    public void create(Veikals_prece prece) {
        try {
            preceRepo.save(prece);
            logger.info("Prece '{}' veiksmīgi izveidota.", prece.getNosaukums());
        } catch (Exception e) {
            logger.error("Kļūda izveidojot preci: {}", e.getMessage());
            throw new RuntimeException("Notikusi kļūda, mēģinot izveidot preci: " + e.getMessage(), e);
        }
    }

    @Override
    public Veikals_prece retrieveById(int id) throws Exception {
        try {
            if (id < 0) {
                throw new Exception("ID jābūt pozitīvam!");
            }

            if (preceRepo.existsById(id)) {
                return preceRepo.findById(id).get();
            } else {
                throw new Exception("Prece ar šo ID (" + id + ") neeksistē!");
            }
        } catch (Exception e) {
            logger.error("Kļūda iegūstot preci ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt preci ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Veikals_prece> retrieveAll() throws Exception {
        try {
            if (preceRepo.count() == 0) {
                throw new Exception("Nav nevienas preces!");
            }
            return (ArrayList<Veikals_prece>) preceRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas preces: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visas preces: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Veikals_prece prece) throws Exception {
        try {
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
            logger.info("Prece ar ID {} veiksmīgi atjaunināta.", id);
        } catch (Exception e) {
            logger.error("Kļūda atjauninot preci ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot atjaunināt preci ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            Veikals_prece preceForDeletion = retrieveById(id);
            preceRepo.delete(preceForDeletion);
            logger.info("Prece ar ID {} veiksmīgi dzēsta.", id);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot preci ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst preci ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Veikals_prece> retrieveAllAsc() throws Exception {
        try {
            ArrayList<Veikals_prece> allAscPreces = preceRepo.OrderByCenaAsc();
            logger.info("Preces veiksmīgi iegūtas augošā secībā pēc cenas.");
            return allAscPreces;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot preces augošā secībā pēc cenas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt preces augošā secībā pēc cenas: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Veikals_prece> retrieveAllDsc() throws Exception {
        try {
            ArrayList<Veikals_prece> allDescPreces = preceRepo.OrderByCenaDesc();
            logger.info("Preces veiksmīgi iegūtas dilstošā secībā pēc cenas.");
            return allDescPreces;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot preces dilstošā secībā pēc cenas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt preces dilstošā secībā pēc cenas: " + e.getMessage());
        }
    }
}
