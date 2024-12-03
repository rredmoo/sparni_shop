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
@Table(name = "PASAKUMI_KATEGORIJAS_TABLE")
@Entity
public class Pasakumi_kategorijas {

    @Id
    @Column(name = "idpk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idpk;

    @Column(name = "NOSAUKUMS_LV")
    private String nosaukumsLv; // Latvian name

    @Column(name = "NOSAUKUMS_EN")
    private String nosaukumsEn; // English name

    @Column(name = "APRAKSTS_LV")
    private String aprakstsLv; // Latvian description

    @Column(name = "APRAKSTS_EN")
    private String aprakstsEn; // English description

    @OneToMany(mappedBy = "idPasakumiKategorijas")
    private List<Pasakumi> pasakumi;

    public Pasakumi_kategorijas(String nosaukumsLv, String nosaukumsEn, String aprakstsLv, String aprakstsEn) {
        setNosaukumsLv(nosaukumsLv);
        setNosaukumsEn(nosaukumsEn);
        setAprakstsLv(aprakstsLv);
        setAprakstsEn(aprakstsEn);
    }
}
