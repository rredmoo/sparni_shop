package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Informacija;
import lv.venta.repo.IInformacijasRepo;
import lv.venta.service.IInformacijaService;

@Service
public class InformacijasServiceImpl implements IInformacijaService {

    private static final Logger logger = LoggerFactory.getLogger(InformacijasServiceImpl.class);

    @Autowired
    private IInformacijasRepo infoRepo;

    @Override
    public void create(Informacija informacija) {
        try {
            infoRepo.save(informacija);
        } catch (Exception e) {
            logger.error("Kļūda izveidojot informāciju: {}", e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot izveidot informāciju: " + e.getMessage(), e);
        }
    }

    @Override
    public Informacija retrieveById(int id) throws Exception {
        try {
            if (id < 0) {
                throw new Exception("ID jābūt pozitīvam!");
            }

            if (infoRepo.existsById(id)) {
                return infoRepo.findById(id);
            } else {
                throw new Exception("Informācija ar šo id (" + id + ") neeksistē!");
            }
        } catch (Exception e) {
            logger.error("Kļūda iegūstot informāciju ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt informāciju ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Informacija> retrieveAll() throws Exception {
        try {
            if (infoRepo.count() == 0) {
                throw new Exception("Nav nevienas informācijas!");
            }
            return (ArrayList<Informacija>) infoRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas informācijas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visas informācijas: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Informacija informacija) throws Exception {
        try {
            Informacija infoForUpdate = retrieveById(id);

            infoForUpdate.setNosaukums(informacija.getNosaukums());
            infoForUpdate.setApraksts(informacija.getApraksts());
            infoForUpdate.setBildesUrl(informacija.getBildesUrl());

            infoRepo.save(infoForUpdate);
        } catch (Exception e) {
            logger.error("Kļūda atjauninot informāciju ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot atjaunināt informāciju ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            Informacija infoForDeletion = retrieveById(id);
            infoRepo.delete(infoForDeletion);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot informāciju ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst informāciju ar ID " + id + ": " + e.getMessage());
        }
    }
}
