### 6. Диаграмма классов
   - Создать диаграмму классов с родительским классом "Animals", и двумя подклассами: "home_animals" и "packed_animals".
В составы классов которых в случае Pets войдут классы: собаки, кошки, хомяки, а в класс Pack animals войдут: Лошади, верблюды и ослы.
Каждый тип животных будет характеризоваться (например, имена, даты рождения, выполняемые команды и т.д)

#### __Диаграмма в файле Animals.pdf__

### 7. Работа с MySQL Задача выполняется в случае успешного выполнения задачи “Работа с MySQL в Linux. “Установить MySQL на вашу машину”

7.1. После создания диаграммы классов в 6 пункте, в 7 пункте база данных "Human Friends" должна быть структурирована в соответствии с этой диаграммой. Например, можно создать таблицы, которые будут соответствовать классам "home_animals" и "Packed_ animals". В таблицах создать поля, которые характеризуют каждый тип животных (например, имена, даты рождения, выполняемые команды и т.д.).<br> 
7.2  В ранее подключенном MySQL создать базу данных с названием "Human Friends".
   - Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
   - Заполнить таблицы данными о животных, их командах и датами рождения.
   - Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
   - Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
   - Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
  
### Все запросы SGL приведены в файле com.sql 

### 1. Поключаемся к MySQL и создаём базу данных __"Human_Friends"__
   
<image src="images/Задание 7.png" alt="Подключение к SGL">
   <image src="images/Задание 7.1.png" alt="Сощдание базы данных ">

### 2. В БД создаём таблицу __animal_clases__.
   Создаём иерархию таблиц.   
   В базе данных создаём таблицы, которые будут соответствовать классам _"home_animals"_ и _"packed_ animals". В этих таблицах будут поля, которые характеризуют каждый тип животных (например, имена, даты рождения, выполняемые команды и т.д.). 

<image src="images/animal_clases.png" alt="Подключение к SGL">
<image src="images/Задание 7 11.png" alt="Подключение к SGL">

### 3. Создаём таблицы Cats, Dogs, Hamsters, Donkyes, Horses, Camels и запоняем их именами, датами рождения, выполняемыми командами. 

<image src="images/Процесс создания таблиц.png" alt="Создание таблиц">
<image src="images/Формирование таблиц.png" alt="Создание таблиц">
<image src="images/заполнение таблицы верблюдов.png" alt="Создание таблиц">
<image src="images/общая таблица.png" alt="Создание таблиц">
<image src="images/созданные таблицы.png" alt="тфблицы">
<image src="images/созданные таблицы 2.png" alt="таблицы">
<image src="images/созданные таблицы 3.png" alt="таблицы">

### 4. Удаляем записи о верблюдах и объединяем таблицы лошадей и ослов. Создали таблицу _ungulates._

<image src="images/Объединение таблиц лошади + ослы.png" alt="лошади + ослы">
   
### 5. Создаём новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

<image src="images/Временная таблица.png" alt="таблицы">
<image src="images/Таблица молодых животных.png" alt="таблицы">

### 6. Объединяем все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам. (Итоговая таблица всех животных в питомнике.png)

<image src="images/Итоговая таблица всех животных в питомнике.png" alt="таблицы">

 