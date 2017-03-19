DROP TABLE IF EXISTS user_roles CASCADE ;
DROP TABLE IF EXISTS dishes CASCADE ;
DROP TABLE IF EXISTS users CASCADE ;
DROP TABLE IF EXISTS cafes CASCADE ;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE cafes (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        TEXT NOT NULL
);

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  cafe_id    INTEGER,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT TRUE,
  FOREIGN KEY (cafe_id) REFERENCES cafes (id) ON DELETE SET NULL
);

CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE dishes (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  cafe_id     INTEGER NOT NULL,
  description TEXT NOT NULL,
  price       NUMERIC,
  FOREIGN KEY (cafe_id) REFERENCES cafes (id) ON DELETE CASCADE
);
