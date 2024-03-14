package org.dblesson.service;

import org.dblesson.entity.Cat;

import java.util.List;

/**
 * Service слой - это слой для бизнес-логики
 */
public interface CatService {

    void createTable();

    void dropTable();

    void add(Cat cat);

    void deleteById(Long id);

    List<Cat> getAll();
}
