package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.MainPage_BiedribaDarbojas;

public interface IMainPageBiedribasDarbojasCRUDService {


	void create(MainPage_BiedribaDarbojas mainPageBiedribaDarbojas);

    MainPage_BiedribaDarbojas retrieveById(int id) throws Exception;

    ArrayList<MainPage_BiedribaDarbojas> retrieveAll() throws Exception;

    void updateById(int id, MainPage_BiedribaDarbojas mainPageBiedribaDarbojas) throws Exception;

    void deleteById(int id) throws Exception;
	
	
}
