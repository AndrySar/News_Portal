[![Build Status](https://travis-ci.org/AndrySar/News_Portal.svg?branch=master)](https://travis-ci.org/AndrySar/News_Portal)
# News_Portal

# Описание

Разработать веб-приложение по управлению новостной лентой на сайте. Каждая новость состоит из названия, содержания, даты публикации и категории,к которой относится новость.
Каждая категория содержит название, и к ней может быть привязано несколько новостей.

Приложение должно предоставлять следующиевозможности по работе с новостями:
    * просматривать список новостей
    * поиск новости по категории (возможность выбрать из существующих категорий),названию и содержанию
    * создание и редактирование новости
    * удаление новости

[Проект на Heroku](https://news-portal-spring.herokuapp.com/news)

# Стек технологий

* Spring, Spring MVC
* Maven
* PostgreSQL
* JPA, Hibernate
* Appache Tomcat
* Bootstrap template
* JUnit4

## Установка

Вносим изменение в конфигурационные файлы application.properties ( конфигурация приложения) и testdb.properties ( для тестов)

## Tесты

Тестирование реализовано с помощью JUnit4
 * `TestMainController` - тесты контроллера MainController
 * `TestNewsService`- тесты сервиса по работе с новостями NewsService


