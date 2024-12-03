package lv.venta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lv.venta.model.ClientsEmail;

@Service
public class EmailSendingService {
    private final JavaMailSender mailSender;
    private final IClientsEmailService klientuEpastiService; 

    @Autowired //konstruktors, lai definētu final
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
    
    public void sendEmailToAllClients(String subject, String body) throws Exception {
        ArrayList<ClientsEmail> allEmails = klientuEpastiService.getAllEmails();
        for (ClientsEmail client : allEmails) {
            sendEmail(client.getEpasts(), subject, body);
        }
    }
}

