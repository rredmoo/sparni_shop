package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.MainPage_ParMums;

public interface IMainPageParMumsCRUDService {

	void create(MainPage_ParMums mainPageParMums);

    MainPage_ParMums retrieveById(int id) throws Exception;

    ArrayList<MainPage_ParMums> retrieveAll() throws Exception;

    void updateById(int id, MainPage_ParMums mainPageParMums) throws Exception;

    void deleteById(int id) throws Exception;
	
}
