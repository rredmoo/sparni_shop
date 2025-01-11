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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Pirceja_Dati")
@Entity

public class CustomerData {

    // ID

    @Id
    @Column(name = "ID_Pirceja_Dati")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int ID_Pirceja_Dati;

    // Vards

    @Column(name = "Vards")
    @NotNull
    @Size(min = 3, max = 50)
   // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed")
    private String vards;

    // Uzvards

    @Column(name = "Uzvards")
    @NotNull
    @Size(min = 3, max = 50)
   // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed")
    private String uzvards;

    // Epasts

    @Column(name = "Epasts", unique = true)
    @NotNull
   // @Pattern(regexp = "^[A-Za-z0-9. _%-]+@[A-Za-z0-9. -]+\\. [A-Za-z]{2,4}$")
    private String epasts;

    @Column(name = "Adrese")
    @NotNull
    private String adrese;

    @OneToOne(mappedBy = "pircejaDati")
    private Pirkums pirkums;

    public CustomerData(String vards, String uzvards, String epasts, String adrese) {
        setVards(vards);
        setUzvards(uzvards);
        setEpasts(epasts);
        setAdrese(adrese);

    }

}
