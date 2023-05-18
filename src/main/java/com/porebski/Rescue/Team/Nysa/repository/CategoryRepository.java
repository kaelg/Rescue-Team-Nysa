package com.porebski.Rescue.Team.Nysa.repository;

import com.porebski.Rescue.Team.Nysa.domain.Category;
import com.porebski.Rescue.Team.Nysa.domain.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Category create(Category category) {
        return this.entityManager.merge(category);
    }

    @Transactional
    public void deleteByTitle(String title) {
        entityManager.createQuery("delete from Category c where c.title=:title")
                .setParameter("title", title)
                .executeUpdate();
//        entityManager.createQuery("delete from Category where title="TestTitle"".executeUpdate();
    }




//    @Transactional
//    public boolean deleteByTitle(String title) {
//        this.entityManager.remove(entityManager.find(Category.class, title));
//        return true;
//    }

    public Category findByTitle(String title) {
        Query query = this.entityManager.createQuery("from Category where title=:title");
        query.setParameter("title", title);
        Object singleResult = query.getSingleResult();
        return (Category) singleResult;
    }

    public List<Category> findAll() {
        Query query = this.entityManager.createQuery("from Category");
        return query.getResultList();
    }
}
