# Операционные системы и виртуализация (Linux)

### 1. Использование команды cat в Linux
   - Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
   - Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
   - Переименовать получившийся файл в "Human Friends"

1. Создаём директорию mkdir final_test
   Переходим в директорию cd final_test
  Создаём файлы "Pets" и "Pack animals" командами cat > "Pets" и cat > "Pack animals" и в каждый из файлов добавляем животных.
  Объединяем содержимое двух файлов cat 'Pets' 'Pack animals' > 'Animals' 
   Просматриваем содержимое файла cat Animals
   Переименовываем файл mv Animals 'Human Friends'
   Посматриваем директорию final_test -> ll

   *Результат выполнения:*
<image src="images/Задание 1.png" alt="Linux">  

### 2. Работа с директориями в Linux
   - Создать новую директорию и переместить туда файл "Human Friends".

1. Создаём директорию mkdir Animals
2. Перемещаем туда файл mv 'Human Friends' Animals/
3. Входим в директорию cd Animals 
4. Убеждаемся, что файл Human Friends находится в данной директории -> **ll** <br>
   *Результат выполнения* 

<image src="images/Задание 2.png" alt="Linux">

### 3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
   - Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.
  
1. Устанавливаем MySQL -> wget https://dev.mysql.com/get/mysql-apt-config_0.8.26-1_all.deb 
   
<image src="images/Задание 3.png" alt="SGL">
   
2. Подключаем дополнительный пакет -> sudo dpkg -i mysql-apt-config_0.8.26-1_all.deb

<image src="images/Задание 3.2 .png" alt="Доп пакет">

3. Выполняем обновление -> sudo apt-get update
   
<image src="images/Задание 3.3.png" alt="SGL">  

4. Производим подключение к серверу -> sudo apt install mysql-server 

<image src="images/Задание 3.4.png" alt="SQL"> 

5. Просматриваем статус подключённой  MySQL -> systemctl status mysql

<image src="images/Задание 3.5.png" alt="SQL"> 

### 4. Управление deb-пакетами
   - Установить и затем удалить deb-пакет, используя команду `dpkg`.

1. Находим и устанавливаем пакет:  
wget https://downloads.vivaldi.com/stable/vivaldi-stable_6.1.3035.204-1_amd64.deb
sudo dpkg -i vivaldi-stable_6.1.3035.204-1_amd64.deb
Обновляем пакет -> sudo apt update 

<image src="images/Задание 4.png" alt="пакет">
<image src="images/Задание 4.2.png" alt="пакет">

 
3. Удаляем пакет -> sudo dpkg -r vivaldi-stable 
   
<image src="images/Задание 4.3.png" alt="пакет">

### 5. История команд в терминале Ubuntu
   - Сохранить и выложить историю ваших терминальных команд в Ubuntu.
  
1. Вводим комнаду -> hisory <br> Выводим в терминал историю введённых команд.

<image src="images/Задание 5.png" alt="История">








 
