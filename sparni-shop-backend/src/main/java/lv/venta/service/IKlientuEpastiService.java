package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.KlientuEpasti;

public interface IKlientuEpastiService {

    void saveEmail(KlientuEpasti epastiKlientam);

    ArrayList<KlientuEpasti> getAllEmails() throws Exception;
}
