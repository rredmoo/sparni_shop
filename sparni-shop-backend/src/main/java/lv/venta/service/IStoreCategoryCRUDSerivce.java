package lv.venta.service;

import java.util.ArrayList;
import lv.venta.model.StoreCategory;

public interface IStoreCategoryCRUDSerivce {

	public abstract void create(StoreCategory kategorija);

	public abstract StoreCategory retrieveById(int id) throws Exception;

	public abstract ArrayList<StoreCategory> retrieveAll() throws Exception;

	public abstract void updateById(int id, StoreCategory kategorija) throws Exception;

	public abstract void deleteById(int id) throws Exception;
}