-- DROP SCHEMA IF EXISTS "order" CASCADE;

-- CREATE SCHEMA "order";

-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE products (
    id uuid NOT NULL,
    name TEXT NOT NULL,
    price numeric(10,2) NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id)
);
