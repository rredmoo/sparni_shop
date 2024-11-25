package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lv.venta.model.Pasakumi_kategorijas;
import lv.venta.repo.IPasakumiKategorijasRepo;
import lv.venta.service.IPasakumiKategorijasService;

@Service
public class PasakumiKategorijasServiceImpl implements IPasakumiKategorijasService {

    @Autowired
    private IPasakumiKategorijasRepo kategorijasRepo;

    @Override
    public ArrayList<Pasakumi_kategorijas> retrieveAllCategories() {
        return kategorijasRepo.findAll();
    }
}
