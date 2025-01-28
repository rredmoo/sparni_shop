package lv.venta.service;

import lv.venta.model.BasketItem;
import java.util.ArrayList;

public interface IBasketItemService {

    void saveBasketItem(BasketItem basketItem) throws Exception;

    ArrayList<BasketItem> retrieveAll() throws Exception;

    BasketItem retrieveById(int id) throws Exception; // Updated return type

    void updateById(int id, BasketItem basketItem) throws Exception;

    void removeItem(BasketItem basketItem);

}
