package lv.venta.controller;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("veikals")
public class ProductPageController {

    @Autowired
    private IProductCRUDService productService;

    @GetMapping("/all")
    public ResponseEntity<ArrayList<Product>> getAllProducts() {
        try {
            ArrayList<Product> products = productService.retrieveAll();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/prece/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) throws Exception {
        try {
            Product product = productService.retrieveById(id);
            return ResponseEntity.ok(product);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/prece/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        try {
            productService.updateById(id, product);
            return ResponseEntity.ok("Product updated successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update product.");
        }
    }

    @DeleteMapping("/prece/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        try {
            productService.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product.");
        }
    }

    @GetMapping("/price/asc")
    public ResponseEntity<ArrayList<Product>> getProductsAsc() {
        try {
            ArrayList<Product> products = productService.retrieveAllAsc();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/price/desc")
    public ResponseEntity<ArrayList<Product>> getProductsDesc() {
        try {
            ArrayList<Product> products = productService.retrieveAllDsc();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
    }
}
