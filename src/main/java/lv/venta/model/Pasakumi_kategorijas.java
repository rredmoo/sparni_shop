package lv.venta.model;

import org.springframework.boot.autoconfigure.AutoConfiguration;

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
@Table(name = "PASAKUMI_KATEGORIJAS_TABLE")
@Entity

public class Pasakumi_kategorijas {
	
	@Id
	@Column(name = "IDPK")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idpk;
	    
	@Column(name="NOSAUKUMS")
	private String nosaukums;
	    
	@Column(name="APRAKSTS")
	private String apraksts;
	    
	public Pasakumi_kategorijas(String nosaukums, String apraksts) {
	    setNosaukums(nosaukums);
	    setApraksts(apraksts);
	}

}
