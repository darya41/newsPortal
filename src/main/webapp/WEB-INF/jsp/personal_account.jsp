<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <div class="logo">Новостной Портал</div>
        <nav>
            <ul class="menu">
                <li><a href="#">Главная</a></li>
                <li><a href="#">Новости</a></li>
                <li><a href="#">Категории</a></li>
            </ul>
            <div class="auth-buttons">
                <a href="logout" class="login-button">Выйти</a>
            </div>
        </nav>
    </header>
    <main>
        <div class="navbar">
    <h1>Личный кабинет</h1>
</div>
<div class="sidebar">
    <ul>
        <li>Главная</li>
        <li>Сообщения</li>
        <li>Сохраненные новости</li>
        <li>Лайки и комментарии</li>
        <li>Статистика</li>
        <li>Категории</li>
    </ul>
</div>
<div class="main-content">
    <div class="profile">
        <h2>Ирина Рыбина</h2>
        <p>Отдел маркетинга и продаж</p>
    </div>
    <div class="saved-news">
        <h3>Сохраненные новости</h3>
        <!-- Список сохраненных новостей -->
    </div>
    <div class="likes-comments">
        <h3>Лайки и комментарии</h3>
        <!-- Список лайков и комментариев -->
    </div>
</div>

    </main>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>
