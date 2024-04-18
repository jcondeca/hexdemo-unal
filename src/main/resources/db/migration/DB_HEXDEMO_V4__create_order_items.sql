-- DROP SCHEMA IF EXISTS "order" CASCADE;

-- CREATE SCHEMA "order";

-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS order_items CASCADE;

CREATE TABLE order_items (
    id BIGINT NOT NULL,
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    quantity integer NOT NULL,
    subtotal numeric(10,2) NOT NULL,
    CONSTRAINT order_items_pk  PRIMARY KEY (id)
);
