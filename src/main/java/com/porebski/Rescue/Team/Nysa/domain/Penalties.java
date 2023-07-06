package com.porebski.Rescue.Team.Nysa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PENALTIES")
public class Penalties {
    //@JoinColumn(name = "address_id", referencedColumnName = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "playersLapId")
    private PlayersLap playersLap;
    private int type;
    @OneToOne
    @JoinColumn(name = "marshallId")
    private Marshall marshall;
}
