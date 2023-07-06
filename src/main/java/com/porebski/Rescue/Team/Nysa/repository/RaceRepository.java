package com.porebski.Rescue.Team.Nysa.repository;

import com.porebski.Rescue.Team.Nysa.domain.Race;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RaceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Race create(Race race) {
        return this.entityManager.merge(race);
    }

    @Transactional
    public void deleteByID(Long id) {
        Query query = this.entityManager.createQuery("delete from Race r where r.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteByCategory(Long categoryID) {
        Query query = this.entityManager.createQuery("delete from Race r where category_id=:id");
        query.setParameter("id", categoryID);
        query.executeUpdate();
    }

    public Race findRaceByID(Long id) {
        Query query = this.entityManager.createQuery("from Race r where r.id=:id");
        query.setParameter("id", id);
        //query.getSingleResult();
        return (Race) query.getSingleResult();
    }

    public List<Race> findRaceByCategory(Long categoryID) {
        Query query = this.entityManager.createQuery("from Race r where category_id=:id");
        query.setParameter("id", categoryID);
        return (List<Race>) query.getResultList();
    }


}
