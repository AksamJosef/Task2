package com.example.service.listener;

import com.example.api.dto.request.NotificationRequest;
import com.example.api.service.INotificationService;
import com.example.service.model.Notification;
import com.example.service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationKafkaListener implements INotificationService {

    private final NotificationService notificationService;

    @KafkaListener(topics = "notification-topic", groupId = "notification_group")
    public void receive(NotificationRequest request) {
        notificationService.save(new Notification()).subscribe();
    }
}
