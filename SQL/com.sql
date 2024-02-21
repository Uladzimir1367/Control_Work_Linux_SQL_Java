В подключённом MySQL создаём БД

CREATE DATABASE Human_friends;

Создаём таблицы с иерархией из диаграммы в БД

USE Human_friends;
CREATE TABLE animal_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(20)
);

INSERT INTO animal_classes (Class_name)
VALUES ('вьючные'),
('домашние');  


CREATE TABLE packed_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO packed_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
('Ослы', 1),  
('Верблюды', 1); 
    
CREATE TABLE home_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_animals (Genus_name, Class_id)
VALUES ('Cats', 2),
('Dogs', 2),  
('Hamsters', 2); 

CREATE TABLE cats 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

3. Заполняем низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Мурзик', '2020-02-23', 'кис-кис', 1),
('Пушок', '2018-01-25', "псик", 1),  
('Гаврош', '2015-09-10', "киса-киса", 1); 

CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Тузик', '2010-02-23', 'сидеть, фас, лапу, лежать', 2),
('Барбос', '2019-01-25', "сидеть, лежать, лапу", 2),  
('Шарик', '2019-06-26', "сидеть, лежать", 2); 

CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Ки-Kи', '2023-02-23', NULL, 3),
('Муш-Муш', '2022-02-20', NULL, 3);  

CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Гроза', '2020-02-23', 'бегом, шагом, стоп', 1),
('Мечта', '2017-01-20', "бегом, шагом, стоп", 1),  
('Форсаж', '2018-02-20', "бегом, шагом, стоп", 1); 

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('Иа', '2021-01-10', "но-но", 2),
('Иа2', '2022-02-20', "тру", 2),  
('Иа3', '2022-04-20', "тру", 2); 

CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Сахара', '2022-04-10', 'стоп', 3),
('Оазис', '2021-04-10', "стоп, но-но", 3),  
('Симпатико', '2021-01-20', "стоп, но-но", 3);

4. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

TRUNCATE camels;
CREATE TABLE ungulates AS
SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;

5. Создать новую таблицу “молодые животные” в которую попадут всеживотные старше 1 года, но младше 3 лет и в отдельном столбце с точностьюдо месяца подсчитать возраст животных в новой таблице

CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Лошади' as genus FROM horses
UNION SELECT *, 'Ослы' AS genus FROM donkeys
UNION SELECT *, 'Dogs' AS genus FROM dogs
UNION SELECT *, 'Cats' AS genus FROM cats
UNION SELECT *, 'Hamsters' AS genus FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM yang_animal;

6. Объединяем все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.


CREATE TABLE All_animals AS 
SELECT *, 'Лошади' AS genus FROM horses AS вьючные
UNION SELECT *, 'Ослы' AS genus FROM donkeys AS вьючные
UNION SELECT *, 'Dogs' AS genus FROM dogs AS домашние
UNION SELECT *, 'Cats' AS genus FROM cats AS домашние
UNION SELECT *, 'Hamsters' AS genus FROM hamsters AS домашние;



    


