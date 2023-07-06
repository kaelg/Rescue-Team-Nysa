package com.porebski.Rescue.Team.Nysa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PLAYERS_LAP")
public class PlayersLap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "raceId")
    private Race race;
    @OneToOne
    @JoinColumn(name = "playerId")
    private Player player;
    private String lapTime;
    @OneToMany(mappedBy = "playersLap", cascade = CascadeType.ALL)
    private List<Penalties> penaltiesList;
}
