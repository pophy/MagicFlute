package edu.neu.coe.repository;

import edu.neu.coe.model.Party;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PartyRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Party save(Party party) {
        entityManager.persist(party);
        return party;
    }

}
