INSERT INTO charac (id, name, speed, weight, creation_date, updated_date ) VALUES (1, 'Wario', 1.65, 107, NOW(), NOW()) ON DUPLICATE KEY UPDATE id = 1;
INSERT INTO charac (id, name, speed, weight, creation_date, updated_date ) VALUES (2, 'Toon Link', 1.906, 91, NOW(), NOW()) ON DUPLICATE KEY UPDATE id = 2;
INSERT INTO charac (id, name, speed, weight, creation_date, updated_date ) VALUES (3, 'Fox', 2.402, 77, NOW(), NOW()) ON DUPLICATE KEY UPDATE id = 3;
INSERT INTO charac (id, name, speed, weight, creation_date, updated_date ) VALUES (4, 'Donkey Kong', 1.873, 127, NOW(), NOW()) ON DUPLICATE KEY UPDATE id = 4;
INSERT INTO charac (id, name, speed, weight, creation_date, updated_date ) VALUES (5, 'Pikachu', 2.039, 79, NOW(), NOW()) ON DUPLICATE KEY UPDATE id = 5;