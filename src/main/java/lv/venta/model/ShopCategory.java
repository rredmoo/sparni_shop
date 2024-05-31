package lv.venta.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "ProductImageTable")
@Entity


public class ShopCategory {
    
    @Setter(value = AccessLevel.NONE)
	@Column(name = "IdC")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idC;

    @Column(name = "Title")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
	private String title;


    @Column(name = "Description")
	@NotNull
	@Size(min = 3, max = 200)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
	private String description;


    public ShopCategory(String title,String description){
        setDescription(description);
        setTitle(title);

    }

}