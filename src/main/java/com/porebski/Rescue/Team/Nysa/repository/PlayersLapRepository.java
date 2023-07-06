package com.porebski.Rescue.Team.Nysa.repository;

import com.porebski.Rescue.Team.Nysa.domain.PlayersLap;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PlayersLapRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public PlayersLap create(PlayersLap playersLap) {
        return this.entityManager.merge(playersLap);
    }

    @Transactional
    public void deleteById(Long id) {
        Query query = this.entityManager.createQuery("delete from Players_lap p where p.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteByPlayerId(Long id) {
        Query query = this.entityManager.createQuery("delete from Players_lap where player_id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public List<PlayersLap> findAllByPlayerIdAndRaceId(Long playerId, Long raceId) {
        Query query = this.entityManager.createQuery("select p from Players_lap p where player_id=:playerId AND race_id=:raceId");
        query.setParameter("playerId", playerId).setParameter("raceId", raceId);
        return (List<PlayersLap>) query.getResultList();
    }

    public PlayersLap findLastByPlayerIdAndRaceId(Long playerId, Long raceId) {
        Query query = this.entityManager.createQuery("select p from Players_lap p where player_id=:playerId AND race_id=: order by p.id DESC");
        query.setParameter("playerId", playerId).setParameter("raceId", raceId);
        return (PlayersLap) query.getResultList().get(0);
    }

    public PlayersLap findById(Long id) {
        Query query = this.entityManager.createQuery("select p from Players_lap p where p.id=:id");
        query.setParameter("id", id);
        return (PlayersLap) query.getSingleResult();
    }

}
