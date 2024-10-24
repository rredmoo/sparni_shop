package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.EpastiNoKlienta;
import lv.venta.model.KlientuEpasti;
import lv.venta.repo.KlientaEpastiRepo;
import lv.venta.service.IKlientuEpastiService;

@Service
public class KlientuEpastiServiceImpl implements IKlientuEpastiService {

    @Autowired
    private KlientaEpastiRepo klientaEpastiRepo;

    @Override
    public void saveEmail(KlientuEpasti epastiKlientam) {
        klientaEpastiRepo.save(epastiKlientam);
    }

    @Override
    public ArrayList<KlientuEpasti> getAllEmails() throws Exception {
        if (klientaEpastiRepo.count() == 0) {
            throw new Exception("Nav neviena epasta!");
        }
        return (ArrayList<KlientuEpasti>) klientaEpastiRepo.findAll();
    }
}
