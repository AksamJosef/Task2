package com.prime.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterSpecification {

    /**
     * Имя
     */
    private String name;

    /**
     * Минимальный этаж
     */
    private Integer minFloor;

    /**
     * Максимальный этаж
     */
    private Integer maxFloor;

    /**
     * Адрес
     */
    private String address;

    /**
     * Минимальная площадь
     */
    private Double minSquare;

    /**
     * Максимальная площадь
     */
    private Double maxSquare;

    /**
     * Минимальное количество комнат
     */
    private Integer minRoomQuantity;

    /**
     * Максимальное количество комнат
     */
    private Integer maxRoomQuantity;

    /**
     * Город
     */
    @NotNull
    private String city;
}
