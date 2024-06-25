package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Pasakumi;

public interface IPasakumiCRUDService {

	
    public abstract void create(Pasakumi pasakums);

    public abstract Pasakumi retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Pasakumi> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Pasakumi pasakums) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;
}
