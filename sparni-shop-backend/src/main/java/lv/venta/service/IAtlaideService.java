package lv.venta.service;

import java.util.ArrayList;
import lv.venta.model.Atlaide;

public interface IAtlaideService {

    public abstract void create(Atlaide atlaide);

    public abstract Atlaide retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Atlaide> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Atlaide atlaide) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;
}
