package lv.venta.helpers.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentStatusDTO {
    private String PaymentIntentID;
    private String PaymentStatus;
}