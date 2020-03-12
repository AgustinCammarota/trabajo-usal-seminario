INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (1, 'agustin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (2, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (3, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (4, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (5, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (6, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (7, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (8, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (9, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (10, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (11, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (12, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (13, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (14, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (15, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (16, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (17, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (18, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id, nombre, apellido, email, create_at, foto) VALUES (19, 'martin', 'cammarota', 'agustin@hotmail.com', '2017-08-28', '');

INSERT INTO productos (nombre, precio, create_at) VALUES ('Pantalla LCD', 25587, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Tostadora', 35587, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Computadora', 45587, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Heladera', 55587, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Licuadora', 65587, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Parrilla', 2558, NOW());

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipo electricos', null, 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES  (1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES  (2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES  (1, 1, 5);

INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$LEekiryxXpN2jjGsmTKzHewCVTQD6PBucsIBxeSEwJsYhOJoP7.Li', 1);
INSERT INTO users (username, password, enabled) VALUES ('agustin', '$2a$10$8RnaUHoTjsdP/cyEAfDPPuWMeki7RYNuisVzzVnwB90VNqfQxicuW', 1);

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');
