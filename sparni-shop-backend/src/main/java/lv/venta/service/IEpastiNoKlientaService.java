package lv.venta.service;

import lv.venta.model.EpastiNoKlienta;
import java.util.ArrayList;

public interface IEpastiNoKlientaService {

    public abstract void saveMessage(EpastiNoKlienta message);

    public abstract ArrayList<EpastiNoKlienta> retrieveAll() throws Exception;

}
