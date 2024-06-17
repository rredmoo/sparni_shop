package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MainPage_BiedribasDarbojas")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MainPage_BiedribaDarbojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_MainPage_BiedribaDarbojas;

    @Column(name = "Nosaukums")
    private String nosaukums;

    @Column(name = "Apraksts")
    private String apraksts;

    @Column(name = "DalibniekuSkaits")
    private int dalibniekuSkaits;
}


