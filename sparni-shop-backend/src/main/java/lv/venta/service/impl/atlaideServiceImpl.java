package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Atlaide;
import lv.venta.repo.IAtlaideRepo;
import lv.venta.service.IAtlaideService;

@Service
public class atlaideServiceImpl implements IAtlaideService {

    private static final Logger logger = LoggerFactory.getLogger(atlaideServiceImpl.class);

    @Autowired
    private IAtlaideRepo atlaideRepo;

    @Override
    public void create(Atlaide atlaide) {
        try {
            Atlaide existingAtlaide = atlaideRepo.findByAtlaidesApmers(atlaide.getAtlaidesApmers());

            if (existingAtlaide != null) {
                logger.warn("Atlaide ar šo apmēru jau eksistē: {}", atlaide.getAtlaidesApmers());
                throw new Exception("Atlaide ar šo apmēru jau eksistē!");
            }

            atlaideRepo.save(atlaide);
            logger.info("Atlaide ar apmēru '{}' veiksmīgi izveidota.", atlaide.getAtlaidesApmers());

        } catch (Exception e) {
            logger.error("Kļūda izveidojot atlaidi: {}", e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot pievienot atlaidi: " + e.getMessage(), e);
        }
    }

    @Override
    public Atlaide retrieveById(int id) throws Exception {
        try {
            if (id < 0) {
                throw new Exception("ID nedrīkst būt negatīvs");
            }

            if (!atlaideRepo.existsById(id)) {
                throw new Exception("Atlaide ar ID " + id + " netika atrasta sistēmā");
            }

            Atlaide atlaide = atlaideRepo.findById(id).orElseThrow(() -> new Exception("Atlaide ar ID " + id + " netika atrasta"));
            logger.info("Atlaide ar ID {} veiksmīgi iegūta.", id);
            return atlaide;

        } catch (Exception e) {
            logger.error("Kļūda iegūstot atlaidi ar ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot iegūt atlaidi ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Atlaide> retrieveAll() throws Exception {
        try {
            long count = atlaideRepo.count();
            if (count == 0) {
                throw new Exception("Sistēmā nav saglabātas nevienas atlaides");
            }

            ArrayList<Atlaide> atlaides = (ArrayList<Atlaide>) atlaideRepo.findAll();
            logger.info("Visas atlaides veiksmīgi iegūtas. Kopā: {}", count);
            return atlaides;

        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas atlaides: {}", e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot iegūt visas atlaides: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Atlaide atlaide) throws Exception {
        try {
            Atlaide existingAtlaide = retrieveById(id);

            existingAtlaide.setAtlaidesApmers(atlaide.getAtlaidesApmers());
            existingAtlaide.setSakumaDatums(atlaide.getSakumaDatums());
            existingAtlaide.setBeiguDatums(atlaide.getBeiguDatums());

            atlaideRepo.save(existingAtlaide);
            logger.info("Atlaide ar ID {} veiksmīgi atjaunināta.", id);

        } catch (Exception e) {
            logger.error("Kļūda atjauninot atlaidi ar ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot atjaunināt atlaidi ar ID " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try {
            Atlaide atlaideForDelete = retrieveById(id);
            atlaideRepo.delete(atlaideForDelete);
            logger.info("Atlaide ar ID {} veiksmīgi dzēsta.", id);

        } catch (Exception e) {
            logger.error("Kļūda dzēšot atlaidi ar ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot dzēst atlaidi ar ID " + id + ": " + e.getMessage(), e);
        }
    }
}
