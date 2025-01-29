package lv.venta.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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


    @Size(max = 55, message = "Max allow symbols is 55!")
    @NotNull
    @Column(name = "NOSAUKUMS_EN")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
    private String nosaukumsEn;


    @Size(max = 55, message = "Maksimums atļauto simbolu is 55!")
    @NotNull
    @Column(name = "NOSAUKUMS_LV")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
    private String nosaukumsLv;

    @Column(name = "LAIKS")
    private LocalDateTime laiks;

    @Column(name = "VIETA")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
    private String vieta;


    @Size(max = 250, message = "Max allow symbols is 250!")
    @NotNull
    @Column(name = "APRAKSTS_EN")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
    private String aprakstsEn;

    @Size(max = 250, message = "Maksimums atļauto simbolu is 250!")
    @NotNull
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
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
