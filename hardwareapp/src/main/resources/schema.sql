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
    FOREIGN KEY (hardware_id) REFERENCES hardware (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS user
(
    id       IDENTITY,
    username varchar(100)  NOT NULL UNIQUE,
    password varchar(1000) NOT NULL
);

CREATE TABLE IF NOT EXISTS authority
(
    id             IDENTITY,
    authority_name varchar(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user_authority
(
    user_id      BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT fk_authority FOREIGN KEY (authority_id) REFERENCES authority (id)
);