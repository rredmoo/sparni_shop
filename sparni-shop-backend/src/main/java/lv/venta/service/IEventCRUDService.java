package lv.venta.service;


import java.time.LocalDateTime;
import java.util.ArrayList;


import lv.venta.model.Event;

public interface IEventCRUDService {

	
    public abstract void create(Event pasakums);

    public abstract Event retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Event> retrieveAll() throws Exception;
	
	public abstract void updateById(int id, Event pasakums) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;

	ArrayList<Event> retrieveByCategoryId(int categoryId) throws Exception;

	ArrayList<Event> retrieveByLaiks(LocalDateTime startOfDay, LocalDateTime endOfDay) throws Exception;
}

