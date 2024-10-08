package com.example.service.service;

import com.example.api.dto.request.UpdateNotificationRequest;
import com.example.api.enums.NotificationStatus;
import com.example.service.model.Notification;
import com.example.service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

    @Service
    @Slf4j
    @RequiredArgsConstructor
    public class NotificationService {

        private final NotificationRepository repository;

        public Mono<Notification> save(Notification notification) {
            return repository.save(notification);
        }

        public Flux<Notification> getAllNotifications() {
            return repository.findAllByOrderByCreatedAtAsc();
        }

        public Mono<Notification> getNotificationById(Long id) {
            return repository.findById(id);
        }

        public Mono<Notification> updateNotificationStatus(Long id, NotificationStatus status) {
            return this.getNotificationById(id)
                .flatMap(notification -> {
                    notification.setNotificationStatus(status);
                    return this.save(notification);
                });
        }
    }
