package lv.venta.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "PASAKUMI_TABLE")
@Entity
public class Pasakumi {

    @Id
    @Column(name = "ID_Pasakumi")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idPasakumi;  

    @ManyToOne
    @JoinColumn(name = "ID_Pasakumi_Kategorijas", referencedColumnName = "idpk")
    @JsonBackReference
    private Pasakumi_kategorijas idPasakumiKategorijas;

    @Column(name = "SAKUMA_DATUMS")
    private LocalDateTime sakumaDatums;

    @Column(name = "BEIGU_DATUMS")
    private LocalDateTime beiguDatums;

    @Column(name = "NOSAUKUMS_EN")
    private String nosaukumsEn;

    @Column(name = "NOSAUKUMS_LV")
    private String nosaukumsLv;

    @Column(name = "LAIKS")
    private LocalDateTime laiks;

    @Column(name = "VIETA")
    private String vieta;

    @Column(name = "APRAKSTS_EN")
    private String aprakstsEn;

    @Column(name = "APRAKSTS_LV")
    private String aprakstsLv;

    @Column(name = "BILDES_URL")
    private String bildesUrl;

    @OneToMany(mappedBy = "pasakumi")
    private List<MainPage_ParMums> mainPage_ParMums;

    public Pasakumi(Pasakumi_kategorijas kategorija, LocalDateTime sakumaDatums, LocalDateTime beiguDatums, 
                    String nosaukumsEn, String nosaukumsLv, LocalDateTime laiks, String vieta, 
                    String aprakstsEn, String aprakstsLv, String bildesUrl) {
        setIdPasakumiKategorijas(kategorija);
        setSakumaDatums(sakumaDatums);
        setBeiguDatums(beiguDatums);
        setNosaukumsEn(nosaukumsEn);
        setNosaukumsLv(nosaukumsLv);
        setLaiks(laiks);
        setVieta(vieta);
        setAprakstsEn(aprakstsEn);
        setAprakstsLv(aprakstsLv);
        setBildesUrl(bildesUrl);
    }

    
    public String getLocalizedNosaukums(Locale locale) {
        return locale.getLanguage().equals("lv") ? nosaukumsLv : nosaukumsEn;
    }

    public String getLocalizedApraksts(Locale locale) {
        return locale.getLanguage().equals("lv") ? aprakstsLv : aprakstsEn;
    }
     
}
