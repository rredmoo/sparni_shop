package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.venta.model.AutomaticEmails;
import lv.venta.model.ClientsEmail;
import lv.venta.model.ContactRequest;
import lv.venta.model.EmailFromClient;
import lv.venta.model.Product;
import lv.venta.service.EmailSendingService;
import lv.venta.service.IClientsEmailService;
import lv.venta.service.IEmailFromClientService;

@RestController
@RequestMapping("api/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    // TODO sadalīt divos dažādos controllers [EpastiNoKlientaController] un
    // [EpastiKlientamController]
    private final EmailSendingService emailSenderService;

    @Autowired
    private IEmailFromClientService epastiNoKlientaService;

    @Autowired
    private IClientsEmailService klientuEpastiService;

    @Autowired
    public EmailController(EmailSendingService emailSenderService, IEmailFromClientService messageService) {
        this.emailSenderService = emailSenderService;
        this.epastiNoKlientaService = messageService;
    }

    // Epasts, kas tiek saņemts no klienta pēc kontaktu sadaļas aizpildīšanas
    @PostMapping("/send")
    public ResponseEntity<String> sendContactMessage(@RequestBody ContactRequest ContactRequest) {
        try {
            System.out.println("Received contact request: " + ContactRequest);

            EmailFromClient message = new EmailFromClient(
                    ContactRequest.getUserName(),
                    ContactRequest.getUserEmail(),
                    ContactRequest.getTopic(),
                    ContactRequest.getMessageContent());

            epastiNoKlientaService.saveMessage(message);
            System.out.println("Message saved to database: " + message);

            // Send email
            String subject = "New message from " + ContactRequest.getUserName();
            String body = "Message: " + ContactRequest.getMessageContent() + "\n\nFrom: "
                    + ContactRequest.getUserEmail();
            emailSenderService.sendEmail("sparnishoptest@gmail.com", subject, body);

            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message: " + e.getMessage());
        }
    }

    // CRUD priekš epastiem, kas saņemti no klienta
    @GetMapping("/all")
    public ArrayList<EmailFromClient> getEpastiNoKlientaAll() {
        try {
            return epastiNoKlientaService.retrieveAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/username/{username}")
    public ArrayList<EmailFromClient> getEpastiNoKlientaByUserName(@PathVariable String username) {
        try {
            return epastiNoKlientaService.retrieveByUserName(username);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/topic/{topic}")
    public ArrayList<EmailFromClient> getEpastiNoKlientaByTopic(@PathVariable String topic) {
        try {
            return epastiNoKlientaService.retrieveByTopic(topic);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/email/{email}")
    public ArrayList<EmailFromClient> getEpastiNoKlientaByEmail(@PathVariable String email) {
        try {
            return epastiNoKlientaService.retrieveByEmail(email);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/date/after/{dateTime}")
    public ArrayList<EmailFromClient> getEpastiNoKlientaByEmailDateAfter(@PathVariable LocalDateTime dateTime) {
        try {
            return epastiNoKlientaService.retrieveByDateAfter(dateTime);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/date/before/{dateTime}")
    public ArrayList<EmailFromClient> getEpastiNoKlientaByEmailDateBefore(@PathVariable LocalDateTime dateTime) {
        try {
            return epastiNoKlientaService.retrieveByDateBefore(dateTime);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    @GetMapping("/date/between/{dateTimeStart}{dateTimeEnd}")
    public ArrayList<EmailFromClient> getEpastiNoKlientaByEmailDateBetween(@PathVariable LocalDateTime dateTimeStart,
            LocalDateTime dateTimeEnd) {
        try {
            return epastiNoKlientaService.retrieveByDateBetween(dateTimeStart, dateTimeEnd);
        } catch (Exception e) {
            // error msg
            return null;
        }
    }

    // SAglabā klienta epastu, ja ir veikta reģistrēšanās automātiskajiem epastiem
    @PostMapping("/client/email/save")
    public ResponseEntity<String> submitEmail(@RequestBody ClientsEmail emailRequest) {
        try {
            klientuEpastiService.saveEmail(emailRequest);
            return ResponseEntity.ok("Email saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save email: " + e.getMessage());
        }
    }

    // Nosūta epastu visiem klientiem, kuru epasti saglabāti automātisko epastu sūtīšanai
    @PostMapping("/send-bulk-email")
    public ResponseEntity<String> sendBulkEmail(@RequestBody AutomaticEmails automatiskieEpasti) {
        try {
            emailSenderService.sendEmailToAllClients(automatiskieEpasti.getSubject(), automatiskieEpasti.getBody());
            return ResponseEntity.ok("Emails sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send emails: " + e.getMessage());
        }
    }
}
