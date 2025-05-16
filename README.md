📚 TomeTrackApp



TomeTrackApp — это веб-приложение для ведения личной библиотеки книг. Приложение позволяет добавлять, просматривать и удалять книги, а также регистрироваться и входить под своей учётной записью.

🚀 Функциональные возможности
🔐 Аутентификация — регистрация и вход в систему
📘 Добавление книг — сохраняйте книги, которые вы прочитали или планируете прочитать
📜 Список книг — просматривайте весь список книг, добавленных в систему
🗑️ Удаление книг — удаляйте книги, которые больше не нужны
👤 Привязка к пользователю — каждая книга привязана к зарегистрированному пользователю
📱 Отзывчивый интерфейс — простой адаптивный интерфейс на HTML + Thymeleaf

![image](https://github.com/user-attachments/assets/d35f7c52-6287-4cf3-89fa-3adb9720ca18)
![image](https://github.com/user-attachments/assets/e35de013-11af-47a7-8f7c-5a8fad1b7c2d)

🛠️ Технологии
Проект построен с использованием следующих технологий:

Backend: Spring Boot (Java)
Безопасность: Spring Security, BCrypt
Шаблонизатор: Thymeleaf
База данных: PostgreSQL
Сборка: Maven
Тестирование: JUnit, Mockito

⚙️ Установка и запуск
📋 Предварительные требования:
Java 17+

Maven

PostgreSQL

🔧 Инструкции по запуску:
Клонируйте репозиторий:

git clone https://github.com/helloegor03/TomeTrackApp.git
cd TomeTrackApp

Создайте базу данных PostgreSQL и настройте application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/название_бд
spring.datasource.username=ваш_пользователь
spring.datasource.password=ваш_пароль

Соберите и запустите проект:

mvn clean install
mvn spring-boot:run
Перейдите в браузере по адресу:
http://localhost:8080
