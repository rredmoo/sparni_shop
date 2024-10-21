package lv.venta.repo;

import lv.venta.model.EpastiNoKlienta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;



public interface EpastiNoKlientaRepo extends JpaRepository<EpastiNoKlienta, Long> {

    ArrayList<EpastiNoKlienta> findByIdenk(int idenk);
}
