CREATE TABLE book (
  id         BIGINT            IDENTITY NOT NULL PRIMARY KEY,
  title      VARCHAR(500)      NOT NULL,
  tags       VARCHAR(1000)
);