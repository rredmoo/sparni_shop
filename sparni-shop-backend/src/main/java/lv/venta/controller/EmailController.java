package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import lv.venta.model.EpastiNoKlienta;
import lv.venta.model.KlientuEpasti;
import lv.venta.model.Veikals_prece;
import lv.venta.service.EmailSendingService;
import lv.venta.service.IEpastiNoKlientaService;
import lv.venta.service.IKlientuEpastiService;

@RestController
@RequestMapping("api/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    // TODO sadalīt divos dažādos controllers [EpastiNoKlientaController] un
    // [EpastiKlientamController]
    private final EmailSendingService emailSenderService;

    @Autowired
    private IEpastiNoKlientaService epastiNoKlientaService;

    @Autowired
    private IKlientuEpastiService klientuEpastiService;

    @Autowired
    public EmailController(EmailSendingService emailSenderService, IEpastiNoKlientaService messageService) {
        this.emailSenderService = emailSenderService;
        this.epastiNoKlientaService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendContactMessage(@RequestBody ContactRequest contactRequest) {
        try {
            System.out.println("Received contact request: " + contactRequest);

            EpastiNoKlienta message = new EpastiNoKlienta(
                    contactRequest.getUserName(),
                    contactRequest.getUserEmail(),
                    contactRequest.getTopic(),
                    contactRequest.getMessageContent());

            epastiNoKlientaService.saveMessage(message);
            System.out.println("Message saved to database: " + message);

            // Send email
            String subject = "New message from " + contactRequest.getUserName();
            String body = "Message: " + contactRequest.getMessageContent() + "\n\nFrom: "
                    + contactRequest.getUserEmail();
            emailSenderService.sendEmail("sparnishoptest@gmail.com", subject, body);

            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ArrayList<EpastiNoKlienta> getEpastiNoKlientaAll() {
        try {
            return epastiNoKlientaService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/username/{username}")
    public ArrayList<EpastiNoKlienta> getEpastiNoKlientaByUserName(@PathVariable String username) {
        try {
            return epastiNoKlientaService.retrieveByUserName(username);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/topic/{topic}")
    public ArrayList<EpastiNoKlienta> getEpastiNoKlientaByTopic(@PathVariable String topic) {
        try {
            return epastiNoKlientaService.retrieveByTopic(topic);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/email/{email}")
    public ArrayList<EpastiNoKlienta> getEpastiNoKlientaByEmail(@PathVariable String email) {
        try {
            return epastiNoKlientaService.retrieveByEmail(email);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/date/after/{dateTime}")
    public ArrayList<EpastiNoKlienta> getEpastiNoKlientaByEmailDateAfter(@PathVariable LocalDateTime dateTime) {
        try {
            return epastiNoKlientaService.retrieveByDateAfter(dateTime);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/date/before/{dateTime}")
    public ArrayList<EpastiNoKlienta> getEpastiNoKlientaByEmailDateBefore(@PathVariable LocalDateTime dateTime) {
        try {
            return epastiNoKlientaService.retrieveByDateBefore(dateTime);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/date/between/{dateTimeStart}{dateTimeEnd}")
    public ArrayList<EpastiNoKlienta> getEpastiNoKlientaByEmailDateBetween(@PathVariable LocalDateTime dateTimeStart,
            LocalDateTime dateTimeEnd) {
        try {
            return epastiNoKlientaService.retrieveByDateBetween(dateTimeStart, dateTimeEnd);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @PostMapping("/client/email/save")
    public ResponseEntity<String> submitEmail(@RequestBody KlientuEpasti emailRequest) {
        try {
            klientuEpastiService.saveEmail(emailRequest);
            return ResponseEntity.ok("Email saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save email: " + e.getMessage());
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
