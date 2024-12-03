package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.EventsCategory;
import lv.venta.repo.IEventCategoryRepo;
import lv.venta.service.IEventCategoryService;

@Service
public class EventCategoryServiceImpl implements IEventCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(EventCategoryServiceImpl.class);

    @Autowired
    private IEventCategoryRepo kategorijasRepo;

    @Override
    public ArrayList<EventsCategory> retrieveAllCategories() {
        try {
            ArrayList<EventsCategory> categories = (ArrayList<EventsCategory>) kategorijasRepo.findAll();
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
