package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "global_params_table")
@Entity
public class GlobalParams {

    @Id
    @Column(name = "idgp")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idgp;

    // TODO pieliek validāciju anotācijas
    @Column(name="ParamTitle")
    private String paramTitle;
    @Column(name="ParamValue")
    private String paramValue;

    GlobalParams(String paramTitle, String paramValue){
        this.paramTitle = paramTitle;
        this.paramValue = paramValue;
    }
}
