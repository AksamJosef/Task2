package com.example.api.service;

import com.example.api.dto.request.NotificationRequest;

public interface INotificationService {

    void receive(NotificationRequest request);
}
