INSERT INTO KUNDE_GROUPE (name) values ('Jubilados');
INSERT INTO KUNDE_GROUPE (name) values ('Joven');
INSERT INTO KUNDE_GROUPE (name) values ('Trabajadores');

INSERT INTO KUNDE (name, nick, password, groupes_id) values ('Nicolas','nico','1234567', 1);
INSERT INTO KUNDE (name, nick, password, groupes_id) values ('Ana','ana','1234567', 2);
INSERT INTO KUNDE (name, nick, password, groupes_id) values ('Javi','javi','1234567', 3);
INSERT INTO KUNDE (name, nick, password, groupes_id) values ('JaviAdvani','advi','1234567', 3);
INSERT INTO KUNDE (name, nick, password) values ('Juan','juan','1234567');

INSERT INTO PRODUKT (name, precio) values ('Camiseta Spain', 65);
INSERT INTO PRODUKT (name, precio) values ('Camiseta Alemania', 65);
INSERT INTO PRODUKT (name, precio) values ('Zapatillas Nike', 40);
INSERT INTO PRODUKT (name, precio) values ('Botas de Agua', 15);
INSERT INTO PRODUKT (name, precio) values ('Cantimplora', 10);


INSERT INTO PRODUKT_GROUPE(name) values('ZAPATO');
INSERT INTO PRODUKT_GROUPE(name) values('ROPA');
INSERT INTO PRODUKT_GROUPE(name) values('DEPORTE');
INSERT INTO PRODUKT_GROUPE(name) values('AVENTURA');

INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (1,2);
INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (1,3);
INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (2,2);
INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (2,3);
INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (3,1);
INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (3,3);
INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (4,1);
INSERT INTO PRODUKT_PRODUKT_GROUPE(PRODUKTE_ID, GROUPE_ID) VALUES (4,4);


INSERT INTO RABAT (id,name, type, wert)values(1,'RabatJubilados', 'ABS', 15);
INSERT INTO RABAT (id,name, type, wert)values(2,'RabatJOVEN', 'REL', 20);
INSERT INTO RABAT (id,name, type, wert)values(3,'RabatTrabajadores', 'ABS', 10);
INSERT INTO RABAT (id,name, type, wert)values(4,'20 PORCENT', 'REL', 20);
INSERT INTO RABAT (id,name, type, wert)values(5,'15 PORCENT', 'REL', 15);
INSERT INTO RABAT (id,name, type, wert)values(6,'10 PORCENT', 'REL', 10);
INSERT INTO RABAT (id,name, type, wert)values(7,'20 EUROS', 'ABS', 20);
INSERT INTO RABAT (id,name, type, wert)values(8,'15 EUROS', 'ABS', 15);
INSERT INTO RABAT (id,name, type, wert)values(9,'10 EUROS', 'ABS', 10);
INSERT INTO RABAT (id,name, type, wert)values(10,'30 EUROS', 'ABS', 30);
INSERT INTO RABAT (id,name, type, wert)values(11,'40 EUROS', 'ABS', 40);
INSERT INTO RABAT (id,name, type, wert)values(12,'40 PORCENT', 'REL', 40);
INSERT INTO RABAT (id,name, type, wert)values(13,'30 PORCENT', 'REL', 30);


