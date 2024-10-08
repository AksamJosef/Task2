package com.prime.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность брони
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    /**
     * ID сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * ФИО пользователя
     */
    @Column(name = "client_name")
    private String clientName;

    /**
     * Начало брони
     */
    @Column(name = "reservation_start")
    private LocalDateTime reservationStart;

    /**
     * Конец брони
     */
    @Column(name = "reservation_End")
    private LocalDateTime reservationEnd;

    /**
     * Лот
     */
    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    /**
     * Телефон
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Служебное поле. Активна ли бронь
     */
    @Column(name = "is_active")
    private Boolean isActive = Boolean.TRUE;
}
