package org.dblesson.dao;

import org.dblesson.entity.Cat;

import java.util.List;

/**
 * DAO - слой доступа к данным
 */
public interface CatDao {
    void createTable();

    void dropTable();

    void add(Cat cat);

    void deleteById(Long id);

    List<Cat> getAll();
}
