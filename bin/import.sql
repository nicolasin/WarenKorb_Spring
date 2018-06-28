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
