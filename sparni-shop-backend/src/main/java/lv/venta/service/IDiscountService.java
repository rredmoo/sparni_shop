package lv.venta.service;

import java.util.ArrayList;
import lv.venta.model.Discount;

public interface IDiscountService {

    public abstract void create(Discount atlaide);

    public abstract Discount retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Discount> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Discount atlaide) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;
}
