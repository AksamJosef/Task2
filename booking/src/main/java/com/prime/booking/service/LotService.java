package com.prime.booking.service;

import com.prime.booking.dto.FilterSpecification;
import com.prime.booking.dto.LotResponse;
import com.prime.booking.mapstruct.LotMapper;
import com.prime.booking.model.Lot;
import com.prime.booking.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Сервис лота
 */
@Service
@RequiredArgsConstructor
public class LotService {

    private final LotRepository repository;

    private final LotMapper mapper;

    /**
     * Получить все лоты по заданному критерию
     *
     * @param filter фильтр
     * @return список найденных лотов по указанному фильтру
     * @implNote первичный поиск происходит по городу, заданному в фильтре. После этого - по остальным полям.
     */
    public List<LotResponse> getAllByCriteria(FilterSpecification filter) {
        Predicate<Lot> namePredicate = lot -> Objects.isNull(filter.getName())
                || filter.getName().toLowerCase().contains(lot.getName().toLowerCase());

        Predicate<Lot> addressPredicate = lot -> Objects.isNull(filter.getAddress())
                || filter.getAddress().toLowerCase().contains(lot.getAddress().toLowerCase());

        Predicate<Lot> minFloorPredicate = lot -> Objects.isNull(filter.getMinFloor())
                || filter.getMinFloor() <= lot.getFloor();

        Predicate<Lot> maxFloorPredicate = lot -> Objects.isNull(filter.getMaxFloor())
                || filter.getMaxFloor() >= lot.getFloor();

        Predicate<Lot> minSquarePredicate = lot -> Objects.isNull(filter.getMinSquare())
                || filter.getMinSquare() <= lot.getSquare();

        Predicate<Lot> maxSquarePredicate = lot -> Objects.isNull(filter.getMaxSquare())
                || filter.getMaxSquare() >= lot.getSquare();

        return repository.findAllByCity(filter.getCity()).stream()
                .filter(namePredicate)
                .filter(addressPredicate)
                .filter(minFloorPredicate.and(maxFloorPredicate))
                .filter(minSquarePredicate.and(maxSquarePredicate))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Получить лот по ID
     *
     * @param lotId ID лота
     * @return найденный лот
     * @throws java.util.NoSuchElementException если не найдено лота по указанному ID
     */
    public Lot getById(UUID lotId) {
        return repository.findById(lotId).orElseThrow();
    }
}
