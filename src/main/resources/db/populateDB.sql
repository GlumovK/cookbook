DELETE FROM  ingredient_to_recipe;
DELETE FROM catalog_to_recipe;
DELETE FROM ingredients;
DELETE FROM catalogs;
DELETE FROM recipes;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO recipes (name, description, cookAlgorithm, user_id, rating) VALUES
  ('Борщ', 'Суп со свеклой', 'алгоритм борща', 100000, 20),
  ('Грибовница', 'Суп с грибами', 'алгоритм грибовницы', 100000, 15),
  ('Оливье', 'Салат с мясом', 'алгоритм оливье', 100001, 26),
  ('Яишница', 'Жареные яйца', 'алгоритм яишницы', 100001, 11),
  ('Капучино', 'Кофе с молоком', 'алгоритм капучино', 100001, 42);

INSERT INTO catalogs (name) VALUES
  ('Суп'),
  ('Второе'),
  ('Закуски'),
  ('Салаты'),
  ('Напитки');

INSERT INTO ingredients (name) VALUES
  ('Картофель'),
  ('Свекла'),
  ('Грибы'),
  ('Мясо'),
  ('Горошек'),
  ('Яйцо'),
  ('Кофе');

INSERT INTO catalog_to_recipe (catalog_id, recipe_id) VALUES
  (100007, 100002),
  (100007, 100003),
  (100008, 100005),
  (100009, 100005),
  (100010, 100004),
  (100011, 100006);

INSERT INTO ingredient_to_recipe (ingredient_id, recipe_id) VALUES
  (100012,100002),
  (100012,100003),
  (100012,100004),
  (100013,100002),
  (100014,100003),
  (100015,100002),
  (100015,100004),
  (100016,100004),
  (100017,100005),
  (100018,100006);