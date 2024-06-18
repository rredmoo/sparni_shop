package lv.venta.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
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
    @Column(name = "ID_InformacijasLapa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int ID_InformacijasLapa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "informacijasLapaInformacija_id", referencedColumnName = "ID_InformacijasLapa_informacija")
    private Informacijas_lapa_informacija informacijasLapaInformacija;
}
