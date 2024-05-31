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
@Table(name = "INFORMACIJAS_LAPA_TABLE")
@Entity

public class Informacijas_lapa {
	
	@Id
	@Column (name = "IDIL")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idil;
	
	@Column (name = "ID_INFORMACIJAS_LAPA_INFORMACIJA")
	private Informacijas_lapa_informacija idInformacijasLapaInformacija;
	    
	public Informacijas_lapa(Informacijas_lapa_informacija idInformacijasLapaInformacija) {
	setIdInformacijasLapaInformacija(idInformacijasLapaInformacija);
	}

}
