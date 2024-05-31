package lv.venta.model;

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
@Table(name = "PASAKUMI_TABLE")
@Entity
public class Pasakumi {
	
	@Id
	@Column (name = "IDP")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idp;
	
	@Column (name = "NOSAUKUMS")
	private String nosaukums;
	
	@Column (name = "APRAKSTS")
	private String apraksts;
	
	@Column (name = "SAKUMA_DATUMS")
	private int sakuma_datums;
	
	@Column (name = "BEIGU_DATUMS")
	private int beigu_datums;
	
	@Column (name = "LOKACIJA")
	private int lokacija;
	
	//public Pasakumi(String title) {
		
	//}

}
