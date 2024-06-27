package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Informacija;


public interface IInformacijaService {

	
    public abstract void create(Informacija informacija);

    public abstract Informacija retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Informacija> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Informacija informacija) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;
}
