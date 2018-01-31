DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS ingredient_to_recipe;
DROP TABLE IF EXISTS catalog_to_recipe;
DROP TABLE IF EXISTS recipes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS catalogs;



CREATE TABLE users
(
  id        SERIAL PRIMARY KEY,
  name     VARCHAR                 NOT NULL,
  email    VARCHAR                 NOT NULL,
  password VARCHAR                 NOT NULL,
  enabled  BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE user_roles
(
  user_id  SERIAL PRIMARY KEY,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE recipes
(
  id            SERIAL PRIMARY KEY,
  name          VARCHAR NOT NULL,
  description   TEXT    NOT NULL,
  cookAlgorithm VARCHAR NOT NULL,
  user_id       INTEGER NOT NULL,
  rating        INT     NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX recipes_unique_name_idx
  ON recipes (name);

CREATE TABLE catalogs
(
  id   SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL
);

CREATE TABLE ingredients
(
  id  SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL
);

CREATE TABLE catalog_to_recipe (
  id         SERIAL PRIMARY KEY,
  catalog_id INTEGER NOT NULL,
  recipe_id  INTEGER NOT NULL,
  CONSTRAINT FK_catalog_id FOREIGN KEY (catalog_id) REFERENCES catalogs (id) ON DELETE CASCADE,
  CONSTRAINT FK_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes (id) ON DELETE CASCADE
);

CREATE TABLE ingredient_to_recipe (
  id            SERIAL PRIMARY KEY,
  ingredient_id INTEGER NOT NULL,
  recipe_id     INTEGER NOT NULL,
  CONSTRAINT FK_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredients (id) ON DELETE CASCADE,
  CONSTRAINT FK_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes (id) ON DELETE CASCADE
);
