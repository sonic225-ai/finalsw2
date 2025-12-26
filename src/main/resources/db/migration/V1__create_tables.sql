CREATE TABLE restaurants (
                             id BIGSERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             address VARCHAR(255)
);

CREATE TABLE dishes (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        price DOUBLE PRECISION NOT NULL,
                        restaurant_id BIGINT,
                        CONSTRAINT fk_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,
                        customer_name VARCHAR(255) NOT NULL,
                        total_price DOUBLE PRECISION
);

CREATE TABLE order_items (
                             order_id BIGINT NOT NULL,
                             dish_id BIGINT NOT NULL,
                             PRIMARY KEY (order_id, dish_id),
                             CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(id),
                             CONSTRAINT fk_dish FOREIGN KEY (dish_id) REFERENCES dishes(id)
);