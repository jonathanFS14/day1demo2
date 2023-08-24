package demo2.day1demo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "spiller")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( name = "player_name", length = 70, nullable = false)
    private String name;
    private String country;
    private String position;

    public Player(String name, String country, String position) {
        this.name = name;
        this.country = country;
        this.position = position;
    }

}

