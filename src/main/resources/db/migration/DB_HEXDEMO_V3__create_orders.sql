-- DROP SCHEMA IF EXISTS "order" CASCADE;

-- CREATE SCHEMA "order";

-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS orders CASCADE;

CREATE TABLE orders (
    id uuid NOT NULL,
    user_id UUID NOT NULL,
    total numeric(10,2) NOT NULL,
    CONSTRAINT orders_pk  PRIMARY KEY (id)
);
