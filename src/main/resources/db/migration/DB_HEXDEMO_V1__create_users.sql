-- DROP SCHEMA IF EXISTS "order" CASCADE;

-- CREATE SCHEMA "order";

-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users
(
    id uuid NOT NULL,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    max_order_price numeric(10,2) NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);
