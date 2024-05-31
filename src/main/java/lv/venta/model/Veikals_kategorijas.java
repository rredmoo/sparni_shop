package lv.venta.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "VEIKALS_KATEGORIJAS_TABLE")
@Entity
public class Veikals_kategorijas {

    @Id
    @Column(name = "IDA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idvk;
    
    @Column(name="NOSAUKUMS")
    private String nosaukums;
    
    @Column(name="APRAKSTS")
    private String apraksts;
    
    public Veikals_kategorijas(String nosaukums, String apraksts) {
    	setNosaukums(nosaukums);
    	setApraksts(apraksts);
    }
    
    
}
