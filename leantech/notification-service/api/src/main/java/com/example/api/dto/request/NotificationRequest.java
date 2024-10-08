package com.example.api.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationRequest {
    
    /**
     * Дата и время создания
     */
    private final LocalDateTime createdAt;

    /**
     * Дата и время изменения
     */
    private final LocalDateTime modifiedAt;

    /**
     * Время истечения нотификации
     */
    private final LocalDateTime expirationDate;

    /**
     * Сообщение
     */
    private final String message;

    /**
     * Ошибка
     */
    private final String error;

    /**
     * ID Пользователя
     */
    private final String userUid;

    /**
     * Статус уведомления
     */
    private final String notificationStatus;

    /**
     * Тип сообщения
     */
    private final String messageType;

    /**
     * Код триггера
     */
    private final String triggerCode;

    /**
     * Тип объекта
     */
    private final String objectType;

    /**
     * ID Объекта
     */
    private final String objectId;

    /**
     * Предмет
     */
    private final String subject;

    /**
     * Автор
     */
    private final String createdBy;

    /**
     * Имеет подтверждение ОТП
     */
    @Builder.Default
    private final boolean hasConfirmOtp = false;

    /**
     * todo описать
     */
    @Builder.Default
    private final boolean suggestToAddToTrusted = true;
}
