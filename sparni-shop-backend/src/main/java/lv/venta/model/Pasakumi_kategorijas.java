package lv.venta.model;

import java.util.List;
import java.util.Locale;

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


    @Size(max = 55, message = "Max allow symbols is 55!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "NOSAUKUMS_LV")
    private String nosaukumsLv;


    @Size(max = 55, message = "Max allow symbols is 55!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "NOSAUKUMS_EN")
    private String nosaukumsEn;


    @Size(max = 255, message = "Max allow symbols is 255!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "APRAKSTS_LV")
    private String aprakstsLv;


    @Size(max = 255, message = "Max allow symbols is 255!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "APRAKSTS_EN")
    private String aprakstsEn;

    @OneToMany(mappedBy = "idPasakumiKategorijas")
    private List<Pasakumi> pasakumi;

    public Pasakumi_kategorijas(String nosaukumsLv, String nosaukumsEn, String aprakstsLv, String aprakstsEn) {
        setNosaukumsLv(nosaukumsLv);
        setNosaukumsEn(nosaukumsEn);
        setAprakstsLv(aprakstsLv);
        setAprakstsEn(aprakstsEn);
    }

    
    public String getLocalizedNosaukums(Locale locale) {
        return locale.getLanguage().equals("lv") ? nosaukumsLv : nosaukumsEn;
    }

    public String getLocalizedApraksts(Locale locale) {
        return locale.getLanguage().equals("lv") ? aprakstsLv : aprakstsEn;
    }
    
}
