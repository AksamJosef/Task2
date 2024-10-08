package com.prime.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Сущность лота
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lot")
public class Lot {

    /**
     * ID сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Наименование лота
     */
    @Column(name = "name")
    private String name;

    /**
     * Город
     */
    @Column(name = "city")
    private String city;

    /**
     * Адрес
     */
    @Column(name = "address")
    private String address;

    /**
     * Площадь. Неотрицательное
     */
    @Min(0)
    @Column(name = "square")
    private Double square;

    /**
     * Этаж
     */
    @Column(name = "floor")
    private Integer floor;

    /**
     * Количество комнат. Минимально допустимое количество - 1
     */
    @Column(name = "room_quantity")
    @Min(1)
    private Integer roomQuantity;
}
