package com.example.api.dto.request;

import com.example.api.enums.NotificationStatus;
import lombok.Getter;

@Getter
public class UpdateNotificationRequest {

    private Long id;

    private NotificationStatus notificationStatus;
}
