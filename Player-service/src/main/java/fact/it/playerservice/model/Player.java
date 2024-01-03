package fact.it.playerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "player")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(nullable = true)
    private int age;
}
