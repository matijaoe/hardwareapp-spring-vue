CREATE TABLE IF NOT EXISTS hardware
(
    id             LONG PRIMARY KEY AUTO_INCREMENT,
    code           VARCHAR(100)  NOT NULL,
    name           VARCHAR(255)  NOT NULL,
    price          DECIMAL(6, 2) NOT NULL,
    type           varchar(255)  NOT NULL,
    availableCount INT           NOT NULL
);
