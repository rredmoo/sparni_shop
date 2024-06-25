package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "Piegades_veids")
@Entity
public class Piegades_Veids {

    @Id
    @Column(name = "ID_Piegades_Veids")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idPiegadesVeids;

    @Column(name = "Nosaukums")
    @NotNull
    @Size(min = 3, max = 50)
   // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
    private String nosaukums;

    @Column(name = "Apraksts")
    @NotNull
    @Size(min = 3, max = 200)
   // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
    private String apraksts;

    @OneToOne(mappedBy = "piegadesVeids")
    private Pirkums pirkums;

    public Piegades_Veids(String nosaukums, String apraksts) {
        this.nosaukums = nosaukums;
        this.apraksts = apraksts;
    }
}
