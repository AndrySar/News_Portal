[![Build Status](https://travis-ci.org/AndrySar/News_Portal.svg?branch=master)](https://travis-ci.org/AndrySar/News_Portal)
# News_Portal

# Описание

Разработать веб-приложение по управлению новостной лентой на сайте. Каждая новость состоит из названия, содержания, даты публикации и категории,к которой относится новость.
Каждая категория содержит название, и к ней может быть привязано несколько новостей.

Приложение должно предоставлять следующиевозможности по работе с новостями:
    * ul просматривать список новостей
    * ul поиск новости по категории (возможность выбрать из существующих категорий),названию и содержанию
    * ul создание и редактирование новости
    * ul удаление новости

[Проект на Heroku](http://myhuapplication.herokuapp.com/)

# Стек технологий

* ul Spring, Spring MVC
* ul Maven
* ul PostgreSQL
* ul JPA, Hibernate
* ul Appache Tomcat
* ul Bootstrap template
* ul JUnit4

## Установка

Вносим изменение в конфигурационные файлы application.properties ( конфигурация приложения) и testdb.properties ( для тестов)

## Tесты

Тестирование реализовано с помощью JUnit4
 * ul `TestMainController` - тесты контроллера MainController
 * ul `TestNewsService`- тесты сервиса по работе с новостями NewsService


