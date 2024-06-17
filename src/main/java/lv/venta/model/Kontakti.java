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

@Entity
@Table(name = "Kontakti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kontakti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Kontakti;

    @Column(name = "Nosaukums")
    private String nosaukums;

    @Column(name = "Informacija")
    private String informacija;
    }
