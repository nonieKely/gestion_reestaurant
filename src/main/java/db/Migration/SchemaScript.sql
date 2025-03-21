CREATE TABLE dish (
    id_dish SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    unit_price INTEGER NOT NULL
);

CREATE TYPE Unit AS ENUM ('G', 'L', 'U');

CREATE TABLE ingredient (
    id_ingredient SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    unit_price NUMERIC(10,3) NOT NULL,
    unit Unit NOT NULL,
    update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE dish_ingredient (
    id_dish INTEGER NOT NULL,
    id_ingredient INTEGER NOT NULL,
    required_quantity NUMERIC(10,3) NOT NULL,
    unit Unit NOT NULL,
    PRIMARY KEY (id_dish, id_ingredient),
    FOREIGN KEY (id_dish) REFERENCES dish(id_dish) ON DELETE CASCADE,
    FOREIGN KEY (id_ingredient) REFERENCES ingredient(id_ingredient) ON DELETE CASCADE
);

CREATE TABLE ingredientDate (
    id_history SERIAL NOT NULL,
    id_ingredient INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(10,3) NOT NULL,
    unit Unit NOT NULL,
    date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_ingredient) REFERENCES ingredient(id_ingredient)
);


CREATE TYPE Movement AS ENUM ('entrée', 'sortie');

CREATE TABLE stock (
    id_movement SERIAL PRIMARY KEY,
    id_ingredient INTEGER NOT NULL,
    movement Movement NOT NULL,
    used_quantity NUMERIC(10,3) NOT NULL,
    unit Unit NOT NULL,
    date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_ingredient) REFERENCES ingredient(id_ingredient)
);

CREATE TABLE available_stock(
    id_available_stock SERIAL PRIMARY KEY,
    id_ingredient INTEGER NOT NULL,
    available_quantity NUMERIC(10,3) NOT NULL,
    date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_ingredient) REFERENCES ingredient(id_ingredient)
);

