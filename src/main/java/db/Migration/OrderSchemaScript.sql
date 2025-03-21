CREATE TYPE status AS ENUM ('CRÉE', 'CONFIRMÉ', 'EN PRÉPARATION', 'TEMRINÉ', 'SERVI')

CREATE TABLE order (
    id_order SERIAL NOT NULL,
    id_dish INTEGER NOT NULL,
)

CREATE TABLE order_status (
    id_order_status SERIAL PRIMARY KEY NOT NULL,
    id_order INTEGER NOT NULL,
    status status NOT NULL,
    datetime TIMESTAMP NOT NULL,
    FOREIGN KEY (id_order) REFERENCES order(id_order)
)


CREATE TABLE dish_order_status (
    id_dish_order_status SERIAL PRIMARY KEY NOT NULL,
    id_dish_orde
)
