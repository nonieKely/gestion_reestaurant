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
