package lv.venta.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.EpastiNoKlienta;
import lv.venta.repo.EpastiNoKlientaRepo;
import lv.venta.service.IEpastiNoKlientaService;

@Service
public class epastiNoKlientaServiceImpl implements IEpastiNoKlientaService {

    @Autowired
    private EpastiNoKlientaRepo messageRepo;

    @Override
    public void saveMessage(EpastiNoKlienta message) {
        try {
            messageRepo.save(message);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error occurred while saving the message: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveAll() throws Exception {
        if (messageRepo.count() == 0) {
            throw new Exception("Nav neviena epasta!");
        }
        return (ArrayList<EpastiNoKlienta>) messageRepo.findAll();
    }

    @Override
    public EpastiNoKlienta retrieveById(Long id) throws Exception {
        return messageRepo.findById(id)
                .orElseThrow(() -> new Exception("Epasts nav atrasts ar id: " + id));
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveByUserName(String username) throws Exception {
        ArrayList<EpastiNoKlienta> message = messageRepo.findByUserNameIgnoreCase(username);
        if (message == null) {
            throw new Exception("Nav atrasts epasts ar lietotājvārdu: " + username);
        }
        return message;
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveByEmail(String email) throws Exception {
        ArrayList<EpastiNoKlienta> message = messageRepo.findByUserEmailIgnoreCase(email);
        if (message == null) {
            throw new Exception("Nav atrasts epasts ar epasta adresi: " + email);
        }
        return message;
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveByTopic(String topic) throws Exception {
        ArrayList<EpastiNoKlienta> message = messageRepo.findByTopicIgnoreCase(topic);
        if (message == null) {
            throw new Exception("Nav atrasts epasts ar tēmu: " + topic);
        }
        return message;
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveByDateAfter(LocalDateTime date) throws Exception {
        ArrayList<EpastiNoKlienta> messages = messageRepo.findByReceivedAtAfter(date);
        if (messages.isEmpty()) {
            throw new Exception("Nav atrasti epasti pēc datuma: " + date);
        }
        return messages;
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveByDateBefore(LocalDateTime date) throws Exception {
        ArrayList<EpastiNoKlienta> messages = messageRepo.findByReceivedAtBefore(date);
        if (messages.isEmpty()) {
            throw new Exception("Nav atrasti epasti pirms datuma: " + date);
        }
        return messages;
    }

    @Override
    public ArrayList<EpastiNoKlienta> retrieveByDateBetween(LocalDateTime dateStart, LocalDateTime dateEnd) throws Exception {
        ArrayList<EpastiNoKlienta> messages = messageRepo.findByReceivedAtBetween(dateStart, dateEnd);
        if (messages.isEmpty()) {
            throw new Exception("Nav atrasti epasti starp datumiem: " + dateStart + " un " + dateEnd);
        }
        return messages;
    }
}
