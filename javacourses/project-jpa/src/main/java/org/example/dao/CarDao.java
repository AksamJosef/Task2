package org.example.dao;

import org.example.entity.Car;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addCar(Car car) {
        entityManager.persist(car);
    }
}
