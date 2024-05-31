package lv.venta.model;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.AutoConfiguration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ATLAIDE_TABLE")
@Entity
public class Atlaide {

    @Id
    @Column(name = "IDA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int ida;
    
    
    @Column(name="ATLAIDES_APMERS")
    private int atlaidesApmers;
    
    @Column(name="SAKUMA_DATUMS")
    private LocalDateTime sakumaDatums;
    
    @Column(name="BEIGU_DATUMS")
    private LocalDateTime beiguDatums;
    
    @Column(name="VAI_ATLAIDE")
    private boolean vaiAlaide;
    
    
    public Atlaide(int atlaidesApmers, LocalDateTime sakumaDatums,
    		LocalDateTime beiguDatums,boolean vaiAlaide) {
    	setAtlaidesApmers(atlaidesApmers);
    	setSakumaDatums(sakumaDatums);
    	setBeiguDatums(beiguDatums);
    	setVaiAlaide(vaiAlaide);
    	
    }
}
