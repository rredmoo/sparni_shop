package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "INFORMACIJAS_LAPA_INFORMACIJA_TABLE")
@Entity
public class Informacijas_lapa_informacija {

    @Id
    @Column(name = "idili")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idili;

    @Column(name = "NOSAUKUMS")
    private String nosaukums;

    @Column(name = "APRAKSTS")
    private String apraksts;

    @OneToOne(mappedBy = "informacijasLapaInformacija")
    private Informacijas_lapa informacijasLapa;

    public Informacijas_lapa_informacija(String nosaukums, String apraksts, Informacijas_lapa informacijasLapa) {
        this.nosaukums = nosaukums;
        this.apraksts = apraksts;
        this.informacijasLapa = informacijasLapa;
    }
}
	