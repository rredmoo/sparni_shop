package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Pirkuma_Elements")
@Entity

public class Pirkums_Elements {

    //ID

    @Id
	@Column(name = "Id_Pirkuma_Elements")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)	
	private int id_pirkumaElements;


    //ID_veikals_Prece

    @Column(name = "Id_Veikals_Prece")
    private Veikals_prece veikals_prece; 

    //Id_pirkums

    @Column(name = "Id_Pirkums")
    private Pirkums pirkums;

   
    //Daudzums

    @Max(500)
	@Min(0)
	@Column(name = "Daudzums")
	private int daudzums;

    public Pirkums_Elements(int daudzums) {
        setDaudzums(daudzums);
    }

    
}
