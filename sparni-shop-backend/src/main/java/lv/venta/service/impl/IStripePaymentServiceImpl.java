package lv.venta.service.impl;

import com.stripe.model.PaymentIntent;

import lv.venta.helpers.model.dto.PaymentInitDTO;
import lv.venta.service.IStripePaymentService;

public class IStripePaymentServiceImpl implements IStripePaymentService{

    @Override
    public PaymentIntent createPayment(PaymentInitDTO paymentInitDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }




}