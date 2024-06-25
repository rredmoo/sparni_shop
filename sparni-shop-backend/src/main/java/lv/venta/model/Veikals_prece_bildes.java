package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Veikals_Prece_Bildes")
@Entity


public class Veikals_prece_bildes {
    
    @Setter(value = AccessLevel.NONE)
	@Column(name = "ID_Veikals_Prece_Bilde")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID_Veikals_Prece_Bilde;

    @Column(name = "Image")
    private String imgPath;

    @Column(name = "Description")
	@NotNull
	@Size(min = 3, max = 300)
	// @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed")
	private String description;

    @OneToOne(mappedBy = "veikals_prece_bildes")
    private Veikals_prece veikals_prece;

    public Veikals_prece_bildes(String description, String imgPath){
        setDescription(description);
        setImgPath(imgPath);
    }

}