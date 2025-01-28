package lv.venta.model;

import java.util.Locale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "INFORMACIJAS_LAPA_INFORMACIJA_TABLE")
@Entity
public class Informacija {

    @Id
    @Column(name = "id_Info")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int id_info;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "NOSAUKUMS_EN")
    private String nosaukumsEn;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "NOSAUKUMS_LV")
    private String nosaukumsLv;

    @Size(min = 3, max = 300)
    @Column(name = "APRAKSTS_EN")
    private String aprakstsEn;

    @Size(min = 3, max = 300)
    @Column(name = "APRAKSTS_LV")
    private String aprakstsLv;
    
    @Size(min = 3, max = 300)
    @Column(name = "BILDES_URL")
    private String bildesUrl;

 
    public Informacija(String nosaukumsEn,String nosaukumsLv, String aprakstsEn,String aprakstsLv, String bildesUrl) {
        setNosaukumsEn(nosaukumsEn);
        setNosaukumsLv(nosaukumsLv);
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
	