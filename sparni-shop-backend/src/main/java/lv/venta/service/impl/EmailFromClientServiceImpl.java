package lv.venta.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.EmailFromClient;
import lv.venta.repo.IEmailFromClientRepo;
import lv.venta.service.IEmailFromClientService;

@Service
public class EmailFromClientServiceImpl implements IEmailFromClientService {

    private static final Logger logger = LoggerFactory.getLogger(EmailFromClientServiceImpl.class);

    @Autowired
    private IEmailFromClientRepo messageRepo;

    @Override
    public void saveMessage(EmailFromClient message) {
        try {
            messageRepo.save(message);
        } catch (Exception e) {
            logger.error("Kļūda saglabājot epastu: {}", e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot saglabāt epastu: " + e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<EmailFromClient> retrieveAll() throws Exception {
        try {
            if (messageRepo.count() == 0) {
                throw new Exception("Nav neviena epasta!");
            }
            return (ArrayList<EmailFromClient>) messageRepo.findAll();
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visus epastus: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visus epastus: " + e.getMessage());
        }
    }

    @Override
    public EmailFromClient retrieveById(Long id) throws Exception {
        try {
            return messageRepo.findById(id)
                    .orElseThrow(() -> new Exception("Epasts nav atrasts ar id: " + id));
        } catch (Exception e) {
            logger.error("Kļūda iegūstot epastu ar id {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt epastu ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<EmailFromClient> retrieveByUserName(String username) throws Exception {
        try {
            ArrayList<EmailFromClient> messages = messageRepo.findByUserNameIgnoreCase(username);
            if (messages == null || messages.isEmpty()) {
                throw new Exception("Nav atrasts epasts ar lietotājvārdu: " + username);
            }
            return messages;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot epastus ar lietotājvārdu {}: {}", username, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt epastus ar lietotājvārdu " + username + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<EmailFromClient> retrieveByEmail(String email) throws Exception {
        try {
            ArrayList<EmailFromClient> messages = messageRepo.findByUserEmailIgnoreCase(email);
            if (messages == null || messages.isEmpty()) {
                throw new Exception("Nav atrasts epasts ar epasta adresi: " + email);
            }
            return messages;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot epastus ar epasta adresi {}: {}", email, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt epastus ar epasta adresi " + email + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<EmailFromClient> retrieveByTopic(String topic) throws Exception {
        try {
            ArrayList<EmailFromClient> messages = messageRepo.findByTopicIgnoreCase(topic);
            if (messages == null || messages.isEmpty()) {
                throw new Exception("Nav atrasts epasts ar tēmu: " + topic);
            }
            return messages;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot epastus ar tēmu {}: {}", topic, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt epastus ar tēmu " + topic + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<EmailFromClient> retrieveByDateAfter(LocalDateTime date) throws Exception {
        try {
            ArrayList<EmailFromClient> messages = messageRepo.findByReceivedAtAfter(date);
            if (messages.isEmpty()) {
                throw new Exception("Nav atrasti epasti pēc datuma: " + date);
            }
            return messages;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot epastus pēc datuma {}: {}", date, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt epastus pēc datuma " + date + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<EmailFromClient> retrieveByDateBefore(LocalDateTime date) throws Exception {
        try {
            ArrayList<EmailFromClient> messages = messageRepo.findByReceivedAtBefore(date);
            if (messages.isEmpty()) {
                throw new Exception("Nav atrasti epasti pirms datuma: " + date);
            }
            return messages;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot epastus pirms datuma {}: {}", date, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt epastus pirms datuma " + date + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<EmailFromClient> retrieveByDateBetween(LocalDateTime dateStart, LocalDateTime dateEnd) throws Exception {
        try {
            ArrayList<EmailFromClient> messages = messageRepo.findByReceivedAtBetween(dateStart, dateEnd);
            if (messages.isEmpty()) {
                throw new Exception("Nav atrasti epasti starp datumiem: " + dateStart + " un " + dateEnd);
            }
            return messages;
        } catch (Exception e) {
            logger.error("Kļūda iegūstot epastus starp datumiem {} un {}: {}", dateStart, dateEnd, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt epastus starp datumiem " + dateStart + " un " + dateEnd + ": " + e.getMessage());
        }
    }
}
