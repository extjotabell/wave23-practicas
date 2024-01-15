DROP DATABASE IF EXISTS showroom;
CREATE DATABASE showroom;
USE showroom;

CREATE TABLE sizes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE clothes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255),
    name VARCHAR(255),
    brand VARCHAR(255),
    color VARCHAR(255),
    stock INT,
    selling_price DOUBLE,
    size_id BIGINT NOT NULL,
    FOREIGN KEY (size_id) REFERENCES sizes(id)
);

INSERT INTO sizes (id, name) VALUES
  (1, 'Small'),
  (2, 'Medium'),
  (3, 'Large'),
  (4, 'Extra Large');