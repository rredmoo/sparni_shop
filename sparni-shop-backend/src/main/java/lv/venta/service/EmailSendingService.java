package lv.venta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lv.venta.controller.StripeController.PaymentEmailTemplate;
import lv.venta.model.ClientsEmail;

@Service
public class EmailSendingService {
    private final JavaMailSender mailSender;
    private final IClientsEmailService klientuEpastiService;

    @Autowired // konstruktors, lai definētu final
    public EmailSendingService(JavaMailSender mailSender, IClientsEmailService klientuEpastiService) {
        this.mailSender = mailSender;
        this.klientuEpastiService = klientuEpastiService;
    }

    // Klients --> Spārni
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    // Spārni --> all clients
    public void sendEmailToAllClients(String subject, String body) throws Exception {
        ArrayList<ClientsEmail> allEmails = klientuEpastiService.getAllEmails();
        for (ClientsEmail client : allEmails) {
            sendEmail(client.getEpasts(), subject, body);
        }
    }

    // Spārni --> some clients
    public void sendEmailToSelectedClients(String subject, String body, ArrayList<ClientsEmail> klientuEpasti) {
        for (ClientsEmail client : klientuEpasti) {
            System.out.println(client.getEpasts());
            sendEmail(client.getEpasts(), subject, body);
        }
    }

    // HTML payment confirmation 
    public void sendPaymentConfirmationEmail(String to, String name, String paymentIntentId, String paymentStatus, double amountPaid) {
        String subject = "Payment Confirmation - Your Order Details";
        String body = PaymentEmailTemplate.generatePaymentConfirmationEmail(name, paymentIntentId, paymentStatus, amountPaid);
    
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            helper.setFrom("sparnishoptest@gmail.com");
    
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Handle exception
        }
    }
}
