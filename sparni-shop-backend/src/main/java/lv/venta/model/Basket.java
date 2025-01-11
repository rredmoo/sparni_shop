package lv.venta.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BASKETS")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BASKET")
    private int idb;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BasketItem> items = new ArrayList<>();

}
