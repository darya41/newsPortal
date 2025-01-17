<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ошибка</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

header {
    background-color: #333;
    color: white;
    padding: 10px 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
    position: -webkit-sticky; /* Для поддержки в Safari */
    position: sticky;
    top: 0;
    z-index: 1000;
    border-bottom: 2px ridge;
    margin-bottom: 0;
}

header .logo {
    font-size: 24px;
    font-weight: bold;
    margin-left: 20px;
}

nav {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
}

nav ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    text-align: center;
}

nav ul li {
    margin: 0 15px; /* расстояние между пунктами меню */
}

nav .menu {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    justify-content: center;
}

nav .menu li {
    margin: 0 15px;
}

nav .menu li a {
    color: white;
    text-decoration: none;
    font-weight: bold;
}

nav .auth-buttons {
    margin-right: 20px;
}

nav .login-button {
    color: white;
    text-decoration: none;
    background-color: #1abc9c;
    padding: 10px 20px;
    border-radius: 5px;
}

.error-container {
    text-align: center;
    padding: 50px;
}

h1 {
    color: #e74c3c;
}

p {
    font-size: 18px;
}

footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px 0;
    position: fixed;
    width: 100%;
    bottom: 0;
}
</style>
</head>
<body>
<header>
     <div class="logo">
    	<a href="Controller?command=go_to_index_main">Новостной Портал</a>
    </div>
    <nav>
        <ul class="menu">
            <li><a href="#">Главная</a></li>
            <li><a href="goController?command=go_to_all_news_page">Новости</a></li>
            <li><a href="#">Категории</a></li>
        </ul>
        <div class="auth-buttons">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="Controller?command=go_to_personal_account" class="login-button">Личный кабинет</a>
                </c:when>
                <c:otherwise>
                    <a href="Controller?command=go_to_auth" class="login-button">Войти</a>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
</header>
<main>
    <div class="error-container">
        <h1>Произошла ошибка</h1>
        <p>${errorMessage}</p>
        <p>Пожалуйста, попробуйте позже или свяжитесь с поддержкой.</p>
        <p><a href="Controller?command=go_to_index_main">Вернуться на главную страницу</a></p>
    </div>
</main>
<footer>
    <p>© 2024 Новостной Портал. Все права защищены.</p>
    <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
</footer>
</body>
</html>
