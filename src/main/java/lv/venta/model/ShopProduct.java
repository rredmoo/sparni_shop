package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "ShopProductTable")
@Entity


public class ShopProduct {

    @Setter(value = AccessLevel.NONE)
	@Column(name = "IdSP")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSP;

  //Id-category


  //Nosaukums
    @Column(name = "Title")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
	private String title;

  //apraksts

    @Column(name = "Description")
	@NotNull
	@Size(min = 3, max = 200)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
	private String description;

  //Daudzums

    @Max(500)
	@Min(0)
	@Column(name = "Quantity")
	private int quantity;

  //Cena

    @Max(1000)
	@Min(0)
	@Column(name = "Price")
	private float price;

  //Id-atlaide

  //Id-veikals-prece-bilde


  public ShopProduct(String title, String description, int quantity, float price){
        setTitle(title);
        setDescription(description);
        setQuantity(quantity);
        setPrice(price);
  }
    
}
