package com.porebski.Rescue.Team.Nysa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @Table(name = "CATEGORY")
    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        private String title;
    //one to many
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
        private List<Player> players;

        public Category(String title) {
            this.title = title;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && title.equals(category.title) && Objects.equals(players, category.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, players);
    }
}
