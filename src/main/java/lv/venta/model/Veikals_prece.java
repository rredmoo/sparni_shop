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
@Table(name = "VEIKALS_PRECE_TABLE")
@Entity
public class Veikals_prece {

    @Id
    @Column(name = "IDVP")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
	private int idvp;
    
    @Column(name="NOSAUKUMS")
    private String nosaukums;
    
    @Column(name="APRAKSTS")
    private String apraksts;
    
    @Column(name="DAUDZUMS")
    private int daudzums;
    
    @Column(name="CENA")
    private float cena;
    
    @Column(name="ID_ATLAIDE")
    private Atlaide idAtlaide;
    
    public Veikals_prece(String nosaukums, String apraksts, int daudzums,
    		float cena, Atlaide idAtlaide) {
    	setNosaukums(nosaukums);
    	setApraksts(apraksts);
    	setDaudzums(daudzums);
    	setCena(cena);
    	setIdAtlaide(idAtlaide);
    	
    }   
    
}
