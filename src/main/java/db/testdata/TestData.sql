INSERT INTO Ingredient (name, unit_price, unit, update_datetime)
VALUES
    ('Saucisse', 20, 'G', CURRENT_TIMESTAMP),
    ('Huile', 10000, 'L', CURRENT_TIMESTAMP),
    ('Oeuf', 1000, 'U', CURRENT_TIMESTAMP),
    ('Pain', 1000, 'U', CURRENT_TIMESTAMP);

INSERT INTO dish (name, unit_price)
VALUES ('Hot Dog', 15000);

INSERT INTO dish_ingredient (id_dish, id_ingredient, required_quantity, unit)
VALUES (1, 1, 100,'G'),
(1,2,0.15,'L'),
(1,3,1,'U'),
(1,4,1,'U');

INSERT INTO ingredientdate (id_ingredient, name, price, unit, date_time)
SELECT id_ingredient, name, unit_price, unit, update_datetime FROM ingredient;


INSERT INTO ingredientdate (id_ingredient, name, price, unit, date_time)
VALUES
    (1, 'Saucisse', 18, 'G', '2025-01-17 09:00:00'),
    (3, 'Oeuf', 800, 'U', '2025-02-06 12:00:00');

INSERT INTO stock (id_ingredient, movement, used_quantity, unit, date_time)
VALUES
    (3, 'entrée', 100, 'U', '2025-02-01 08:00:00'),
    (4, 'entrée', 50, 'U', '2025-02-01 08:00:00'),
    (1, 'entrée', 10000, 'G', '2025-02-01 08:00:00'),
    (2, 'entrée', 20, 'L', '2025-02-01 08:00:00');


INSERT INTO stock (id_ingredient, movement, used_quantity, unit, date_time)
VALUES
(3, 'sortie', 10, 'U', '2025-02-02 10:00:00'),
(3, 'sortie', 10, 'U', '2025-02-03 15:00:00'),
(4, 'sortie', 20, 'U', '2025-02-05 16:00:00');

INSERT INTO ingredient (name, unit_price, unit)
VALUES
('Sel', 2.5 , 'G'),
('Riz', 3.5 , 'G');


INSERT INTO one_order (datetime)
VALUES ('2025-02-06 14:00:00');

INSERT INTO dish_order (id_order, id_dish, quantity)
VALUES (1, 1, 2);

INSERT INTO order_status (id_order, status, datetime)
VALUES (1, 'CONFIRMÉ', '2025-02-06 14:05:00');

INSERT INTO dish_order_status (id_dish_order, status, datetime)
VALUES
(1, 'EN PRÉPARATION', '2025-02-06 14:10:00'),
(1, 'SERVI', '2025-02-06 14:30:00');
