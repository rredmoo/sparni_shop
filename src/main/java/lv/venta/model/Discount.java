package lv.venta.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "DiscountTable")
@Entity


public class Discount {
    
    @Setter(value = AccessLevel.NONE)
	@Column(name = "IdD")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//autoincrement
	private int idD;

   
	@Max(100)
	@Min(0)
	@Column(name = "DiscountAmount")
	private int discount;
	
	@DateTimeFormat
	@Column(name = "StartDate")
    private LocalDateTime startDate;


    @Column(name = "EndDate")
    private LocalDateTime endDate;

    
    @Column(name = "is_Discount")
    private boolean isdiscount;

    public Discount(int discountAmount , LocalDateTime startDate, LocalDateTime endDate,boolean isDiscount){
        setDiscount(discountAmount);
        setStartDate(startDate);
        setEndDate(endDate);
        setIsdiscount(isDiscount);
        
       
    }



}


