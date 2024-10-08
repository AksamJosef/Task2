package com.prime.booking.mapstruct;

import com.prime.booking.dto.LotResponse;
import com.prime.booking.dto.ReservationRequest;
import com.prime.booking.model.Lot;
import com.prime.booking.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ReservationMapper {

    Reservation toEntity(ReservationRequest request);
}
