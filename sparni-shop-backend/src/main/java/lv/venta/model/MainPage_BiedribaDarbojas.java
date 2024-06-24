
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
@Table(name = "MainPage_BiedribasDarbojas")
@Entity
public class MainPage_BiedribaDarbojas {

    @Id
    @Column(name = "idmpbd")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idmpbd;

    @Column(name = "Nosaukums")
    private String nosaukums;

    @Column(name = "Apraksts")
    private String apraksts;

    @Column(name = "DalibniekuSkaits")
    private int dalibniekuSkaits;

    @OneToMany(mappedBy = "mainPageBiedribasDarbojas")
    private List<MainPage_ParMums> mainPage_ParMums;
    
    public MainPage_BiedribaDarbojas(String nosaukums, String apraksts, int dalibniekuSkaits) {
        this.nosaukums = nosaukums;
        this.apraksts = apraksts;
        this.dalibniekuSkaits = dalibniekuSkaits;
    }
}
