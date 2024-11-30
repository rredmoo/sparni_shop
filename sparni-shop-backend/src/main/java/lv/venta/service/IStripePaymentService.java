package lv.venta.service;

import com.stripe.model.PaymentIntent;

import lv.venta.helpers.model.dto.PaymentInitDTO;

public interface IStripePaymentService {

    PaymentIntent createPayment(PaymentInitDTO paymentInitDTO);
}