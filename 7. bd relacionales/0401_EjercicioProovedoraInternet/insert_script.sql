USE empresa_internet;

INSERT INTO cliente VALUES ("0000000001", "Juan", "Pérez", "19991010", "Madagascar", "Madagascar");
INSERT INTO cliente VALUES ("0000000002", "Pedro", "Marquez", "20001010", "Cairo", "Cairo");
INSERT INTO cliente VALUES ("0000000003", "María", "Diaz", "20011010", "Madera", "Estambúl");
INSERT INTO cliente VALUES ("0000000004", "Alejandra", "Sánchez", "19991110", "Playa", "Monterrey");
INSERT INTO cliente VALUES ("0000000005", "Francisco", "Arroyo", "19991210", "Popular", "Villahermosa");
INSERT INTO cliente VALUES ("0000000006", "Esteban", "Alvarado", "19991013", "Específica", "Colorado");
INSERT INTO cliente VALUES ("0000000007", "Juana", "Nupecino", "19991014", "Aprendíz", "Primavera");
INSERT INTO cliente VALUES ("0000000008", "Antonieta", "Oca", "19981015", "Cuarta", "Venecia");
INSERT INTO cliente VALUES ("0000000009", "Elvia", "Sánchez", "19971010", "Oso", "Tokyo");
INSERT INTO cliente VALUES ("0000000010", "Jorge", "Pérez", "19961010", "Carta", "Veracruz");

SELECT * FROM cliente;

INSERT INTO plan_internet VALUES (1, 50, 200, 0, "0000000001");
INSERT INTO plan_internet VALUES (2, 20, 100, 0, "0000000001");
INSERT INTO plan_internet VALUES (3, 200, 300, 0, "0000000002");
INSERT INTO plan_internet VALUES (4, 75, 225, 0, "0000000003");
INSERT INTO plan_internet VALUES (5, 10, 50, 0, "0000000004");

SELECT * from plan_internet;


