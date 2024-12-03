package lv.venta.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "PASAKUMI_TABLE")
@Entity
public class Event {

    @Id
    @Column(name = "ID_Pasakumi")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idPasakumi;  

    @ManyToOne
    @JoinColumn(name = "ID_Pasakumi_Kategorijas", referencedColumnName = "idpk")
    @JsonBackReference
    private EventsCategory idPasakumiKategorijas;

    @Column(name = "SAKUMA_DATUMS")
    private LocalDateTime sakumaDatums;

    @Column(name = "BEIGU_DATUMS")
    private LocalDateTime beiguDatums;

    @Column(name = "NOSAUKUMS")
    private String nosaukums;

    @Column(name = "LAIKS")
    private LocalDateTime laiks;

    @Column(name = "VIETA")
    private String vieta;

    @Column(name = "APRAKSTS")
    private String apraksts;

    @Column(name = "BILDES_URL")
    private String bildesUrl;

    @OneToMany(mappedBy = "pasakumi")
    private List<MainPage_AboutUs> mainPage_ParMums;

    public Event(EventsCategory kategorija, LocalDateTime sakumaDatums, LocalDateTime beiguDatums, String nosaukums, LocalDateTime laiks,
                    String vieta, String apraksts, String bildesUrl) {
        setIdPasakumiKategorijas(kategorija);
        setSakumaDatums(sakumaDatums);
        setBeiguDatums(beiguDatums);
        setNosaukums(nosaukums);
        setLaiks(laiks);
        setVieta(vieta);
        setApraksts(apraksts);
        setBildesUrl(bildesUrl);
    }
}
