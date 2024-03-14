package org.jdbcexample.dao;

import org.jdbcexample.model.Cat;

import java.util.List;

public interface CarDao {

    void createTable();

    void dropTable();

    void saveCar(Cat car);

    void removeCarById(Long id);

    List<Cat> getAllCars();
}
