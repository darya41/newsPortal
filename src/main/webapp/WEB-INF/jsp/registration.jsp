<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
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

/* CSS для центрирования меню */
nav ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  text-align:center;
}

nav ul li {
  margin: 0 15px; /* расстояние между пунктами меню */
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
   footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 10px 0;
}

footer a {
	color: #1abc9c;
	text-decoration: none;
}
.menu {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
}

.menu li {
	margin: 0 10px;
}

.menu a {
	color: #fff;
	text-decoration: none;
}

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

footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px 0;
}

footer a {
    color: #1abc9c;
    text-decoration: none;
}

.menu {
    list-style: none;
    margin: 0;
    padding: 0;
    display: flex;
}

.menu li {
    margin: 0 10px;
}

.menu a {
    color: #fff;
    text-decoration: none;
}

.auth-buttons {
    display: flex;
}

/* Стили для формы регистрации */
.register-container {
    background-color: white;
    padding: 20px 40px;
    padding-right:70px;
    margin: 50px auto;
    width: 300px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.register-container h2 {
    text-align: center;
    margin-bottom: 20px;
}

.input-group {
    margin-bottom: 15px;
}

.input-group label {
    display: block;
    margin-bottom: 5px;
}

.input-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

button[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #1abc9c;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button[type="submit"]:hover {
    background-color: #16a085;
}

.links {
    text-align: center;
    margin-top: 20px;
}

.links a {
    color: #1abc9c;
    text-decoration: none;
   
}

.links a:hover {
    text-decoration: underline;
}
    .error-message {
        color: red;
        margin-top: 0;
        font-weight: bold; 
        text-align: center;
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
                <li><a href="Controller?command=go_to_all_news_page">Новости</a></li>
                <li><a href="#">Категории</a></li>
            </ul>
            <div class="auth-buttons">
                <a href="goToAuto" class="login-button">Войти</a>
            </div>
        </nav>
    </header>
    <div class="register-container">
        <h2>Регистрация</h2>
        <div class="error-message" id="error-message">
    <c:if test="${not empty requestScope.authError}">
        <c:out value="${requestScope.authError}" />
    </c:if>
</div>

        <form action="goController" method="post">
         <input type="hidden" name="command" value="do_registration"/>
            <div class="input-group">
                <label for="username">Имя пользователя</label>
                <input type="text" id="username" name="username" value="${sessionScope.username}" required>
            </div>
            <div class="input-group">
                <label for="email">Электронная почта</label>
                <input type="email" id="email" name="email" value="${sessionScope.email}" required>
            </div>
            <div class="input-group">
                <label for="password">Пароль</label>
                <input type="password" id="password" name="password" required>
            </div>
      
            <div class="input-group">
            	<div class="error-message" id="error-message" style="color: red; margin-top:0;">
        			<c:set var="authError" value="${param.authError}" />
            		<c:if test="${not empty authError}">
                		<c:out value="${authError}" />
            		</c:if>
        		</div>
                <label for="confirm-password">Подтвердите пароль</label>
                <input type="password" id="confirm-password" name="confirm-password" required>
            </div>
            <button type="submit">Зарегистрироваться</button>
            <div class="links">
                <a href="goController?command=go_to_auth">Уже есть аккаунт? Войти</a>
                <br>
                
                 <a href="goController?command=go_to_apply_author">Хочу быть автором. Подать заявку.</a>
            </div>
        </form>
    </div>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>
