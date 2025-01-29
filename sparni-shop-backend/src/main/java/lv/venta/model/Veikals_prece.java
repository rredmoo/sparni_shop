package lv.venta.model;

import java.util.List;
import java.util.Locale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "VEIKALS_PRECE_TABLE")
@Entity
public class Veikals_prece {

    @Id
    @Column(name = "idvp")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idvp;

    @Size(max = 55, message = "Max allow symbols is 55!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "NOSAUKUMS_EN")
    private String nosaukumsEn;


    @Size(max = 55, message = "Max allow symbols is 55!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "NOSAUKUMS_LV")
    private String nosaukumsLv;


    @Size(max = 255, message = "Max allow symbols is 255!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "APRAKSTS_EN")
    private String aprakstsEn;


    @Size(max = 255, message = "Max allow symbols is 255!")
    @Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti vai simboli")
    @NotNull
    @Column(name = "APRAKSTS_LV")
    private String aprakstsLv;

    @Max(500)
    @Min(0)
    @Column(name = "DAUDZUMS")
    private int daudzums;

    @NotNull
    @Max(1000)
    @Min(0)
    @Column(name = "CENA")
    private float cena;


    @OneToOne(mappedBy = "veikals_prece")
    private Pirkums_Elements pirkums_Elements;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "Kategorija")
    private List<Veikals_kategorijas> veikals_kategorija;
    
    
    @Column(name = "VEIKALS_PRECE_BILDES")
    private String veikals_prece_bildes;

    @ManyToOne
    @JoinColumn(name = "ID_ATLAIDE", referencedColumnName = "IDA")
    private Atlaide idAtlaide;



    public Veikals_prece(String nosaukumsEn,String nosaukumsLv, String aprakstsEn, String aprakstsLv, int daudzums, float cena, 
                         Pirkums_Elements pirkums_Elements, List<Veikals_kategorijas> veikals_kategorijas,
                         String veikals_prece_bildes, Atlaide idAtlaide) {
        setNosaukumsEn(nosaukumsEn);
        setNosaukumsLv(nosaukumsLv);
        setAprakstsEn(aprakstsEn);
        setAprakstsLv(aprakstsLv);
        setDaudzums(daudzums);
        setCena(cena);
        setPirkums_Elements(pirkums_Elements);
        setVeikals_kategorija(veikals_kategorijas);
        setVeikals_prece_bildes(veikals_prece_bildes);
        setIdAtlaide(idAtlaide);
    }

     public String getLocalizedNosaukums(Locale locale) {
        return locale.getLanguage().equals("lv") ? nosaukumsLv : nosaukumsEn;
    }

    public String getLocalizedApraksts(Locale locale) {
        return locale.getLanguage().equals("lv") ? aprakstsLv : aprakstsEn;
    }


}