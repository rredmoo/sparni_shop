package lv.venta.repo;

import lv.venta.model.EpastiNoKlienta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;



public interface EpastiNoKlientaRepo extends JpaRepository<EpastiNoKlienta, Long> {

    // basic filtrations by id, name, topic, email
    ArrayList<EpastiNoKlienta> findByIdenk(int idenk);
    ArrayList<EpastiNoKlienta> findByUserNameIgnoreCase(String userName);
    ArrayList<EpastiNoKlienta> findByUserEmailIgnoreCase(String userEmail);
    ArrayList<EpastiNoKlienta> findByTopicIgnoreCase(String topic);

    //filter by date
    ArrayList<EpastiNoKlienta> findByReceivedAtAfter(LocalDateTime date);
    ArrayList<EpastiNoKlienta> findByReceivedAtBefore(LocalDateTime date);
    ArrayList<EpastiNoKlienta> findByReceivedAtBetween(LocalDateTime startDate, LocalDateTime endDate);


}
