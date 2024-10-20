package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "UserAuthority")
public class UserAuthority {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "AuthorityId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorityId;
	
	@Column(name = "Title")
	@Pattern(regexp = "[A-Z]{4,7}")
	private String title;
	
	public UserAuthority(@Pattern(regexp = "[A-Z]{4,7}") String title) {
		this.title = title;
	}
	
	
}