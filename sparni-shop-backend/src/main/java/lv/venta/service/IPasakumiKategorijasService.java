package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Pasakumi_kategorijas;

public interface IPasakumiKategorijasService {
    ArrayList<Pasakumi_kategorijas> retrieveAllCategories();
}
