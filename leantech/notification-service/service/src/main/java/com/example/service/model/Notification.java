package com.example.service.model;

import com.example.api.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "notifications")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    /**
     * ID сущности
     */
    @Id
    private Long id;

    /**
     * Дата и время создания
     */
    @CreatedDate
    private LocalDateTime createdAt;

    /**
     * Дата и время изменения
     */
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    /**
     * Время истечения нотификации
     */
    private LocalDateTime expirationDate;

    /**
     * Сообщение
     */
    private String message;

    /**
     * Ошибка
     */
    private String error;

    /**
     * ID Пользователя
     */
    private String userUid;

    /**
     * Статус уведомления
     */
    private NotificationStatus notificationStatus;

    /**
     * Тип сообщения
     */
    private String messageType;

    /**
     * Код триггера
     */
    private String triggerCode;

    /**
     * Тип объекта
     */
    private String objectType;

    /**
     * ID Объекта
     */
    private String objectId;

    /**
     * Предмет
     */
    private String subject;

    /**
     * Автор
     */
    private String createdBy;

    /**
     * Имеет подтверждение ОТП
     */
    @Builder.Default
    private boolean hasConfirmOtp = false;

    /**
     * todo описать
     */
    @Builder.Default
    private boolean suggestToAddToTrusted = true;

}
