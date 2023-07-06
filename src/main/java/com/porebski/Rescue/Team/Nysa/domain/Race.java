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
@Table(name = "RACE")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<PlayersLap> playersLaps;

}
