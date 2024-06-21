package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lv.venta.model.MainPage_ParMums;
import lv.venta.repo.IMainPageParMumsRepo;
import lv.venta.service.IMainPageParMumsCRUDService;

@Service
public class MainPageParMumsCRUDServiceImpl implements IMainPageParMumsCRUDService {
	@Autowired
    private final IMainPageParMumsRepo parMumsRepo;

    
    public MainPageParMumsCRUDServiceImpl(IMainPageParMumsRepo parMumsRepo) {
        this.parMumsRepo = parMumsRepo;
    }

    @Override
    public void create(MainPage_ParMums mainPageParMums) {
        parMumsRepo.save(mainPageParMums);
    }

    @Override
    public MainPage_ParMums retrieveById(int id) throws Exception {
        return parMumsRepo.findById(id)
                .orElseThrow(() -> new Exception("MainPage_ParMums not found with id: " + id));
    }

    @Override
    public ArrayList<MainPage_ParMums> retrieveAll() throws Exception {
        ArrayList<MainPage_ParMums> allParMums = (ArrayList<MainPage_ParMums>) parMumsRepo.findAll();
        if (allParMums.isEmpty()) {
            throw new Exception("No MainPage_ParMums records found.");
        }
        return new ArrayList<>(allParMums);
    }

    @Override
    public void updateById(int id, MainPage_ParMums mainPageParMums) throws Exception {
        if (!parMumsRepo.existsById(id)) {
            throw new Exception("MainPage_ParMums not found with id: " + id);
        }
        mainPageParMums.setIdmppm(id);
        parMumsRepo.save(mainPageParMums);
    }

    @Override
    public void deleteById(int id) throws Exception {
        if (!parMumsRepo.existsById(id)) {
            throw new Exception("MainPage_ParMums not found with id: " + id);
        }
        parMumsRepo.deleteById(id);
    }
}
