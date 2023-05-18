package com.porebski.Rescue.Team.Nysa.repository;

import com.porebski.Rescue.Team.Nysa.domain.Category;
import com.porebski.Rescue.Team.Nysa.domain.Player;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class PlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Player create(Player player) {
        return this.entityManager.merge(player);
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("delete from Player").executeUpdate();
    }

    @Transactional
    public void deleteTestPlayer() {
        entityManager.createQuery("delete from Player where number=42L").executeUpdate();
    }


    public Player findByNumber(Long number) {
        Query query = this.entityManager.createQuery("from Player where number=:number");
        query.setParameter("number", number);
        Object singleResult = query.getSingleResult();
        return (Player) singleResult;
    }

    public List<Player> findAll() {
        Query query = this.entityManager.createQuery("from Player");
        return query.getResultList();
    }
}
