package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import lv.venta.model.Basket;
import lv.venta.repo.IBasketRepo;
import lv.venta.service.IBasketService;

public class BasketServiceImpl implements IBasketService{

    @Autowired
    private IBasketRepo basketRepo;

    @Override
    public void saveBasket(Basket basket) throws Exception {
        if (basket == null) {
            throw new IllegalArgumentException("BasketItem must not be null.");
        }
        try {
            basketRepo.save(basket);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error occurred while saving the basket item: " + e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Basket> retrieveAll() throws Exception {
        try {
            List<Basket> items = (List<Basket>) basketRepo.findAll();
            return new ArrayList<>(items);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving all baskets: " + e.getMessage(), e);
        }
    }
    
}
