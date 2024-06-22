package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.MainPage_BiedribaDarbojas;
import lv.venta.repo.IMainPageBiedribasDarbojasRepo;
import lv.venta.service.IMainPageBiedribasDarbojasCRUDService;

@Service
public class MainPageBiedribasDarbojasServiceImpl implements IMainPageBiedribasDarbojasCRUDService {

    @Autowired
	private IMainPageBiedribasDarbojasRepo repository;

    
    public MainPageBiedribasDarbojasServiceImpl(IMainPageBiedribasDarbojasRepo repository) {
        this.repository = repository;
    }

    @Override
    public void create(MainPage_BiedribaDarbojas mainPageBiedribaDarbojas) {
        repository.save(mainPageBiedribaDarbojas);
    }

    @Override
    public MainPage_BiedribaDarbojas retrieveById(int id) throws Exception {
        Optional<MainPage_BiedribaDarbojas> optionalEntity = repository.findById(id);
        return optionalEntity.orElseThrow(() -> new Exception("Entity not found for id: " + id));
    }

    @Override
    public ArrayList<MainPage_BiedribaDarbojas> retrieveAll() throws Exception {
        ArrayList<MainPage_BiedribaDarbojas> entities = (ArrayList<MainPage_BiedribaDarbojas>) repository.findAll();
        if (entities.isEmpty()) {
            throw new Exception("No entities found.");
        }
        return new ArrayList<>(entities);
    }

    @Override
    public void updateById(int id, MainPage_BiedribaDarbojas mainPageBiedribaDarbojas) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("Entity not found for id: " + id);
        }
        repository.save(mainPageBiedribaDarbojas);
    }

    @Override
    public void deleteById(int id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("Entity not found for id: " + id);
        }
        repository.deleteById(id);
    }
}
