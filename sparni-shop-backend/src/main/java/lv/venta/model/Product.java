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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "VEIKALS_PRECE_TABLE")
@Entity
public class Product {

    @Id
    @Column(name = "idvp")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idvp;

    @NotNull
    @Size(min = 3, max = 50)
    // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Tikai burti un atstarpers ir atļautas!")  // Nestrādā atstarpe
    @Column(name = "NOSAUKUMS")
    private String nosaukums;

    @Size(min = 3, max = 300)
    // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Tikai burti un atstarpers ir atļautas!")  // Nestrādā atstarpe
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

    @OneToOne(mappedBy = "veikals_prece")
    private PurchaseElement pirkums_Elements;

    @ManyToOne
    @JoinColumn(name = "ID_Veikals_Kategorijas", referencedColumnName = "idvk")
    private StoreCategory veikals_kategorijas;

    private String veikals_prece_bildes;

    @ManyToOne
    @JoinColumn(name = "ID_ATLAIDE", referencedColumnName = "IDA")
    private Discount idAtlaide;

    public Product(String nosaukums, String apraksts, int daudzums, float cena, 
                         PurchaseElement pirkums_Elements, StoreCategory veikals_kategorijas,
                         String veikals_prece_bildes, Discount idAtlaide) {
        setNosaukums(nosaukums);
        setApraksts(apraksts);
        setDaudzums(daudzums);
        setCena(cena);
        setPirkums_Elements(pirkums_Elements);
        setVeikals_kategorijas(veikals_kategorijas);
        setVeikals_prece_bildes(veikals_prece_bildes);
        setIdAtlaide(idAtlaide);
    }
}
