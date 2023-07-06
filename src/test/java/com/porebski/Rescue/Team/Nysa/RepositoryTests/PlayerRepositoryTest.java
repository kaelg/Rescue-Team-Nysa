package com.porebski.Rescue.Team.Nysa.RepositoryTests;

import com.porebski.Rescue.Team.Nysa.domain.Player;
import com.porebski.Rescue.Team.Nysa.repository.CategoryRepository;
import com.porebski.Rescue.Team.Nysa.repository.PlayerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerRepositoryTest {
    private static final String FIRST_NAME = "Bartek";
    private static final String LAST_NAME = "Porebski";
    private static final Long NUMBER = 42L;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setBefore() {
        Player player = new Player();
        player.setFirstName(FIRST_NAME);
        player.setLastName(LAST_NAME);
        player.setNumber(NUMBER);
        player.setCategory(categoryRepository.findByTitle("gp1"));
        playerRepository.create(player);
    }

    @AfterEach
    void tearDown() {
        this.playerRepository.deleteTestPlayer();
    }

    @Test
    void findByNumber() {
        Player playerFromRepo = playerRepository.findByNumber(42L);
        assertEquals(playerFromRepo.getFirstName(), "Bartek");
    }

    @Test
    void findByNumberAndCategoryID() {
        Player playerFromRepo = playerRepository.findByNumberAndCategory(42L, 1L);
        assertEquals(playerFromRepo.getFirstName(), "Bartek");
    }


}
