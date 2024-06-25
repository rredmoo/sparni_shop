package lv.venta.service;

import java.util.ArrayList;
import lv.venta.model.Veikals_kategorijas;

public interface IVeikalsKategorijasCRUDSerivce {

	public abstract void create(Veikals_kategorijas kategorija);

	public abstract Veikals_kategorijas retrieveById(int id) throws Exception;

	public abstract ArrayList<Veikals_kategorijas> retrieveAll() throws Exception;

	public abstract void updateById(int id, Veikals_kategorijas kategorija) throws Exception;

	public abstract void deleteById(int id) throws Exception;
}