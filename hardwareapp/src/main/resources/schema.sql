CREATE TABLE IF NOT EXISTS hardware
(
    id       IDENTITY,
    code     VARCHAR(100)  NOT NULL UNIQUE,
    name     VARCHAR(255)  NOT NULL,
    price    DECIMAL(6, 2) NOT NULL,
    type     varchar(255)  NOT NULL,
    quantity INT           NOT NULL
);
--
-- CREATE TABLE IF NOT EXISTS reviews
-- (
--     id     LONG PRIMARY KEY AUTO_INCREMENT,
--     title  VARCHAR(255) NOT NULL,
--     text   TEXT         NOT NULL,
--     rating INT          NOT NULL,
-- )