package com.prime.booking.dto;

import com.prime.booking.model.Lot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * ДТО запроса для сущности брони
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationRequest {

    /**
     * ФИО пользователя
     */
    private String clientName;

    /**
     * Начало брони
     */
    private LocalDateTime reservationStart;

    /**
     * Конец брони
     */
    private LocalDateTime reservationEnd;

    /**
     * ID Лота
     */
    private UUID lotId;

    /**
     * Телефон
     */
    private String phone;
}
