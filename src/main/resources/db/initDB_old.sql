DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS catalogs;
DROP TABLE IF EXISTS recipes;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE recipes
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name          VARCHAR NOT NULL,
  description   VARCHAR NOT NULL,
  ingredient_id  INTEGER NOT NULL,
  cookAlgorithm VARCHAR NOT NULL,
  user_id        INTEGER NOT NULL,
  rating        INT     NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE

);
CREATE UNIQUE INDEX recipes_unique_name_idx
  ON recipes (name);

CREATE TABLE catalogs
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR NOT NULL,
  recipe_id INTEGER NOT NULL,
  FOREIGN KEY (recipe_id) REFERENCES recipes (id)
);
CREATE UNIQUE INDEX catalog_unique_recipe_name_idx
  ON catalogs (recipe_id, name);

CREATE TABLE ingredients
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR NOT NULL,
  recipe_id INTEGER NOT NULL,
  FOREIGN KEY (recipe_id) REFERENCES recipes (id)
);
CREATE UNIQUE INDEX ingredient_unique_recipe_name_idx
  ON ingredients (recipe_id, name);
