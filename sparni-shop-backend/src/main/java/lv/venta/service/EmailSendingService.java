package lv.venta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lv.venta.model.KlientuEpasti;

@Service
public class EmailSendingService {
    private final JavaMailSender mailSender;
    private final IKlientuEpastiService klientuEpastiService; // Assuming this service exists to retrieve emails

    @Autowired
    public EmailSendingService(JavaMailSender mailSender, IKlientuEpastiService klientuEpastiService) {
        this.mailSender = mailSender;
        this.klientuEpastiService = klientuEpastiService;
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    // New method to send an email to all clients
    public void sendEmailToAllClients(String subject, String body) throws Exception {
        // Fetch all emails from the database
        ArrayList<KlientuEpasti> allEmails = klientuEpastiService.getAllEmails();
        
        for (KlientuEpasti client : allEmails) {
            sendEmail(client.getEpasts(), subject, body);
        }
    }
}

