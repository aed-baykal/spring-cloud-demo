CREATE TABLE IF NOT EXISTS categories (
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255),
    description TEXT,
    image_url   VARCHAR(255),
    parent_id   BIGINT REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS  products (
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    image_url   VARCHAR(255),
    price       FLOAT NOT NULL,
    category_id BIGINT REFERENCES categories (id)
);


INSERT INTO categories (title)
VALUES ('Не заполнено'),
       ('Электроника'),
       ('Бытовая техника');

INSERT INTO products(title, price, category_id)
VALUES ('Ноутбук Lenovo', 44990, 2),
       ('Телефон iPhone', 66490, 2),
       ('Стиральная машинка LG', 32290, 3),
       ('Телевизор Samsung', 32290, 2);
