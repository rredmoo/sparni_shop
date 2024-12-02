package lv.venta.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import jakarta.annotation.PostConstruct;

import com.stripe.model.Charge.PaymentMethodDetails.StripeAccount;
import lv.venta.helpers.model.dto.PaymentInitDTO;
import lv.venta.helpers.model.dto.PaymentStatusDTO;
import lv.venta.service.IStripePaymentService;

@Service
public class StripePaymentServiceImpl implements IStripePaymentService {
	@Value("${stripe.public.key}")
	private String stripePublicKey;

	public StripePaymentServiceImpl() {

	}

	@PostConstruct
	public void init() {
		Stripe.apiKey = stripePublicKey;
	}

	@Override
	public PaymentIntent createPayment(PaymentInitDTO paymentInitDTO) throws StripeException {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("amount", paymentInitDTO.getAmount());
			params.put("currency", paymentInitDTO.getCurrency());
			return PaymentIntent.create(params);
		} catch (StripeException e) {
			throw e;
		}
	}

	@Override
	public void savePaymentStatus(PaymentStatusDTO status) {
		// TODO saglabāt datubāža pie pirkuma maksājuma numuru un statusu

	}
}