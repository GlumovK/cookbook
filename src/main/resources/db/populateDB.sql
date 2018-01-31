DELETE FROM user_roles;
DELETE FROM ingredient_to_recipe;
DELETE FROM catalog_to_recipe;
DELETE FROM ingredients;
DELETE FROM catalogs;
DELETE FROM recipes;
DELETE FROM users;




INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 1),
  ('ROLE_ADMIN', 2);

INSERT INTO recipes (name, description, cookAlgorithm, user_id, rating) VALUES
  ('Borsch', 'Суп со свеклой', 'алгоритм борща', 1, 20),
  ('Mushroom soup', 'Суп с грибами', 'алгоритм грибовницы', 1, 15),
  ('Olivie', 'Салат с мясом', 'алгоритм оливье', 2, 26),
  ('Omelette', 'Жареные яйца', 'алгоритм яишницы', 2, 11),
  ('Cappuccino', 'Кофе с молоком', 'алгоритм капучино', 2, 42);

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
  (1, 1),
  (1, 2),
  (2, 4),
  (3, 4),
  (4, 3),
  (5, 5);

INSERT INTO ingredient_to_recipe (ingredient_id, recipe_id) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
  (3, 2),
  (4, 1),
  (4, 3),
  (5, 3),
  (6, 4),
  (7, 5);
