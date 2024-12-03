package lv.venta.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "EpastiNoKlientiem")
@Entity
public class EmailFromClient {

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
    
    public EmailFromClient(String userName, String userEmail, String topic, String messageContent) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.topic = topic;
        this.messageContent = messageContent;
        this.receivedAt = LocalDateTime.now();
    }
}
