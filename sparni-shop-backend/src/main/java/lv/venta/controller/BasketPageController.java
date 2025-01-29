package lv.venta.controller;

import lv.venta.model.Basket;
import lv.venta.model.BasketItem;
import lv.venta.model.Product;
import lv.venta.service.IBasketItemService;
import lv.venta.service.IBasketService;
import lv.venta.service.IProductCRUDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/basket")
public class BasketPageController {

    @Autowired
    private IBasketService basketService;

    @Autowired
    private IBasketItemService basketItemService;

    @Autowired
    private IProductCRUDService productService;

    // Get all basket items
    @GetMapping("/item/all")
    public ArrayList<BasketItem> getBasketItemsAll() {
        try {
            return basketItemService.retrieveAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @PutMapping("/item/update/{id}")
    public ResponseEntity<String> updateItemCount(@PathVariable int id, @RequestBody Map<String, Integer> request) {
        try {
            BasketItem basketItem = basketItemService.retrieveById(id);
            if (basketItem != null) {
                int newCount = request.get("count");
                basketItem.setCount(newCount);
                basketItemService.saveBasketItem(basketItem);
                return ResponseEntity.ok("Item count updated successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Basket item not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update item count!");
        }
    }

    // Add product to the basket
    @PostMapping("/item/add")
    public String addProductToBasket(
            @RequestParam int basketId,
            @RequestParam int productId,
            @RequestParam int count) {
        try {
            // Retrieve the basket from the database
            Optional<Basket> basketOpt = basketService.retrieveAll().stream()
                    .filter(basket -> basket.getIdb() == basketId)
                    .findFirst();

            if (basketOpt.isEmpty()) {
                return "Basket not found!";
            }

            Basket basket = basketOpt.get();

            // Retrieve the product from the database by productId
            Optional<Product> productOpt = productService.retrieveAll().stream()
                    .filter(product -> product.getIdvp() == productId)
                    .findFirst();

            if (productOpt.isEmpty()) {
                return "Product not found!";
            }

            Product product = productOpt.get();

            // Create a new BasketItem and save it
            BasketItem basketItem = new BasketItem(basket, product, count);
            basketItemService.saveBasketItem(basketItem);

            return "Product added to the basket successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add product to the basket!";
        }
    }

    // Remove product from the basket
    @DeleteMapping("/item/remove/{id}")
    public String removeProductFromBasket(@PathVariable int id) {
        try {
            BasketItem basketItem = basketItemService.retrieveById(id);
            basketItemService.removeItem(basketItem);
            return "Product removed from the basket successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to remove product from the basket!";
        }
    }
}
