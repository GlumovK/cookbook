DELETE FROM user_roles;
DELETE FROM ingredient_to_recipe;
DELETE FROM catalog_to_recipe;
DELETE FROM ingredients;
DELETE FROM catalogs;
DELETE FROM recipes;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO recipes (name, description, cookAlgorithm, user_id, rating) VALUES
  ('Borsch', 'Суп со свеклой', 'алгоритм борща', 100000, 20),
  ('Mushroom soup', 'Суп с грибами', 'алгоритм грибовницы', 100000, 15),
  ('Olivie', 'Салат с мясом', 'алгоритм оливье', 100001, 26),
  ('Omelette', 'Жареные яйца', 'алгоритм яишницы', 100001, 11),
  ('Cappuccino', 'Кофе с молоком', 'алгоритм капучино', 100001, 42);

INSERT INTO catalogs (name) VALUES
  ('Soup'),
  ('Second course'),
  ('Snack'),
  ('Salad'),
  ('Drink');

INSERT INTO ingredients (name) VALUES
  ('Potatoes'),
  ('Beet'),
  ('Mushroom'),
  ('Meat'),
  ('Pease'),
  ('Egg'),
  ('Coffee');

INSERT INTO catalog_to_recipe (catalog_id, recipe_id) VALUES
  (100007, 100002),
  (100007, 100003),
  (100008, 100005),
  (100009, 100005),
  (100010, 100004),
  (100011, 100006);

INSERT INTO ingredient_to_recipe (ingredient_id, recipe_id) VALUES
  (100012, 100002),
  (100012, 100003),
  (100012, 100004),
  (100013, 100002),
  (100014, 100003),
  (100015, 100002),
  (100015, 100004),
  (100016, 100004),
  (100017, 100005),
  (100018, 100006);