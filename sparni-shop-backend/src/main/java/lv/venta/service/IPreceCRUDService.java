package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Veikals_prece;


public interface IPreceCRUDService {
    
    public abstract void create(Veikals_prece prece);

    public abstract Veikals_prece retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Veikals_prece> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Veikals_prece prece) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;

	public abstract ArrayList<Veikals_prece> retrieveAllAsc() throws Exception;

	public abstract ArrayList<Veikals_prece> retrieveAllDsc() throws Exception;
}