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
    private final IKlientuEpastiService klientuEpastiService;

    @Autowired //konstruktors, lai definētu final
    public EmailSendingService(JavaMailSender mailSender, IKlientuEpastiService klientuEpastiService) {
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

    // Spārni --> Klients
    public void sendEmailToAllClients(String subject, String body) throws Exception {
        ArrayList<KlientuEpasti> allEmails = klientuEpastiService.getAllEmails();
        for (KlientuEpasti client : allEmails) {
            sendEmail(client.getEpasts(), subject, body);
        }
    }
}

