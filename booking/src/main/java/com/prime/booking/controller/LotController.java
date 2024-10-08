package com.prime.booking.controller;

import com.prime.booking.dto.FilterSpecification;
import com.prime.booking.dto.LotResponse;
import com.prime.booking.service.LotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lots")
public class LotController {

    private final LotService lotService;

    @PostMapping
    public ResponseEntity<List<LotResponse>> findFilteredLots(FilterSpecification filterSpecification) {
        return ResponseEntity.ok(lotService.getAllByCriteria(filterSpecification));
    }
}
