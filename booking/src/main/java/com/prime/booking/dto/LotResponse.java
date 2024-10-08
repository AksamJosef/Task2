package com.prime.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * ДТО ответа для сущности лота
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LotResponse {

    /**
     * ID сущности
     */
    private UUID id;

    /**
     * Наименование лота
     */
    private String name;

    /**
     * Город
     */
    private String city;

    /**
     * Адрес
     */
    private String address;

    /**
     * Площадь
     */
    private Double square;

    /**
     * Этаж
     */
    private Integer floor;

    /**
     * Количество комнат
     */
    private Integer roomQuantity;
}
