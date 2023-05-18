package com.porebski.Rescue.Team.Nysa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String LastName;
    private Long number;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Player(String firstName, String lastName, Long number, Category category) {
        this.firstName = firstName;
        LastName = lastName;
        this.number = number;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id) && firstName.equals(player.firstName) && LastName.equals(player.LastName) && number.equals(player.number) && category.equals(player.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, LastName, number, category);
    }
}