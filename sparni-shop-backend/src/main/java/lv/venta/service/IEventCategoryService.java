package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.EventsCategory;

public interface IEventCategoryService {
    ArrayList<EventsCategory> retrieveAllCategories();
}
