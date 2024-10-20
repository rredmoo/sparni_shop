package lv.venta.model.security;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private String title;

	@OneToMany(mappedBy = "authority")
	@ToString.Exclude
	private Collection<AccessUsers> users;

	public UserAuthority(String title) {
		this.title = title;
	}

}