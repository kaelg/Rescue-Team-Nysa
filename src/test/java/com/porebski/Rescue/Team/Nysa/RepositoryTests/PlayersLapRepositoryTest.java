package com.porebski.Rescue.Team.Nysa.RepositoryTests;

import com.porebski.Rescue.Team.Nysa.domain.Player;
import com.porebski.Rescue.Team.Nysa.domain.PlayersLap;
import com.porebski.Rescue.Team.Nysa.repository.PlayerRepository;
import com.porebski.Rescue.Team.Nysa.repository.PlayersLapRepository;
import com.porebski.Rescue.Team.Nysa.repository.RaceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayersLapRepositoryTest {
    @Autowired
    private PlayersLapRepository playersLapRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private PlayerRepository playerRepository;

    //FIXME do poprawy 'findByNumber'
    @BeforeEach
    void setBefore() {
        PlayersLap playersLap = new PlayersLap();
        playersLap.setPlayer(playerRepository.findByNumber(7L));
        playersLap.setRace(raceRepository.findRaceByID(0L));
        playersLap.setLapTime("15:00");
        playersLapRepository.create(playersLap);
    }

    @AfterEach
    void tearDown() {
        this.playersLapRepository.deleteByPlayerId(7L);
    }

    @Test
    void findAllByPlayerIdAndRaceId(){
        setBefore();
        List<PlayersLap> lapList = playersLapRepository.findAllByPlayerIdAndRaceId(0L,0L);
        assertEquals(lapList.size(),9);
    }
}
