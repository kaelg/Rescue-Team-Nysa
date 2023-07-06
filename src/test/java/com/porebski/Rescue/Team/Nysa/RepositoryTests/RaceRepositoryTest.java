package com.porebski.Rescue.Team.Nysa.RepositoryTests;

import com.porebski.Rescue.Team.Nysa.domain.Race;
import com.porebski.Rescue.Team.Nysa.repository.CategoryRepository;
import com.porebski.Rescue.Team.Nysa.repository.RaceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RaceRepositoryTest {
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setBefore() {
        Race race = new Race();
        race.setCategory(categoryRepository.findByTitle("gp1"));
        raceRepository.create(race);
    }

    //FIXME usuwa wszystkie RACE z GP1
    @AfterEach
    void tearDown() {
        this.raceRepository.deleteByCategory(1L);
    }

    @Test
    void findByCategory() {
        List<Race> raceFromRepo = raceRepository.findRaceByCategory(1L);
        assertEquals(raceFromRepo.size(), 1);
    }

    @Test
    void findByID() {
        List<Race> raceByCategory = raceRepository.findRaceByCategory(1L);
        Race raceFromRepo = raceRepository.findRaceByID(raceByCategory.get(0).getId());
        assertEquals(raceFromRepo.getCategory().getTitle(), "gp1");
    }

}
