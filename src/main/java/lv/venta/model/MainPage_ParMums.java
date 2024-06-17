package lv.venta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MainPage_ParMums")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MainPage_ParMums {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_MainPage_ParMums;

	// @ManyToOne
	// @JoinColumn(name = "ID_Veikals_Prece", referencedColumnName = "ID")
	// private VeikalsPrece veikalsPrece; //Saite uz Veikals_Prece

	// @ManyToOne
	// @JoinColumn(name = "ID_Pasakumi", referencedColumnName = "ID")
	// private Pasakumi pasakumi; // Saite uz Pasakumi

	// @ManyToOne
	// @JoinColumn(name = "ID_MainPage_BiedribaDarbojas", referencedColumnName =
	// "ID")
	// private MainPage_BiedribasDarbojas mainPageBiedribasDarbojas; // Saite uz
	// Pasakumi

	@ManyToOne
	@JoinColumn(name = "ID_Kontakti", referencedColumnName = "ID")
	private Kontakti kontakti; // Saite uz Kontakti
}
