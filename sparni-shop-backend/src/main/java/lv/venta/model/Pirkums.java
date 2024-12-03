package lv.venta.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "Pirkums")
@Entity
public class Pirkums {

    @Id
    @Column(name = "ID_Pirkums")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int ID_Pirkums;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Piegades_Veids", referencedColumnName = "ID_Piegades_Veids")
    private DeliveryOptions piegadesVeids;

    @Column(name = "Pirkuma_Datums")
    private LocalDateTime pirkumaDatums;

    @Column(name = "Piegades_detalas")
    @NotNull
    @Size(min = 3, max = 200)
   // @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed! (First letter must be capital)")
    private String piegadesDetalas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idsv", referencedColumnName = "idsv")
    private PaymentOption samaksasVeids;

    @Column(name = "Statuss")
    @NotNull
    private Statuss statuss;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Pirceja_Dati", referencedColumnName = "ID_Pirceja_Dati")
    private CustomerData pircejaDati;

    @OneToOne(mappedBy = "pirkums")
    private PurchaseElement pirkumsElements;

    public Pirkums(DeliveryOptions piegades_Veids, LocalDateTime pirkumaDatums, String piegadesDetalas, PaymentOption samaksasVeids, Statuss statuss,
    CustomerData pirceja_Dati, PurchaseElement pirkums_Elements){
        setPiegadesVeids(piegades_Veids);
        setPirkumaDatums(pirkumaDatums);
        setPiegadesDetalas(piegadesDetalas);
        setSamaksasVeids(samaksasVeids);
        setPircejaDati(pirceja_Dati);
        setPirkumsElements(pirkums_Elements);
    }
}
