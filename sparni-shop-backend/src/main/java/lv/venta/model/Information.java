package lv.venta.model;

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
public class Information {

    @Id
    @Column(name = "id_Info")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int id_info;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "NOSAUKUMS")
    private String nosaukums;

    @Size(min = 3, max = 300)
    @Column(name = "APRAKSTS")
    private String apraksts;
    
    @Size(min = 3, max = 300)
    @Column(name = "BILDES_URL")
    private String bildesUrl;

 
    public Information(String nosaukums, String apraksts, String bildesUrl) {
        this.nosaukums = nosaukums;
        this.apraksts = apraksts;
        this.bildesUrl = bildesUrl;

    }
}
	