INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO CLIENTE(id, name) VALUES (1, 'Daniel');
INSERT INTO CLIENTE(id, name) VALUES (2, 'Laura');
INSERT INTO CLIENTE(id, name) VALUES (3, 'Carlos');

INSERT INTO PRESTAMO(id, game_id, cliente_id, date_p, date_d) VALUES (1, 1, 1, '2022-01-11', '2022-01-20');
INSERT INTO PRESTAMO(id, game_id, cliente_id, date_p, date_d) VALUES (2, 2, 2, '2022-02-11', '2022-02-20');
INSERT INTO PRESTAMO(id, game_id, cliente_id, date_p, date_d) VALUES (3, 3, 2, '2022-03-11', '2022-03-20');
INSERT INTO PRESTAMO(id, game_id, cliente_id, date_p, date_d) VALUES (4, 4, 3, '2022-07-11', '2022-08-20');
INSERT INTO PRESTAMO(id, game_id, cliente_id, date_p, date_d) VALUES (5, 5, 3, '2022-10-11', '2022-10-20');
INSERT INTO PRESTAMO(id, game_id, cliente_id, date_p, date_d) VALUES (6, 5, 3, '2022-11-11', '2022-11-12');
