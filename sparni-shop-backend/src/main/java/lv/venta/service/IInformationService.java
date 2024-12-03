package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Information;


public interface IInformationService {

	
    public abstract void create(Information informacija);

    public abstract Information retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Information> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Information informacija) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;
}
