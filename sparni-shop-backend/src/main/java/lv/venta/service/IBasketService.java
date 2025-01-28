package lv.venta.service;

import lv.venta.model.Basket;
import java.util.ArrayList;

public interface IBasketService {

    public abstract void saveBasket(Basket basket) throws Exception;

    public abstract ArrayList<Basket> retrieveAll() throws Exception;

}
