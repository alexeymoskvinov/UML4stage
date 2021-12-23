INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user@mail.com', 'user', 'Name', 'Surname',1);
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'name@gmail.com', 'namesurname', 'Name',
        'Surname', 1);

INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2);

INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Ахмат : Уфа', 'Дата: 26.02.2022 13:00, Стадион: Ахмат-Арена (Грозный)', 3000, 500);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Зенит : Рубин', 'Дата: 26.02.2022 16:00, Стадион: Газпром Арена (Санкт-Петербург)', 10000, 1200);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Краснодар : Локомотив Москва', 'Дата: 26.02.2022 19:00, Стадион: Краснодар (Краснодар)', 7000, 800);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Нижний Новгород : Урал', 'Дата: 27.02.2022 13:00, Нижний Новгород (Нижний Новгород)', 3000, 350);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Ростов : Крылья Советов', 'Дата: 27.02.2022 16:00, Стадион: Ростов Арена (Ростов)', 15000, 1300);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Сочи : Арсенал Тула', 'Дата: 27.02.2022 19:00, Стадион: Фишт (Сочи)', 9000, 600);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Спартак Москва : ЦСКА', 'Дата: 28.02.2022 16:00, Стадион: Открытие Арена (Москва)', 30000, 1500);
INSERT INTO PRODUCT (name, description, quantity, price)
VALUES ('Химки : Динамо Москва', 'Дата: 28.02.2022 19:00, Стадион: Арена Химки (Химки)', 6000, 500);
