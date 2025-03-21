CREATE TYPE status AS ENUM ('CRÉE', 'CONFIRMÉ', 'EN PRÉPARATION', 'TEMRINÉ', 'SERVI');

--la commande du client en general
CREATE TABLE one_order (
    id_order SERIAL PRIMARY KEY NOT NULL,
    datetime TIMESTAMP NOT NULL
);

-- chaque plat compris dans la commande ayant l'id specifique
CREATE TABLE dish_order(
    id_dish_order SERIAL PRIMARY KEY NOT NULL,
    id_order INTEGER NOT NULL,
    id_dish INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    FOREIGN KEY (id_order) REFERENCES one_order(id_order) ON DELETE CASCADE,
    FOREIGN KEY (id_dish) REFERENCES dish(id_dish) ON DELETE CASCADE
);

--status de la commande en generale à une date précise
CREATE TABLE order_status (
    id_order_status SERIAL PRIMARY KEY NOT NULL,
    id_order INTEGER NOT NULL,
    status status NOT NULL,
    datetime TIMESTAMP NOT NULL,
    FOREIGN KEY (id_order) REFERENCES one_order(id_order) ON DELETE CASCADE
);

-- status de chaque plat commandé à une date précise
CREATE TABLE dish_order_status (
    id_dish_order_status SERIAL PRIMARY KEY NOT NULL,
    id_dish_order INTEGER NOT NULL,
    status status NOT NULL,
    datetime TIMESTAMP NOT NULL,
    FOREIGN KEY (id_dish_order) REFERENCES dish_order(id_dish_order) ON DELETE CASCADE
);
