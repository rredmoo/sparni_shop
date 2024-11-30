package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.MainPage_BiedribaDarbojas;
import lv.venta.repo.IMainPageBiedribasDarbojasRepo;
import lv.venta.service.IMainPageBiedribasDarbojasCRUDService;

@Service
public class MainPageBiedribasDarbojasServiceImpl implements IMainPageBiedribasDarbojasCRUDService {

    private static final Logger logger = LoggerFactory.getLogger(MainPageBiedribasDarbojasServiceImpl.class);

    @Autowired
    private IMainPageBiedribasDarbojasRepo repository;

    public MainPageBiedribasDarbojasServiceImpl(IMainPageBiedribasDarbojasRepo repository) {
        this.repository = repository;
    }

    @Override
    public void create(MainPage_BiedribaDarbojas mainPageBiedribaDarbojas) {
        try {
            repository.save(mainPageBiedribaDarbojas);
            logger.info("Kategorija ar ID {} veiksmīgi izveidota.", mainPageBiedribaDarbojas.getIdmpbd());
        } catch (Exception e) {
            logger.error("Kļūda izveidojot kategoriju ar ID {}: {}", mainPageBiedribaDarbojas.getIdmpbd(), e.getMessage());
            throw new UnsupportedOperationException("Notikusi kļūda, mēģinot izveidot kategoriju: " + e.getMessage(), e);
        }
    }

    @Override
    public MainPage_BiedribaDarbojas retrieveById(int id) throws Exception {
        try {
            Optional<MainPage_BiedribaDarbojas> optionalEntity = repository.findById(id);
            return optionalEntity.orElseThrow(() -> new Exception("Entītija ar šo id" + id + " nav atrasta."));
        } catch (Exception e) {
            logger.error("Kļūda iegūstot kategoriju ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt kategoriju ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<MainPage_BiedribaDarbojas> retrieveAll() throws Exception {
        try {
            ArrayList<MainPage_BiedribaDarbojas> entities = (ArrayList<MainPage_BiedribaDarbojas>) repository.findAll();
            if (entities.isEmpty()) {
                throw new Exception("Nav atrasta neviena kategorija.");
            }
            return new ArrayList<>(entities);
        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas kategorijas: {}", e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot iegūt visas kategorijas: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, MainPage_BiedribaDarbojas mainPageBiedribaDarbojas) throws Exception {
        try {
            if (!repository.existsById(id)) {
                throw new Exception("Entītija ar šo " + id + " nav atrasta.");
            }
            repository.save(mainPageBiedribaDarbojas);
            logger.info("Kategorija ar ID {} veiksmīgi atjaunināta.", id);
        } catch (Exception e) {
            logger.error("Kļūda atjauninot kategoriju ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot atjaunināt kategoriju ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            if (!repository.existsById(id)) {
                throw new Exception("Entity with ID " + id + " not found.");
            }
            repository.deleteById(id);
            logger.info("Kategorija ar ID {} veiksmīgi dzēsta.", id);
        } catch (Exception e) {
            logger.error("Kļūda dzēšot kategoriju ar ID {}: {}", id, e.getMessage());
            throw new Exception("Notikusi kļūda, mēģinot dzēst kategoriju ar ID " + id + ": " + e.getMessage());
        }
    }
}
