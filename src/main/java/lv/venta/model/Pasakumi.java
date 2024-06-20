package lv.venta.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column (name = "idpasakimi")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idpasakimi;
	
	@ManyToOne
    @JoinColumn(name = "ID_Pasakumi_Kategorijas", referencedColumnName = "idpk")
	private Pasakumi_kategorijas idPasakumiKategorijas;
	
	@Column (name = "SAKUMA_DATUMS")
	private LocalDateTime sakumaDatums;
	
	@Column (name = "BEIGU_DATUMS")
	private LocalDateTime beiguDatums;
	
	@Column (name = "NOSAUKUMS")
	private String nosaukums;
	
	@Column (name = "LAIKS")
	private LocalDateTime laiks;
	
	@Column (name = "VIETA")
	private String vieta;
	
	@Column (name = "APRAKSTS")
	private String apraksts;
	
	@Column (name = "BILDES_URL")
	private String bildesUrl;
	
	public Pasakumi(LocalDateTime sakumaDatums, LocalDateTime beiguDatums, String nosaukums, LocalDateTime laiks, String vieta, String apraksts, String bildesUrl) {
		setSakumaDatums(sakumaDatums);
    	setBeiguDatums(beiguDatums);
    	setNosaukums(nosaukums);
    	setLaiks(laiks);
    	setVieta(vieta);
    	setApraksts(apraksts);
    	setBildesUrl(bildesUrl);
    }

}
