package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Kontakti;
import lv.venta.repo.IKontaktiRepo;
import lv.venta.service.IKontaktiCRUDService;

@Service
public class KontaktiServiceImpl implements IKontaktiCRUDService {

    private static final Logger logger = LoggerFactory.getLogger(InformacijasServiceImpl.class);

    @Autowired
    private IKontaktiRepo kontaktiRepo;


    @Override
    public ArrayList<Kontakti> getLocalizedContacts(ArrayList<Kontakti> kontakti, String language) {
        ArrayList<Kontakti> localizedList = new ArrayList<>();
        for (Kontakti kontakts : kontakti) {
           
            Kontakti localizedContact = new Kontakti(
                language.equals("lv") ? kontakts.getNosaukumsLv() : kontakts.getNosaukumsEn(),
                language.equals("lv") ? kontakts.getNosaukumsLv() : kontakts.getNosaukumsEn(),
                kontakts.getInformacija()


            );
            localizedList.add(localizedContact);
        }
        return localizedList;
    }

    @Override
    public void create(Kontakti kontakts) {
        try {
            kontaktiRepo.save(kontakts);
            logger.info("Kontaktsar nosaukumu '{}' veiksmīgi izveidots.", kontakts.getNosaukumsLv());
        } catch (Exception e) {
            logger.error("Kļūda izveidojot kontaktu: {}", e.getMessage());
            throw new RuntimeException("Notikusi kļūda, mēģinot izveidot kontaktu: " + e.getMessage(), e);
        }
    }

    @Override
    public Kontakti retrieveById(int id) throws Exception {
        try {
            if (id < 0) {
                throw new Exception("ID jābūt pozitīvam!");
            }

            if (kontaktiRepo.existsById(id)) {
                return kontaktiRepo.findById(id);
            } else {
                throw new Exception("Informācija ar šo id (" + id + ") neeksistē!");
            }
        } catch (Exception e) {
            logger.error("Kļūda iegūstot kontaktu ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt kontaktu ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Kontakti> retrieveAll() throws Exception {
        try {
            if (kontaktiRepo.count() == 0) {
                throw new Exception("Nav neviena kontakta!");
            }
            return (ArrayList<Kontakti>) kontaktiRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visus kontakus: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visus kontaktus: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Kontakti kontakts) throws Exception {
        try {
           Kontakti kontaktsForUpdate = retrieveById(id);

           kontaktsForUpdate.setNosaukumsEn(kontakts.getNosaukumsEn());
           kontaktsForUpdate.setNosaukumsLv(kontakts.getNosaukumsLv());
           kontaktsForUpdate.setInformacija(kontakts.getInformacija());

            kontaktiRepo.save(kontaktsForUpdate);
        } catch (Exception e) {
            logger.error("Kļūda atjauninot kontaktu ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot atjaunināt kontaktu ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            Kontakti kontaktsForDeletion = retrieveById(id);
            kontaktiRepo.delete(kontaktsForDeletion);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot kontaktu ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst kontaktu ar ID " + id + ": " + e.getMessage());
        }
    }
}