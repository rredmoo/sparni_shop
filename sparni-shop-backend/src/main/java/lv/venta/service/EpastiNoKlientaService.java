package lv.venta.service;

import lv.venta.model.EpastiNoKlienta;
import lv.venta.repo.EpastiNoKlientaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpastiNoKlientaService {

    @Autowired
    private EpastiNoKlientaRepo messageRepo;

    public void saveMessage(EpastiNoKlienta message) {
        messageRepo.save(message);
    }
}
