package lv.venta.helpers.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInitDTO {
    private int amount;
    private String currency;
}