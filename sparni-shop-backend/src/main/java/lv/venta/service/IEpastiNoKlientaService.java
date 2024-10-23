package lv.venta.service;

import lv.venta.model.EpastiNoKlienta;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IEpastiNoKlientaService {

    public abstract void saveMessage(EpastiNoKlienta message);

    public abstract EpastiNoKlienta retrieveById(Long id) throws Exception;

    public abstract ArrayList<EpastiNoKlienta> retrieveAll() throws Exception;

    public abstract ArrayList<EpastiNoKlienta> retrieveByUserName(String username) throws Exception;

    public abstract ArrayList<EpastiNoKlienta> retrieveByEmail(String email) throws Exception;

    public abstract ArrayList<EpastiNoKlienta> retrieveByTopic(String topic) throws Exception;

    public abstract ArrayList<EpastiNoKlienta> retrieveByDateAfter(LocalDateTime date) throws Exception;

    public abstract ArrayList<EpastiNoKlienta> retrieveByDateBefore(LocalDateTime date) throws Exception;

    public abstract ArrayList<EpastiNoKlienta> retrieveByDateBetween(LocalDateTime dateStart, LocalDateTime dateEnd) throws Exception;

}
