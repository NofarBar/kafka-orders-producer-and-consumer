CREATE DATABASE IF NOT EXISTS orders;

USE costumer_orders;

CREATE TABLE customer_orders(
    id int NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    shopper_email VARCHAR(255) NOT NULL,
    shopper_first_name VARCHAR(255) NOT NULL,
    shopper_last_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE product(
    id int NOT NULL AUTO_INCREMENT,
    external_product_id DATE NOT NULL,
    store_id int NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price double NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE purchased_products(
    id int NOT NULL AUTO_INCREMENT,
    order_id int NOT NULL,
    product_id int NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(order_id),
    FOREIGN KEY(product_id)
);