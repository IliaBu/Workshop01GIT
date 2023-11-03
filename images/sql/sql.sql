-- создадим базу данных
DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE IF NOT EXISTS HumanFriends;

-- выберем созданную базу данных HumanFriends 
USE HumanFriends;

-- создадим таблицу Category
DROP TABLE IF EXISTS Category;
CREATE TABLE IF NOT EXISTS Category(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50)
);

-- заполним таблицу Category 
INSERT INTO Category(name)
VALUES
    ('Pets'),
    ('Pack Animals');

-- выведем все значения таблицы Category
SELECT * FROM HumanFriends.Category;

-- создадим таблицу Types и сделаем связь с таблицей Category
DROP TABLE IF EXISTS Types;
CREATE TABLE IF NOT EXISTS Types(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    category_id INT,
    CONSTRAINT fk_category FOREIGN KEY(category_id) REFERENCES Category(id)
);

-- заполним таблицу Types
INSERT INTO Types(name, category_id)
VALUES
    ('Dog', 1),
    ('Cat', 1),
    ('Hamster', 1),
    ('Horse', 2),
    ('Camel', 2),
    ('Donkey', 2);  
    
-- выведем все значения таблицы Types
SELECT * FROM HumanFriends.Types;

-- создадим таблицу Animals и сделаем связь с таблицей Types
DROP TABLE IF EXISTS Animals;
CREATE TABLE IF NOT EXISTS Animals(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    type_id int,
    birthday DATE,
    CONSTRAINT fk_type Foreign Key (type_id) REFERENCES Types(id)
);

-- заполним таблицу Animals
INSERT INTO Animals(name, type_id, birthday)
VALUES
	('Fido', 1, '2020-01-01'),
    ('Whiskers', 2, '2019-05-15'),
    ('Hammy', 3, '2021-03-10'),
    ('Buddy', 1, '2018-12-10'),
    ('Smudge', 2, '2020-02-20'),
    ('Peanut', 3, '2021-08-01'),
    ('Bella', 1, '2019-11-11'),
    ('Oliver', 2, '2020-06-30'),
    ('Thunder', 3, '2015-07-21'),
    ('Sandy', 4, '2016-11-03'),
    ('Eeyore', 5, '2017-09-18'),
    ('Storm', 6, '2014-05-05'),
    ('Dune', 4, '2018-12-12'),
    ('Burro', 5, '2019-01-23'),
    ('Blaze', 6, '2016-02-29'),
    ('Sahara', 5, '2015-08-14');

-- выведем все значения таблицы Animals
SELECT * FROM HumanFriends.Animals;

-- создадим таблицу Commands и сделаем связь с таблицей Animals
DROP TABLE IF EXISTS Commands;
CREATE TABLE IF NOT EXISTS Commands(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    animal_id int,
    CONSTRAINT fk_animal Foreign Key (animal_id) REFERENCES Animals(id)
);

-- заполним таблицу Commands
INSERT INTO Commands(name, animal_id)
VALUES 
    ('Barrier', 1), ('Place', 1), ('Go around', 1),
    ('Home', 2), ('Fetch', 2),
    ('Throw', 3), ('Up', 3),
    ('Sit', 4), ('Leg', 4),
    ('Sit', 5), ('Fetch', 5),
    ('Home', 6), ('Place', 6),
    ('Sit', 7), ('Jump', 7), ('Up', 7),
    ('Jump', 8), ('Throw', 8), ('Barrier', 8),
	('Barrier', 9), ('Up', 9), ('Jump', 9),
    ('Go around', 10), ('Sit', 10),
    ('Walk', 11), ('Bray', 11),
    ('Trot', 12), ('Canter', 12),
    ('Walk', 13), ('Sit', 13),
    ('Walk', 14), ('Kick', 14),
    ('Trot', 15), ('Gallop', 15),
    ('Walk', 16), ('Run', 16);
    
-- выведем все значения таблицы Commands
SELECT * FROM HumanFriends.Commands;

-- создадим виртуальную таблицу, которая объединяет таблицы Category, Types, Animals, Commands и выбирает только лошадей и ослов
CREATE VIEW PackAnimalsWithCommands AS
SELECT 
    a.id,
    a.name,
    a.birthday,
    t.name AS animal_type,
    c.name AS category,
    GROUP_CONCAT(cm.name ORDER BY cm.name ASC SEPARATOR ', ') AS concatenated_commands
FROM Animals AS a
LEFT JOIN Types AS t ON t.id = a.type_id
JOIN Category AS c ON t.category_id = c.id
LEFT JOIN Commands AS cm ON cm.animal_id = a.id
WHERE c.name = 'Pack Animals' AND (t.name = 'Horse' OR t.name = 'Camel')
GROUP BY a.id, a.name, a.birthday, t.name, c.name;

-- выполним команду PackAnimalsWithCommands
SELECT * FROM humanfriends.packanimalswithcommands;

-- создадим виртуальную таблицу, которая объединяет таблицы Types, Animals, Category и выберет возраст животных от 1 до 3 лет
CREATE VIEW AnimalsWithAgeFrom1To3 AS
SELECT
    a.name,
    a.birthday,
    t.name AS animal_type,
    c.name AS category,
    CONCAT(
        TIMESTAMPDIFF(YEAR, a.birthday, CURDATE()),
        ' years ',
        TIMESTAMPDIFF(MONTH, a.birthday, CURDATE()) % 12,
        ' months'
    ) AS age
FROM Animals as a
LEFT JOIN Types AS t ON t.id = a.type_id
JOIN Category AS c ON t.category_id = c.id
WHERE TIMESTAMPDIFF(YEAR, a.birthday, CURDATE()) BETWEEN 1 AND 3;

-- выполним команду PackAnimalsWithCommands
SELECT * FROM humanfriends.AnimalsWithAgeFrom1To3;

-- выведем объединённую таблицу
SELECT 
    a.id,
    a.name,
    CONCAT(
        TIMESTAMPDIFF(YEAR, a.birthday, CURDATE()),
        ' years ',
        TIMESTAMPDIFF(MONTH, a.birthday, CURDATE()) % 12,
        ' months'
    ) AS age,
    t.name AS animal_type,
    c.name AS category,
    GROUP_CONCAT(cm.name ORDER BY cm.name ASC SEPARATOR ', ') AS concatenated_commands
FROM Animals AS a
LEFT JOIN Types AS t ON t.id = a.type_id
JOIN Category AS c ON t.category_id = c.id
LEFT JOIN Commands AS cm ON cm.animal_id = a.id
GROUP BY a.id, a.name, a.birthday, t.name, c.name
ORDER BY age;