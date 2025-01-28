package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lv.venta.model.BasketItem;
import lv.venta.repo.IBasketItemRepo;
import lv.venta.service.IBasketItemService;

@Service
public class BasketItemServiceImpl implements IBasketItemService {

    @Autowired
    private IBasketItemRepo basketItemRepo;

    @Override
    public void saveBasketItem(BasketItem basketItem) throws Exception {
        if (basketItem == null) {
            throw new IllegalArgumentException("BasketItem must not be null.");
        }
        try {
            basketItemRepo.save(basketItem);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error occurred while saving the basket item: " + e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<BasketItem> retrieveAll() throws Exception {
        try {
            List<BasketItem> items = (List<BasketItem>) basketItemRepo.findAll();
            return new ArrayList<>(items); // Convert to ArrayList if necessary
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving all basket items: " + e.getMessage(), e);
        }
    }

    @Override
    public BasketItem retrieveById(int id) throws Exception {
        try {
            Optional<BasketItem> basketItem = basketItemRepo.findById(id);
            if (basketItem.isPresent()) {
                return basketItem.get();
            } else {
                throw new IllegalArgumentException("BasketItem with ID " + id + " not found.");
            }
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving basket item by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateById(int id, BasketItem basketItem) throws Exception {
        if (basketItem == null) {
            throw new IllegalArgumentException("BasketItem must not be null.");
        }
        try {
            BasketItem existingItem = retrieveById(id);
            existingItem.setCount(basketItem.getCount());
            basketItemRepo.save(existingItem);
            
        } catch (DataAccessException e) {
            throw new RuntimeException("Error updating basket item by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public void removeItem(BasketItem basketItem) {
        if (basketItem == null || !basketItemRepo.existsById(basketItem.getId())) {
            throw new IllegalArgumentException("BasketItem does not exist or is null.");
        }
        try {
            basketItemRepo.delete(basketItem);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error occurred while deleting the basket item: " + e.getMessage(), e);
        }
    }
}
