package com.prime.booking.repository;

import com.prime.booking.model.Lot;
import com.prime.booking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * JPA-Репозиторий для работы с сущностью {@link Reservation}
 */
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    @Query("FROM Reservation WHERE lot = :lot AND isActive = TRUE")
    List<Reservation> findActive(Lot lot);
}
