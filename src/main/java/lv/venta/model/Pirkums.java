package lv.venta.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
@Table(name = "Pirkums")
@Entity

public class Pirkums {

//ID

    @Id
	@Column(name = "Id_Pirkums")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)	
	private int id_pirkums;

    //ID_piegades_veids

    @Column(name = "Id_Piegades_veids")
    private Piegades_Veids piegades_veids;


    //pirkuma_datums
    @Column(name = "Pirkuma_Datums")
    private LocalDateTime pirkuma_datums;


    //piegades_detalas

  
    @Column(name = "Piegades_detalas")
    @NotNull
    @Size(min = 3, max = 200)
    @Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed!")
    private String piegades_detalas;


    //ID_samaksas_veids
    @Column(name = "Id_Samaksas_veids")
    private Samaksas_veids samaksas_veids;


    //Statuss

    @Column(name = "Statuss")
    @NotNull
    private Statuss statuss;


    //Id_Pirceja_dati

    @Column(name = "Id_Pirceja_dati")
    private Pirceja_Dati pirceja_dati;



    
}
