DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM users;
DELETE FROM cafes;
ALTER SEQUENCE global_seq RESTART WITH 100000;


INSERT INTO users (name, email, password) VALUES
('User', 'user@yandex.ru', '$2a$10$dySNnvI9ltGzlZuJSlYL7OFl79nG7YTRN6XIinjPXB7l2WtA.ftbi'),
('Admin', 'admin@gmail.com', '$2a$10$dySNnvI9ltGzlZuJSlYL7OFl79nG7YTRN6XIinjPXB7l2WtA.ftbi');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO cafes (name) VALUES
('Lido'),
('McDonalds');


INSERT INTO dishes (cafe_id, description, price) VALUES
  (100002, 'Горшочек с мясом', 5.25),
  (100002, 'Салатик', 1.5),
  (100002, 'Супчик', 2.25),
  (100002, 'Компот', 0.75),
  (100003, 'Chicken McNuggets', 2.5),
  (100003, 'Hamburger', 2.0),
  (100003, 'Coca-Cola', 1.5);


