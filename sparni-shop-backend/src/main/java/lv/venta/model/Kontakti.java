
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
@Table(name = "Kontakti")
@Entity
public class Kontakti {

    @Id
    @Column(name = "idk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idk;

    @Size(max = 50, message = "Max allow symbols is 50!")
    //@Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
    @NotNull
    @Column(name = "Nosaukums_EN")
    private String nosaukumsEn;


    @Size(max = 50, message = "Max allow symbols is 50!")
    //@Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
    @NotNull
    @Column(name = "Nosaukums_LV")
    private String nosaukumsLv;


    @Size(max = 50, message = "Max allow symbols is 50!")
    //@Pattern(regexp = "^[a-zA-ZĀČĒĢĪĶĻŅŌŖŠŪŽāčēģīķļņōŗšūž0-9.,?!'\"\\-\\s@#$%&*()+:;_]*$", message = "Nederīgi burti")
    @NotNull
    @Column(name = "Informacija")
    private String informacija;


    @OneToMany(mappedBy = "kontakti")
    private List<MainPage_ParMums> mainPage_ParMums;
    
    public Kontakti(String nosaukumsEn,String nosaukumsLv,String informacija) {
        setNosaukumsEn(nosaukumsEn);
        setNosaukumsLv(nosaukumsLv);
        setInformacija(informacija);
      
    }

    
    public String getLocalizedNosaukums(Locale locale) {
        return locale.getLanguage().equals("lv") ? nosaukumsLv : nosaukumsEn;
    }


}
