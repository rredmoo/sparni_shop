package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Contacts;

public interface IContactCRUDService {

	void create(Contacts kontakti);

    Contacts retrieveById(int id) throws Exception;

    ArrayList<Contacts> retrieveAll() throws Exception;

    void updateById(int id, Contacts kontakti) throws Exception;

    void deleteById(int id) throws Exception;
	
}
