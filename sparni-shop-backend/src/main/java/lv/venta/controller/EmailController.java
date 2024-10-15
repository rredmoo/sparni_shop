package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lv.venta.model.EpastiNoKlienta;
import lv.venta.service.EmailSendingService;
import lv.venta.service.EpastiNoKlientaService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    private final EmailSendingService emailSenderService;
    private final EpastiNoKlientaService messageService;

    @Autowired
    public EmailController(EmailSendingService emailSenderService, EpastiNoKlientaService messageService) {
        this.emailSenderService = emailSenderService;
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendContactMessage(@RequestBody ContactRequest contactRequest) {
        try {
            System.out.println("Received contact request: " + contactRequest); // Log the request
            
            // Save the message to the database
            EpastiNoKlienta message = new EpastiNoKlienta(
                contactRequest.getUserName(),
                contactRequest.getUserEmail(),
                contactRequest.getTopic(),
                contactRequest.getMessageContent()
            );
            
            messageService.saveMessage(message);
            System.out.println("Message saved to database: " + message); // Log the saved message
    
            // Send email
            String subject = "New message from " + contactRequest.getUserName();
            String body = "Message: " + contactRequest.getMessageContent() + "\n\nFrom: " + contactRequest.getUserEmail();
            emailSenderService.sendEmail("sparnishoptest@gmail.com", subject, body);

    
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send message: " + e.getMessage());
        }
    }
    

    public static class ContactRequest {
        private String userName;
        private String userEmail;
        private String topic;
        private String messageContent;

        // Getters and Setters
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getMessageContent() {
            return messageContent;
        }

        public void setMessageContent(String messageContent) {
            this.messageContent = messageContent;
        }
    }
}
