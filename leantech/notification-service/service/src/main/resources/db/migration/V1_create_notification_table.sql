CREATE TABLE notifications
(
    id                        serial PRIMARY KEY,
    created_at                TIMESTAMP DEFAULT now() NOT NULL,
    modified_at               TIMESTAMP,
    expiration_date           TIMESTAMP               NOT NULL,
    message                   TEXT                    NOT NULL,
    error                     TEXT,
    user_uid                  VARCHAR(36),
    notification_status       VARCHAR(32),
    message_type              VARCHAR(32),
    trigger_code              VARCHAR(128),
    object_type               VARCHAR(255),
    object_id                 VARCHAR(36),
    subject                   VARCHAR(128),
    created_by                VARCHAR(255),
    has_confirm_otp           BOOLEAN   DEFAULT false,
    suggest_to_add_to_trusted BOOLEAN   DEFAULT true,
    CONSTRAINT notification_user_uid_status_type_trigger_code_idx UNIQUE (object_id, notification_status, message_type, trigger_code)
);
