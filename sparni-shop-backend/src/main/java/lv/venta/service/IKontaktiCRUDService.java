package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Kontakti;

public interface IKontaktiCRUDService {

	void create(Kontakti kontakti);

    Kontakti retrieveById(int id) throws Exception;

    ArrayList<Kontakti> retrieveAll() throws Exception;

    void updateById(int id, Kontakti kontakti) throws Exception;

    void deleteById(int id) throws Exception;
	
}
