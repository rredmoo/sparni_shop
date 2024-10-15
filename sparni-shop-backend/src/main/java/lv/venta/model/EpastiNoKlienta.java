package lv.venta.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Messages")
@Entity
public class EpastiNoKlienta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String userEmail;
    private String topic;
    private String messageContent;

    public EpastiNoKlienta(String userName, String userEmail, String topic, String messageContent) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.topic = topic;
        this.messageContent = messageContent;
    }
}
