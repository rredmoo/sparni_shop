
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
@Table(name = "Epasti")
@Entity
public class Epasti {

    @Id
    @Column(name = "ide")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int ide;

    @Column(name = "Epasts")
    private String epasts;

    @Column(name = "Vai_Sanemt_Jaunumus")
    private Boolean vaiSanemtJaunumus;
    
    public Epasti(String epasts, Boolean vaiSanemtJaunumus) {
        setEpasts(epasts);
        setVaiSanemtJaunumus(vaiSanemtJaunumus);
    }
}
