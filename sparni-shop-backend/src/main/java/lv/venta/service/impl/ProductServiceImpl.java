package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductServiceImpl implements IProductCRUDService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private IProductRepo preceRepo;

    @Override
    public void create(Product prece) {
        try {
            preceRepo.save(prece);
            logger.info("Prece '{}' veiksmīgi izveidota.", prece.getNosaukums());
        } catch (Exception e) {
            logger.error("Kļūda izveidojot preci: {}", e.getMessage());
            throw new RuntimeException("Notikusi kļūda, mēģinot izveidot preci: " + e.getMessage(), e);
        }
    }

    @Override
    public Product retrieveById(int id) throws Exception {
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
    public ArrayList<Product> retrieveAll() throws Exception {
        try {
            if (preceRepo.count() == 0) {
                throw new Exception("Nav nevienas preces!");
            }
            return (ArrayList<Product>) preceRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas preces: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visas preces: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Product prece) throws Exception {
        try {
            Product preceForUpdate = retrieveById(id);
            preceForUpdate.setNosaukums(prece.getNosaukums());
            preceForUpdate.setApraksts(prece.getApraksts());
            preceForUpdate.setDaudzums(prece.getDaudzums());
            preceForUpdate.setCena(prece.getCena());
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
            Product preceForDeletion = retrieveById(id);
            preceRepo.delete(preceForDeletion);
            logger.info("Prece ar ID {} veiksmīgi dzēsta.", id);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot preci ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst preci ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Product> retrieveAllAsc() throws Exception {
        try {
            ArrayList<Product> allAscPreces = preceRepo.OrderByCenaAsc();
            logger.info("Preces veiksmīgi iegūtas augošā secībā pēc cenas.");
            return allAscPreces;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot preces augošā secībā pēc cenas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt preces augošā secībā pēc cenas: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Product> retrieveAllDsc() throws Exception {
        try {
            ArrayList<Product> allDescPreces = preceRepo.OrderByCenaDesc();
            logger.info("Preces veiksmīgi iegūtas dilstošā secībā pēc cenas.");
            return allDescPreces;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot preces dilstošā secībā pēc cenas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt preces dilstošā secībā pēc cenas: " + e.getMessage());
        }
    }
}
