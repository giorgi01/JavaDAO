CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    price FLOAT NOT NULL,
    discount_percent FLOAT DEFAULT 0.0
);