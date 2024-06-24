package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "VEIKALS_KATEGORIJAS_TABLE")
@Entity
public class Veikals_kategorijas {

    @Id
    @Column(name = "idvk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idvk;
    
    @NotNull
    @Size(min = 3, max = 50)
    // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Tikai burti un atstarpers ir atļautas!") // Nestrādā atstarpe
    @Column(name = "NOSAUKUMS")
    private String nosaukums;
    
    @Size(min = 3, max = 300)
    // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Tikai burti un atstarpers ir atļautas!") // Nestrādā atstarpe
    @Column(name = "APRAKSTS")
    private String apraksts;

    @OneToMany(mappedBy = "veikals_kategorijas")
    private List<Veikals_prece> veikalsPreces;

    
    
    public Veikals_kategorijas(String nosaukums, String apraksts) {
        setNosaukums(nosaukums);
        setApraksts(apraksts);
    }
}
