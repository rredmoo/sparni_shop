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
@Table(name = "MainPage_ParMums")
@Entity
public class MainPage_ParMums {

	@Id
	@Column (name = "idmppm")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idmppm;

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

	// @ManyToOne
	// @JoinColumn(name = "ID_Kontakti", referencedColumnName = "ID")
	// private Kontakti kontakti; 
}