
package lv.venta.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Kontakti")
@Entity
public class Kontakti {

    @Id
    @Column(name = "idk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idk;

    @Column(name = "Nosaukums")
    private String nosaukums;

    @Column(name = "Informacija")
    private String informacija;


    @OneToMany(mappedBy = "kontakti")
    private List<MainPage_ParMums> mainPage_ParMums;
    
    public Kontakti(String nosaukums, String informacija) {
        this.nosaukums = nosaukums;
        this.informacija = informacija;
    }
}
