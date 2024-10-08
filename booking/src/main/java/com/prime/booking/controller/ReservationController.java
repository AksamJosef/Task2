package com.prime.booking.controller;

import com.prime.booking.dto.ReservationRequest;
import com.prime.booking.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reserve")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public void reserve(ReservationRequest request) {
        reservationService.reserve(request);
    }
}
