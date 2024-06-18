package lv.venta.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	@Column(name = "idpe")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)	
	private int idpe;


    //ID_veikals_Prece

    // @Column(name = "Id_Veikals_Prece")
    // private Veikals_prece veikals_prece; 


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Pirkums", referencedColumnName = "ID_Pirkums")
    private Pirkums pirkums;

    @Max(500)
	@Min(0)
	@Column(name = "Daudzums")
	private int daudzums;

    public Pirkums_Elements(int daudzums) {
        setDaudzums(daudzums);
    }

    
}
