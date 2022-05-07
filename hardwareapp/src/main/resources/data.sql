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
VALUES ('Great product', 'I love this product', 5, 1);
--        ('Bad product', 'I hate this product', 1, 2),
--        ('Good product', 'I like this product', 4, 3),
--        ('Great product', 'I love this product', 5, 4),