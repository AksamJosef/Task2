package com.prime.booking.repository;

import com.prime.booking.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * JPA-Репозиторий для работы с сущностью {@link Lot}
 */
@Repository
public interface LotRepository extends JpaRepository<Lot, UUID> {

    List<Lot> findAllByCity(String city);
}
