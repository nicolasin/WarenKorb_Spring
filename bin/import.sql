
INSERT INTO RABATT (id,name, type, wert)values(1,'RabatJubilados', 'ABS', 15);
INSERT INTO RABATT (id,name, type, wert)values(2,'RabatJOVEN', 'REL', 20);
INSERT INTO RABATT (id,name, type, wert)values(3,'RabatTrabajadores', 'ABS', 10);
INSERT INTO RABATT (id,name, type, wert)values(4,'20 PORCENT', 'REL', 20);
INSERT INTO RABATT (id,name, type, wert)values(5,'15 PORCENT', 'REL', 15);
INSERT INTO RABATT (id,name, type, wert)values(6,'10 PORCENT', 'REL', 10);
INSERT INTO RABATT (id,name, type, wert)values(7,'20 EUROS', 'ABS', 20);
INSERT INTO RABATT (id,name, type, wert)values(8,'15 EUROS', 'ABS', 15);
INSERT INTO RABATT (id,name, type, wert)values(9,'10 EUROS', 'ABS', 10);
INSERT INTO RABATT (id,name, type, wert)values(10,'30 EUROS', 'ABS', 30);
INSERT INTO RABATT (id,name, type, wert)values(11,'40 EUROS', 'ABS', 40);
INSERT INTO RABATT (id,name, type, wert)values(12,'40 PORCENT', 'REL', 40);
INSERT INTO RABATT (id,name, type, wert)values(13,'30 PORCENT', 'REL', 30);

INSERT INTO KUNDEGRUPPE (name, Rabatt_ID) values ('Jubilados', 1);
INSERT INTO KUNDEGRUPPE (name, Rabatt_ID) values ('Joven', 2);
INSERT INTO KUNDEGRUPPE (name, Rabatt_ID) values ('Trabajadores', 3);
INSERT INTO KUNDEGRUPPE (name, Rabatt_ID) values ('OTROMAS', 1);


INSERT INTO KUNDE (name, nick, password, GRUPPE_ID, Rabatt_ID, email) values ('Nicolas','nico','1234567', 1, 7,  'nicomartos@msn.com');
INSERT INTO KUNDE (name, nick, password, GRUPPE_ID, Rabatt_ID, email) values ('Ana','ana','1234567', 2 ,8, 'nicomarto13s@msn.com');
INSERT INTO KUNDE (name, nick, password, GRUPPE_ID, Rabatt_ID, email) values ('Javi','javi','1234567', 3, 9, 'nicomar132tos@msn.com');
INSERT INTO KUNDE (name, nick, password, GRUPPE_ID, email) values ('JaviAdvani','advi','1234567', 3, 'nicomarto1s@msn.com');
INSERT INTO KUNDE (name, nick, password, email) values ('Juan','juan','1234567','nicomartos7@msn.com');


INSERT INTO authorities (kunde_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO authorities (kunde_id, authority) VALUES (1,'ROLE_ADMIN');
INSERT INTO authorities (kunde_id, authority) VALUES (2,'ROLE_USER');
INSERT INTO authorities (kunde_id, authority) VALUES (3,'ROLE_USER');
INSERT INTO authorities (kunde_id, authority) VALUES (4,'ROLE_USER');
INSERT INTO authorities (kunde_id, authority) VALUES (5,'ROLE_USER');




INSERT INTO PRODUKT (name, preis, Rabatt_ID) values ('Camiseta Spain', 65, 6);
INSERT INTO PRODUKT (name, preis, Rabatt_ID) values ('Camiseta Alemania', 65, 6);
INSERT INTO PRODUKT (name, preis, Rabatt_ID) values ('Zapatillas Nike', 40, 5);
INSERT INTO PRODUKT (name, preis, Rabatt_ID) values ('Botas de Agua', 15, 4);
INSERT INTO PRODUKT (name, preis) values ('Cantimplora', 10);


INSERT INTO PRODUKTGRUPPE (name, Rabatt_ID) values('ZAPATO', 4);
INSERT INTO PRODUKTGRUPPE (name, Rabatt_ID) values('ROPA', 5);
INSERT INTO PRODUKTGRUPPE (name, Rabatt_ID) values('DEPORTE', 6);
INSERT INTO PRODUKTGRUPPE (name) values('AVENTURA');

INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (1,2);
INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (1,3);
INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (2,2);
INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (2,3);
INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (3,1);
INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (3,3);
INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (4,1);
INSERT INTO PRODUKT_PRODUKTGRUPPE (PRODUKT_ID, GRUPPE_ID) VALUES (4,4);



INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(1, 1);
INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(1, 1);
INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(1, 2);
INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(1, 3);
INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(2, 1);
INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(2, 3);
INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(3, 2);
INSERT INTO WARENKORB(KUNDE_ID, PRODUKT_ID)values(4, 5);
