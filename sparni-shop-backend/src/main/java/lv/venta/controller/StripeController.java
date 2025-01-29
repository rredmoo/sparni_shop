package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import lv.venta.helpers.model.dto.ClientSecret;
import lv.venta.helpers.model.dto.PaymentInitDTO;
import lv.venta.helpers.model.dto.PaymentStatusDTO;
import lv.venta.service.EmailSendingService;
import lv.venta.service.IStripePaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class StripeController {

	@Autowired
	private EmailSendingService emailSendingService;

	@Autowired
	private IStripePaymentService stripeService;

	@PostMapping("/create")
	public ResponseEntity<?> postMethodName(@RequestBody PaymentInitDTO paymentInitDTO) {
		System.out.println(paymentInitDTO);
		PaymentIntent pI;
		try {
			pI = stripeService.createPayment(paymentInitDTO);
			System.out.println(pI);
			ClientSecret cs = new ClientSecret(pI.getClientSecret());
			return new ResponseEntity<ClientSecret>(cs, HttpStatus.OK);
		} catch (StripeException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/confirm")
	public ResponseEntity<?> postConfirm(@RequestBody PaymentStatusDTO paymentStatusDTO) {
		try {
			stripeService.savePaymentStatus(paymentStatusDTO);

			// Retrieve data from paymentStatusDTO
			String name = paymentStatusDTO.getName();
			String email = paymentStatusDTO.getEmail();
			String paymentIntentId = paymentStatusDTO.getPaymentIntentId();
			String paymentStatus = paymentStatusDTO.getPaymentStatus();
			double price = paymentStatusDTO.getPrice();

			emailSendingService.sendPaymentConfirmationEmail(email, name, paymentIntentId, paymentStatus, price);

			return new ResponseEntity<>("Payment info saved and email sent", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to process payment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public class PaymentEmailTemplate {

		public static String generatePaymentConfirmationEmail(String name, String paymentIntentId, String paymentStatus,
				double amountPaid) {
			return "<html>"
					+ "<body style='font-family: Arial, sans-serif; color: #333;'>"
					+ "<div style='max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; background-color: #f9f9f9;'>"
					+ "<h2 style='text-align: center; color: #4CAF50;'>Payment Confirmation</h2>"
					+ "<p style='font-size: 16px;'>Dear " + name + ",</p>"
					+ "<p style='font-size: 16px;'>Thank you for your purchase! We have successfully processed your payment.</p>"
					+ "<h3 style='font-size: 18px;'>Payment Details:</h3>"
					+ "<table style='width: 100%; border-collapse: collapse;'>"
					+ "<tr>"
					+ "<td style='padding: 8px; font-size: 16px; border: 1px solid #ddd;'>Payment Intent ID</td>"
					+ "<td style='padding: 8px; font-size: 16px; border: 1px solid #ddd;'>" + paymentIntentId + "</td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td style='padding: 8px; font-size: 16px; border: 1px solid #ddd;'>Payment Status</td>"
					+ "<td style='padding: 8px; font-size: 16px; border: 1px solid #ddd;'>" + paymentStatus + "</td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td style='padding: 8px; font-size: 16px; border: 1px solid #ddd;'>Amount Paid</td>"
					+ "<td style='padding: 8px; font-size: 16px; border: 1px solid #ddd;'>$"
					+ String.format("%.2f", amountPaid) + "</td>"
					+ "</tr>"
					+ "</table>"
					+ "<p style='font-size: 16px;'>If you have any questions or need further assistance, feel free to contact our support team.</p>"
					+ "<p style='font-size: 16px;'>Thank you for choosing our service!</p>"
					+ "<p style='font-size: 14px; color: #777;'>Best regards, <br>Spārni</p>"
					+ "</div>"
					+ "</body>"
					+ "</html>";
		}

	}

}