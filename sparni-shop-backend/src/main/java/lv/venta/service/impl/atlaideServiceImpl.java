package lv.venta.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lv.venta.model.Atlaide;
import lv.venta.repo.IAtlaideRepo;
import lv.venta.service.IAtlaideService;

@Service
public class atlaideServiceImpl implements IAtlaideService {

    @Autowired
    private IAtlaideRepo atlaideRepo;

    @Override
    public void create(Atlaide atlaide) {
        Atlaide izveidotaAtlaide = atlaideRepo.findByAtlaidesApmers(atlaide.getAtlaidesApmers());

        if (izveidotaAtlaide != null) {
            atlaideRepo.save(izveidotaAtlaide);
            return;
        }
        atlaideRepo.save(atlaide);
    }

    @Override
    public Atlaide retrieveById(int id) throws Exception {
        if (id < 0)
            throw new Exception("ID can`t be negative");

        if (atlaideRepo.existsById(id)) {
            return atlaideRepo.findById(id).get();
        } else {
            throw new Exception("Atlaide with this id (" + id + ") is not in the system");
        }
    }

    @Override
    public ArrayList<Atlaide> retrieveAll() throws Exception {
        if (atlaideRepo.count() == 0)
            throw new Exception("Sistēmā nav saglabāta neviena atlaide");
        return (ArrayList<Atlaide>) atlaideRepo.findAll();
    }

    @Override
    public void updateById(int id, Atlaide atlaide) throws Exception {
        Atlaide atlaideForUpdate = retrieveById(id);
        atlaideForUpdate.setAtlaidesApmers(atlaide.getAtlaidesApmers());
        atlaideForUpdate.setSakumaDatums(atlaide.getSakumaDatums());
        atlaideForUpdate.setBeiguDatums(atlaide.getBeiguDatums());

        atlaideRepo.save(atlaideForUpdate);
    }

    @Override
    public void deleteById(int id) throws Exception {
        Atlaide atlaideForDelete = retrieveById(id);
        atlaideRepo.delete(atlaideForDelete);
    }

}
