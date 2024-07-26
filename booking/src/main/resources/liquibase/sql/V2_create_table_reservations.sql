CREATE TABLE IF NOT EXISTS users
(
    id                 UUID PRIMARY KEY,
    client_name        VARCHAR,
    lot_id             UUID REFERENCES lots(id),
    phone              VARCHAR
);