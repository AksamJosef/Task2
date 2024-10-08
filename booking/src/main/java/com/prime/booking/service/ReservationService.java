package com.prime.booking.service;

import com.prime.booking.dto.ReservationRequest;
import com.prime.booking.exceptions.ReservationException;
import com.prime.booking.mapstruct.ReservationMapper;
import com.prime.booking.model.Lot;
import com.prime.booking.model.Reservation;
import com.prime.booking.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Сервис для работы с бронированием
 */
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    private final ReservationMapper mapper;

    private final LotService lotService;

    /**
     * Забронировать жилье
     *
     * @param request ДТО запроса
     * @throws ReservationException если невозможно забронировать жилье
     */
    public void reserve(ReservationRequest request) {
        Lot lot = lotService.getById(request.getLotId());

        List<Reservation> reservations = repository.findActive(lot);

        checkReservationAvailability(reservations, request);

        Reservation entity = mapper.toEntity(request);
        entity.setLot(lot);

        repository.save(entity);
    }

    private void checkReservationAvailability(List<Reservation> reservations, ReservationRequest request) {
        if (CollectionUtils.isEmpty(reservations)) {
            return;
        }

        boolean available = reservations.stream()
                .noneMatch(reservation -> reservation.getReservationStart().isBefore(request.getReservationStart())
                        && reservation.getReservationEnd().isAfter(request.getReservationEnd()));

        if (BooleanUtils.isFalse(available)) {
            throw new ReservationException("Невозможно забронировать лот на данное время. Он уже занят");
        }
    }
}
