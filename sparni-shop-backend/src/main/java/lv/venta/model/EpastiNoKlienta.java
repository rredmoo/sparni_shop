package lv.venta.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "EpastiNoKlientiem")
@Entity
public class EpastiNoKlienta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idenk;

    @Column(name = "Username")
    private String userName;
    @Column(name = "Email")
    private String userEmail;
    @Column(name = "Topic")
    private String topic;
    @Column(name = "MessageContent")
    private String messageContent;
    @Column(name = "ReceivedAt")
    private LocalDateTime receivedAt;
    
    public EpastiNoKlienta(String userName, String userEmail, String topic, String messageContent) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.topic = topic;
        this.messageContent = messageContent;
        this.receivedAt = LocalDateTime.now();
    }
}
