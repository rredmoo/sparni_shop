package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.EpastiNoKlienta;
import lv.venta.model.Veikals_prece;
import lv.venta.repo.EpastiNoKlientaRepo;
import lv.venta.service.IEpastiNoKlientaService;

@Service
public class epastiNoKlientaServiceImpl implements IEpastiNoKlientaService {

    @Autowired
    private EpastiNoKlientaRepo messageRepo;

    @Override
    public void saveMessage(EpastiNoKlienta message) {
        try {
            messageRepo.save(message);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'saveMessage'");
        }
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveAll() throws Exception {
        if(messageRepo.count() == 0) throw new Exception("Nav neviena epasta!");
			
		return (ArrayList<EpastiNoKlienta>) messageRepo.findAll();
    }

}
