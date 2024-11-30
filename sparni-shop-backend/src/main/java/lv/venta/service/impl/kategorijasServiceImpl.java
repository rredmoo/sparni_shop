package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Veikals_kategorijas;
import lv.venta.repo.IVeikalsKategorijasRepo;
import lv.venta.service.IVeikalsKategorijasCRUDSerivce;

@Service
public class kategorijasServiceImpl implements IVeikalsKategorijasCRUDSerivce {

    private static final Logger logger = LoggerFactory.getLogger(kategorijasServiceImpl.class);

    @Autowired
    private IVeikalsKategorijasRepo kategorijuRepo;

    @Override
    public void create(Veikals_kategorijas kategorija) {
        try {
            kategorijuRepo.save(kategorija);
        } catch (Exception e) {
            logger.error("Kļūda izveidojot kategoriju: {}", e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot izveidot kategoriju: " + e.getMessage(), e);
        }
    }

    @Override
    public Veikals_kategorijas retrieveById(int id) throws Exception {
        try {
            if (id < 0) {
                throw new Exception("ID jābūt pozitīvam!");
            }

            if (kategorijuRepo.existsById(id)) {
                return kategorijuRepo.findById(id).get();
            } else {
                throw new Exception("Kategorija ar šo id (" + id + ") neeksistē!");
            }
        } catch (Exception e) {
            logger.error("Kļūda iegūstot kategoriju ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt kategoriju ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Veikals_kategorijas> retrieveAll() throws Exception {
        try {
            if (kategorijuRepo.count() == 0) {
                throw new Exception("Nav nevienas kategorijas!");
            }
            return (ArrayList<Veikals_kategorijas>) kategorijuRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas kategorijas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visas kategorijas: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Veikals_kategorijas kategorija) throws Exception {
        try {
            Veikals_kategorijas kategorijaForUpdate = retrieveById(id);
            kategorijaForUpdate.setNosaukums(kategorija.getNosaukums());
            kategorijaForUpdate.setApraksts(kategorija.getApraksts());
            kategorijuRepo.save(kategorijaForUpdate);
        } catch (Exception e) {
            logger.error("Kļūda atjauninot kategoriju ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot atjaunināt kategoriju ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            Veikals_kategorijas kategorijaForDeletion = retrieveById(id);
            kategorijuRepo.delete(kategorijaForDeletion);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot kategoriju ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst kategoriju ar ID " + id + ": " + e.getMessage());
        }
    }
}
