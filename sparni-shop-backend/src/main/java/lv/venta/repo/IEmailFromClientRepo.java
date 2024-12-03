package lv.venta.repo;

import lv.venta.model.EmailFromClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;



public interface IEmailFromClientRepo extends JpaRepository<EmailFromClient, Long> {

    EmailFromClient findByIdenk(Long idenk);
    ArrayList<EmailFromClient> findByUserNameIgnoreCase(String userName);
    ArrayList<EmailFromClient> findByUserEmailIgnoreCase(String userEmail);
    ArrayList<EmailFromClient> findByTopicIgnoreCase(String topic);

    //filter by date
    ArrayList<EmailFromClient> findByReceivedAtAfter(LocalDateTime date);
    ArrayList<EmailFromClient> findByReceivedAtBefore(LocalDateTime date);
    ArrayList<EmailFromClient> findByReceivedAtBetween(LocalDateTime startDate, LocalDateTime endDate);


}
