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
@Table(name = "ProductTable")
@Entity
public class Product {


	@Id
	@Column(name = "Idp")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)	
	private int idp;
	
	@Column(name = "Title")
	@Min(1)
	@Max(50)
	private String title;
	
	@Column(name = "Description")
	private String description;
	
	private ProductType productType;
	
	
	public Product(String title, String description, ProductType productType) {
		setProductType(productType);
		setDescription(description);
		setTitle(title);
	}
	
	
}
