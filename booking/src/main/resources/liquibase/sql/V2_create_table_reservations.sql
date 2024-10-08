CREATE TABLE IF NOT EXISTS reservations
(
    id                 UUID PRIMARY KEY,
    client_name        VARCHAR,
    reservation_start  TIMESTAMP,
    reservation_end    TIMESTAMP,
    lot_id             UUID REFERENCES lots(id),
    phone              VARCHAR,
    is_active          BOOLEAN
);