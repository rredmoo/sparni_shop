package lv.venta.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Discount;
import lv.venta.repo.IDiscountRepo;
import lv.venta.service.IDiscountService;

@Service
public class DiscountServiceImpl implements IDiscountService {

    private static final Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);

    @Autowired
    private IDiscountRepo atlaideRepo;

    @Override
    public void create(Discount atlaide) {
        try {
            Discount existingAtlaide = atlaideRepo.findByAtlaidesApmers(atlaide.getAtlaidesApmers());

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
    public Discount retrieveById(int id) throws Exception {
        try {
            if (id < 0) {
                throw new Exception("ID nedrīkst būt negatīvs");
            }

            if (!atlaideRepo.existsById(id)) {
                throw new Exception("Atlaide ar ID " + id + " netika atrasta sistēmā");
            }

            Discount atlaide = atlaideRepo.findById(id).orElseThrow(() -> new Exception("Atlaide ar ID " + id + " netika atrasta"));
            logger.info("Atlaide ar ID {} veiksmīgi iegūta.", id);
            return atlaide;

        } catch (Exception e) {
            logger.error("Kļūda iegūstot atlaidi ar ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot iegūt atlaidi ar ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Discount> retrieveAll() throws Exception {
        try {
            long count = atlaideRepo.count();
            if (count == 0) {
                throw new Exception("Sistēmā nav saglabātas nevienas atlaides");
            }

            ArrayList<Discount> atlaides = (ArrayList<Discount>) atlaideRepo.findAll();
            logger.info("Visas atlaides veiksmīgi iegūtas. Kopā: {}", count);
            return atlaides;

        } catch (Exception e) {
            logger.error("Kļūda iegūstot visas atlaides: {}", e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot iegūt visas atlaides: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, Discount atlaide) throws Exception {
        try {
            Discount existingAtlaide = retrieveById(id);

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
            Discount atlaideForDelete = retrieveById(id);
            atlaideRepo.delete(atlaideForDelete);
            logger.info("Atlaide ar ID {} veiksmīgi dzēsta.", id);

        } catch (Exception e) {
            logger.error("Kļūda dzēšot atlaidi ar ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Kļūda, mēģinot dzēst atlaidi ar ID " + id + ": " + e.getMessage(), e);
        }
    }
}
