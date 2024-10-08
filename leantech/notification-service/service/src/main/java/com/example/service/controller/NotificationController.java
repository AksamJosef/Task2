package com.example.service.controller;

import com.example.api.dto.request.NotificationRequest;
import com.example.api.dto.request.UpdateNotificationRequest;
import com.example.service.model.Notification;
import com.example.service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @GetMapping
    public Flux<Notification> getAllNotifications() {
        return service.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Notification>> getNotificationById(@PathVariable Long id) {
        return service.getNotificationById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Notification> createNotification(@RequestBody NotificationRequest notification) {
        return service.save(notification);
    }

    @PutMapping("/status")
    public Mono<Notification> updateNotificationStatus(@RequestBody UpdateNotificationRequest updateNotificationRequest) {
        return service.updateNotificationStatus(updateNotificationRequest.getId(), updateNotificationRequest.getNotificationStatus());
    }
}
