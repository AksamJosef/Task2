CREATE TABLE IF NOT EXISTS lots
(
    id UUID            PRIMARY KEY,
    name               VARCHAR,
    city               VARCHAR,
    address            VARCHAR,
    square             NUMERIC(3, 2),
    floor              INT,
    roomQuantity       INT
);