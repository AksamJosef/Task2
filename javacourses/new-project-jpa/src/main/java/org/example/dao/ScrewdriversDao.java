package org.example.dao;

import org.example.entity.Screwdriver;
import org.example.enums.Country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScrewdriversDao {

    void add(Screwdriver screwdriver);

    void delete(Screwdriver screwdriver);

    List<Screwdriver> findAll();

    List<Screwdriver> findByCountry(Country country);

    Optional<Screwdriver> findById(UUID id);

    void update(Screwdriver screwdriver);
}
