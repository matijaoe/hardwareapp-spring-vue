CREATE TABLE IF NOT EXISTS hardware
(
    id       IDENTITY,
    code     VARCHAR(100)                                          NOT NULL UNIQUE,
    name     VARCHAR(255)                                          NOT NULL,
    price    DECIMAL(6, 2)                                         NOT NULL,
    type     ENUM ('CPU', 'GPU', 'MBO', 'RAM', 'STORAGE', 'OTHER') NOT NULL,
    quantity INT                                                   NOT NULL
);

CREATE TABLE IF NOT EXISTS review
(
    id          IDENTITY,
    title       VARCHAR(255) NOT NULL,
    text        TEXT         NOT NULL,
    rating      INT          NOT NULL,
    hardware_id INT          NOT NULL,
    FOREIGN KEY (hardware_id) REFERENCES hardware (id)
)