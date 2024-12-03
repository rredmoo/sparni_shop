package lv.venta.service;

import lv.venta.model.EmailFromClient;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IEmailFromClientService {

    public abstract void saveMessage(EmailFromClient message);

    public abstract EmailFromClient retrieveById(Long id) throws Exception;

    public abstract ArrayList<EmailFromClient> retrieveAll() throws Exception;

    public abstract ArrayList<EmailFromClient> retrieveByUserName(String username) throws Exception;

    public abstract ArrayList<EmailFromClient> retrieveByEmail(String email) throws Exception;

    public abstract ArrayList<EmailFromClient> retrieveByTopic(String topic) throws Exception;

    public abstract ArrayList<EmailFromClient> retrieveByDateAfter(LocalDateTime date) throws Exception;

    public abstract ArrayList<EmailFromClient> retrieveByDateBefore(LocalDateTime date) throws Exception;

    public abstract ArrayList<EmailFromClient> retrieveByDateBetween(LocalDateTime dateStart, LocalDateTime dateEnd) throws Exception;

}
