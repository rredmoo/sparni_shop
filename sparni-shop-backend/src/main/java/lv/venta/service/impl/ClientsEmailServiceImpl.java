package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.ClientsEmail;
import lv.venta.repo.IClientsEmailRepo;
import lv.venta.service.IClientsEmailService;

@Service
public class ClientsEmailServiceImpl implements IClientsEmailService {

    private static final Logger logger = LoggerFactory.getLogger(ClientsEmailServiceImpl.class);

    @Autowired
    private IClientsEmailRepo klientaEpastiRepo;

    @Override
    public void saveEmail(ClientsEmail epastiKlientam) {
        try {
            klientaEpastiRepo.save(epastiKlientam);
        } catch (Exception e) {
            logger.error("Kļūda saglabājot epastu klientam: {}", e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot saglabāt epastu klientam: " + e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<ClientsEmail> getAllEmails() throws Exception {
        try {
            if (klientaEpastiRepo.count() == 0) {
                throw new Exception("Nav neviena epasta!");
            }
            return (ArrayList<ClientsEmail>) klientaEpastiRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visus epastus: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visus epastus: " + e.getMessage());
        }
    }
}
