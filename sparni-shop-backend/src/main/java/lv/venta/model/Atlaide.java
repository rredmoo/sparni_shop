package lv.venta.model;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

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

    @Max(100)
    @Min(0)
    @Column(name = "ATLAIDES_APMERS")
    private int atlaidesApmers;

    @DateTimeFormat
    @Column(name = "SAKUMA_DATUMS")
    private LocalDateTime sakumaDatums;

    @DateTimeFormat
    @Column(name = "BEIGU_DATUMS")
    private LocalDateTime beiguDatums;

    @OneToMany(mappedBy = "idAtlaide")
    private List<Veikals_prece> veikals_prece;  // Changed to List

    public Atlaide(int atlaidesApmers, LocalDateTime sakumaDatums, LocalDateTime beiguDatums) {
        this.atlaidesApmers = atlaidesApmers;
        this.sakumaDatums = sakumaDatums;
        this.beiguDatums = beiguDatums;
    }
}
