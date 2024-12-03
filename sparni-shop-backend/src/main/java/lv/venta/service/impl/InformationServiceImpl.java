package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Information;
import lv.venta.repo.IInformationRepo;
import lv.venta.service.IInformationService;

@Service
public class InformationServiceImpl implements IInformationService {

    private static final Logger logger = LoggerFactory.getLogger(InformationServiceImpl.class);

    @Autowired
    private IInformationRepo infoRepo;

    @Override
    public void create(Information informacija) {
        try {
            infoRepo.save(informacija);
        } catch (Exception e) {
            logger.error("Kļūda izveidojot informāciju: {}", e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot izveidot informāciju: " + e.getMessage(), e);
        }
    }

    @Override
    public Information retrieveById(int id) throws Exception {
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
    public ArrayList<Information> retrieveAll() throws Exception {
        try {
            if (infoRepo.count() == 0) {
                throw new Exception("Nav nevienas informācijas!");
            }
            return (ArrayList<Information>) infoRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas informācijas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visas informācijas: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Information informacija) throws Exception {
        try {
            Information infoForUpdate = retrieveById(id);

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
            Information infoForDeletion = retrieveById(id);
            infoRepo.delete(infoForDeletion);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot informāciju ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst informāciju ar ID " + id + ": " + e.getMessage());
        }
    }
}
