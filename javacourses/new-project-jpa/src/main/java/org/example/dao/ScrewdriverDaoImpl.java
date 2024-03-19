package org.example.dao;

import org.example.entity.Screwdriver;
import org.example.enums.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ScrewdriverDaoImpl implements ScrewdriversDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Screwdriver screwdriver) {
        entityManager.persist(screwdriver);
    }

    @Override
    public void delete(Screwdriver screwdriver) {
        entityManager.remove(screwdriver);
    }

    @Override
    public List<Screwdriver> findAll() {
        String jpql = "FROM Screwdriver";

        TypedQuery<Screwdriver> query = entityManager.createQuery(jpql, Screwdriver.class);

        return query.getResultList();
    }

    @Override
    public List<Screwdriver> findByCountry(Country country) {
        String jpql = "FROM Screwdriver WHERE country = :country";

        TypedQuery<Screwdriver> query = entityManager.createQuery(jpql, Screwdriver.class);

        query.setParameter("country", country);

        return query.getResultList();
    }

    @Override
    public Optional<Screwdriver> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(Screwdriver.class, id));
    }

    @Override
    public void update(Screwdriver screwdriver) {
        entityManager.merge(screwdriver);

        entityManager.detach(screwdriver);
    }
}
