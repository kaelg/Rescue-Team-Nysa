package com.porebski.Rescue.Team.Nysa.RepositoryTests;

import com.porebski.Rescue.Team.Nysa.domain.Marshall;
import com.porebski.Rescue.Team.Nysa.repository.MarshallRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MarshallRepositoryTest {
    private static final Long ID = 1L;
    private static final String NAME = "Bartosz Porebski";
    @Autowired
    private MarshallRepository marshallRepository;

    @BeforeEach
    void setBefore() {
        Marshall marshall = new Marshall();
        marshall.setName("Rafal");
        marshallRepository.create(marshall);
    }

    @AfterEach
    void tearDown() {
        this.marshallRepository.deleteMarshallByName("Rafal");
    }

    @Test
    void findById() {
        Marshall marshallFromRepo = marshallRepository.findById(ID);
        assertEquals(marshallFromRepo.getName(), NAME);
    }

    @Test
    void findByName() {
        Marshall marshallFromRepo = marshallRepository.findByName("Rafal");
        assertEquals(marshallFromRepo.getName(), "Rafal");
    }

    @Test
    void findAll() {
        List<Marshall> marshallsFromRepo = marshallRepository.findAll();
        List<Marshall> expectedMarshalls = new ArrayList<>();
        Marshall marshall1 = new Marshall(NAME);
        Marshall marshall2 = new Marshall("Rafal");
        expectedMarshalls.add(marshall1);
        expectedMarshalls.add(marshall2);
        assertEquals(marshallsFromRepo.size(), expectedMarshalls.size());
    }

}
