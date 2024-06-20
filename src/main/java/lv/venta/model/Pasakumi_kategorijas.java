package lv.venta.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Column(name = "idpk")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idpk;
	    
	@Column(name="NOSAUKUMS")
	private String nosaukums;
	    
	@Column(name="APRAKSTS")
	private String apraksts;
	    
	@OneToMany(mappedBy = "idPasakumiKategorijas")
    private List<Pasakumi> veikalsPreces;
	
	public Pasakumi_kategorijas(String nosaukums, String apraksts) {
	    setNosaukums(nosaukums);
	    setApraksts(apraksts);
	}

}
