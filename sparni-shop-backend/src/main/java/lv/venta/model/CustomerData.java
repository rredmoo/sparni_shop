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

    // Personas Kods

    @Column(name = "Personas_Kods", unique = true)
    @NotNull
  //  @Pattern(regexp = "[0-9]{6}-[0-9]{5}", message = "Wrong input form/example: 190903-21641")
    private String personas_kods;

    // Bankas Nosaukums

    @Column(name = "Bankas_Nosaukums", unique = true)
    @NotNull
    @Size(min = 3, max = 50)
  //  @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
    private String bankas_nosaukums;

    // Swift Kods

    @Column(name = "Swift_Kods")
    @NotNull
  //  @Pattern(regexp = "^[A-Z]{6}[A-Z0-9]{2}([A-Z0-9]{3})?$")
    private String swift_kods;

    // Bankas Konts

    @Column(name = "Bankas_konts")
    @NotNull
    @Size(min = 3, max = 50)
    private String bankas_konts;

    // Adrese

    @Column(name = "Adrese")
    @NotNull
    private String adrese;

    @OneToOne(mappedBy = "pircejaDati")
    private Pirkums pirkums;

    public CustomerData(String vards, String uzvards, String epasts, String personas_kods, String swift_kods,
            String bankas_konts, String adrese) {
        setVards(vards);
        setUzvards(uzvards);
        setEpasts(epasts);
        setPersonas_kods(personas_kods);
        setSwift_kods(swift_kods);
        setBankas_konts(bankas_konts);
        setAdrese(adrese);

    }

}
