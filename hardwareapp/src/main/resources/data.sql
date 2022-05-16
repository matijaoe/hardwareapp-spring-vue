DELETE
FROM hardware;
DELETE
FROM review;

INSERT INTO hardware (code, name, price, type, quantity)
VALUES ('BX8071512700K', 'Intel Core i7-12700K', 384.98, 'CPU', 14),
       ('BX8071512900K', 'Intel Core i9-12900K', 614.99, 'CPU', 6),
       ('N82E16819113683', 'AMD Ryzen 5 5600GE', 220.00, 'CPU', 22),
       ('N82E16819113664', 'AMD Ryzen 9 5900X', 395.00, 'CPU', 11),
       ('N82E16819113665', 'AMD Ryzen 7 5800X', 359.00, 'CPU', 28),
       ('N82E16814932443', 'GIGABYTE Gaming GeForce RTX 3070 Ti', 858.33, 'GPU', 3),
       ('MZV7S500BAM', 'SAMSUNG 970 EVO PLUS', 69.99, 'STORAGE', 31),
       ('WDS100T1X0E', 'Western Digital WD BLACK SN850', 149.99, 'STORAGE', 18),
       ('BLM2K8G44C19U4B', 'Crucial Ballistix MAX 4400 MHz', 79.99, 'STORAGE', 20),
       ('N82E16820232880', 'G.SKILL Ripjaws V Series 16GB DDR4', 85.99, 'RAM', 16),
       ('N82E16820821488', 'OLOy Blade RGB 32GB DDR5', 309.99, 'RAM', 3),
       ('CMW32GX4M2D3600C18', 'CORSAIR Vengeance RGB Pro 32GB', 124.99, 'RAM', 9),
       ('N82E16813119500', 'Asus ROG STRIX B550-F', 229.99, 'MBO', 1),
       ('N82E16813119504', 'ASUS ROG Maximus Z690 Hero', 599.99, 'MBO', 5);

INSERT INTO review (title, text, rating, hardware_id)
VALUES ('Pure intel trash', 'Intel be as intel does', 2, 1),
       ('AMD is the best', 'AMD is the best', 1, 1),
       ('Intel be fire tho', 'This is my recenzija and this is me writing something', 1, 2),
       ('Bad product', 'I hate this product', 2, 2),
       ('Trash', 'It broke my computer', 1, 2),
       ('Great product', 'I love this product', 5, 3),
       ('Ok', 'Ja sam Marko', 3, 3),
       ('Good product', 'I like this product', 4, 3),
       ('Superiška', 'Bas je lepo', 5, 4),
       ('Great product', 'I love this product', 4, 4),
       ('Okay speeds', 'Could be faster', 4, 5),
       ('Fast boi', 'Bet', 5, 6),
       ('Doing it job', 'It better be, for that price', 4, 7),
       ('Meh', 'Expected more', 2, 7),
       ('Lit', 'I like this product', 4, 8),
       ('Awesome', 'Thats it. Thats the review.', 5, 9),
       ('Groovy product', 'I do be grooving with this product', 4, 10),
       ('Aight', 'Certified hood classic ', 5, 10);
       

INSERT INTO user(id, username, password)
VALUES (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
       (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin
INSERT INTO authority (id, authority_name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');
INSERT INTO user_authority (user_id, authority_id)
VALUES (1, 2),
       (2, 1);