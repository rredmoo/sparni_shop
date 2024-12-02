package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.KlientuEpasti;
import lv.venta.repo.KlientaEpastiRepo;
import lv.venta.service.IKlientuEpastiService;

@Service
public class KlientuEpastiServiceImpl implements IKlientuEpastiService {

    private static final Logger logger = LoggerFactory.getLogger(KlientuEpastiServiceImpl.class);

    @Autowired
    private KlientaEpastiRepo klientaEpastiRepo;

    @Override
    public void saveEmail(KlientuEpasti epastiKlientam) {
        try {
            klientaEpastiRepo.save(epastiKlientam);
        } catch (Exception e) {
            logger.error("Kļūda saglabājot epastu klientam: {}", e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot saglabāt epastu klientam: " + e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<KlientuEpasti> getAllEmails() throws Exception {
        try {
            if (klientaEpastiRepo.count() == 0) {
                throw new Exception("Nav neviena epasta!");
            }
            return (ArrayList<KlientuEpasti>) klientaEpastiRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visus epastus: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visus epastus: " + e.getMessage());
        }
    }
}
