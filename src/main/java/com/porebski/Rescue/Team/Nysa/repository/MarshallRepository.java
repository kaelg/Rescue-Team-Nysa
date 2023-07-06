package com.porebski.Rescue.Team.Nysa.repository;

import com.porebski.Rescue.Team.Nysa.domain.Marshall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class MarshallRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Marshall create(Marshall marshall) {
        return this.entityManager.merge(marshall);
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("delete from Marshall").executeUpdate();
    }

    @Transactional
    public void deleteMarshallById(Long id) {
        Query query = this.entityManager.createQuery("delete from Marshall m where m.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteMarshallByName(String name) {
        Query query = this.entityManager.createQuery("delete from Marshall m where m.name=:name");
        query.setParameter("name", name);
        query.executeUpdate();
    }

    public Marshall findByName(String name) {
        Query query = this.entityManager.createQuery("from Marshall where name=:name");
        query.setParameter("name", name);
        Object singleResult = query.getSingleResult();
        return (Marshall) singleResult;
    }
    public Marshall findById(Long id) {
        Query query = this.entityManager.createQuery("from Marshall where id=:id");
        query.setParameter("id", id);
        Object singleResult = query.getSingleResult();
        return (Marshall) singleResult;
    }

    public List<Marshall> findAll() {
        Query query = this.entityManager.createQuery("from Marshall");
        return query.getResultList();
    }
}
