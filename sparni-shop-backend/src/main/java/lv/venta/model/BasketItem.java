package lv.venta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BASKET_ITEMS")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BASKET_ITEM")
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_BASKET", nullable = false)
    private Basket basket;    

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "COUNT")
    private int count;

    public BasketItem(Basket basket, Product product, int count){
        this.basket = basket;
        this.product = product;
        this.count = count;
    }
}
