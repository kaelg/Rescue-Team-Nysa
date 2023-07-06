package com.porebski.Rescue.Team.Nysa.RepositoryTests;

import com.porebski.Rescue.Team.Nysa.domain.Category;
import com.porebski.Rescue.Team.Nysa.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setBefore() {
        Category category = new Category();
        category.setTitle("TestTitle");
        categoryRepository.create(category);

    }

    @AfterEach
    void tearDown() {
        this.categoryRepository.deleteByTitle("TestTitle");
    }

    @Test
    void getByTitle() {
        Category foundCategory = categoryRepository.findByTitle("TestTitle");
        assertEquals(foundCategory.getTitle(), "TestTitle");
    }
}
