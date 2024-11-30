package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Pasakumi_kategorijas;
import lv.venta.repo.IPasakumiKategorijasRepo;
import lv.venta.service.IPasakumiKategorijasService;

@Service
public class PasakumiKategorijasServiceImpl implements IPasakumiKategorijasService {

    private static final Logger logger = LoggerFactory.getLogger(PasakumiKategorijasServiceImpl.class);

    @Autowired
    private IPasakumiKategorijasRepo kategorijasRepo;

    @Override
    public ArrayList<Pasakumi_kategorijas> retrieveAllCategories() {
        try {
            ArrayList<Pasakumi_kategorijas> categories = (ArrayList<Pasakumi_kategorijas>) kategorijasRepo.findAll();
            if (categories.isEmpty()) {
                logger.warn("Nav atrastas kategorijas.");
                throw new Exception("Nav atrastas nevienas kategorijas.");
            }
           
            return categories;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot kategorijas: {}", e.getMessage());
            throw new RuntimeException("Notikusi kļūda, mēģinot iegūt kategorijas: " + e.getMessage(), e);
        }
    }
}
