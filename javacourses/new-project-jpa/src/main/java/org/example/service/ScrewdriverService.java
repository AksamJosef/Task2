package org.example.service;

import org.example.entity.Screwdriver;
import org.example.enums.Country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScrewdriverService {

    void add(Screwdriver screwdriver);

    void delete(UUID id);

    List<Screwdriver> findAll();

    Long findQuantityByCountry(Country country);

    Optional<Screwdriver> findById(UUID id);

    void update(UUID id);
}
