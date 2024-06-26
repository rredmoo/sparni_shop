package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Informacijas_lapa;

public interface IInformacijasLapa_InformacijaCRUDService {
    
    public abstract void create(Informacijas_lapa informacija);

    public abstract Informacijas_lapa retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Informacijas_lapa> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Informacijas_lapa informacija) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;

}