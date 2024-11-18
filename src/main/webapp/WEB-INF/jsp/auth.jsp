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
    <title>Авторизация</title>
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
                <a href="goToAuto" class="login-button">Войти</a>
            </div>
        </nav>
    </header>
    <div class="login-container">
        <div class="login-image">
            <img src="/images/auth.png" alt="Login Image">
        </div>
        <h2>Вход</h2>
        <div class="error-message" id="error-message" style="color: red; margin-top:0;">
            <c:if test="${not empty requestScope.authError}">
                <c:out value="${requestScope.authError}" />
                <script>console.log("authError: ${requestScope.authError}");</script>
            </c:if>
        </div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="do_auth">
            <div class="input-group">
                <label for="login">Логин</label>
                <input type="text" id="login" name="login" required>
            </div>
            <div class="input-group">
                <label for="password">Пароль</label>
                <input type="password" id="password" name="password" required>
            </div>
           <div class="input-group remember-me">
    <input type="checkbox" id="remember-me" name="remember-me">
    <label for="remember-me">Запомнить меня</label>
</div>

            <button type="submit">Войти</button>
            <div class="links">
                <a href="#">Забыли пароль?</a>
                <a href="Controller?command=go_to_registration">Регистрация</a>
            </div>
        </form>
    </div>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>
