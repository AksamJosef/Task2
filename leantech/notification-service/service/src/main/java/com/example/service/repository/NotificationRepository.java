package com.example.service.repository;

import com.example.service.model.Notification;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface NotificationRepository extends R2dbcRepository<Notification, Long> {
    Flux<Notification> findAllByOrderByCreatedAtAsc();
    Mono<Notification> findById(Long notificationId);
}
