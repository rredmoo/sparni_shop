package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.ClientsEmail;

public interface IClientsEmailService {

    void saveEmail(ClientsEmail epastiKlientam);

    ArrayList<ClientsEmail> getAllEmails() throws Exception;
}
