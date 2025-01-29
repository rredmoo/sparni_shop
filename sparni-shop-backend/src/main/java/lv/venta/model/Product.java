package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "VEIKALS_PRECE_TABLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @Column(name = "idvp")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idvp;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "NOSAUKUMS")
    private String nosaukums;

    @Size(min = 3, max = 1000)
    @Column(name = "APRAKSTS")
    private String apraksts;

    @Max(500)
    @Min(0)
    @Column(name = "DAUDZUMS")
    private int daudzums;

    @Max(1000)
    @Min(0)
    @Column(name = "CENA")
    private float cena;

    @ManyToOne
    @JoinColumn(name = "ID_Veikals_Kategorijas", referencedColumnName = "idvk")
    private StoreCategory veikals_kategorijas;

    private String veikals_prece_bildes;

    @ManyToOne
    @JoinColumn(name = "ID_ATLAIDE", referencedColumnName = "IDA")
    private Discount idAtlaide;

    public Product(String nosaukums, String apraksts, int daudzums, float cena, StoreCategory veikals_kategorijas,
                         String veikals_prece_bildes, Discount idAtlaide) {
        this.nosaukums = nosaukums;
        this.apraksts = apraksts;
        this.daudzums = daudzums;
        this.cena = cena;
        this.veikals_kategorijas = veikals_kategorijas;
        this.veikals_prece_bildes = veikals_prece_bildes;
        this.idAtlaide = idAtlaide;
    }
    
}
