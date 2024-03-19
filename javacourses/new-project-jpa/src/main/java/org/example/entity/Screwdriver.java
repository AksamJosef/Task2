package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Characteristic;
import org.example.enums.Country;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "screwdrivers")
public class Screwdriver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String model;

    @Enumerated(EnumType.STRING)
    private Country country;

    private Integer rpm;

    @Enumerated(EnumType.ORDINAL)
    private Characteristic characteristic;

    @OneToOne(cascade = {CascadeType.ALL})
    private Motor motor;
}