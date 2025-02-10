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
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath() %>/images/news.ico">
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
	color: white;
}
        header a{
        color:white;
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

/*Auth*/


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

.auth-buttons {
    margin-top: 10px;
}

.auth-buttons .login-button {
    background-color: #1abc9c;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 5px;
}

.login-container {
display: flex;
    align-items: center; /* Центрирование по вертикали */
    gap: 20px; /* Расстояние между изображением и формой */
    width: 60%;
    margin: 10px auto;
    padding: 20px 50px;
    background-color: white;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.login-container .login-image {
    margin-bottom: 10px;
}
.login-image {
    flex: 1; 
   margin-bottom:5px;/* Изображение занимает одну часть */
}

.login-form {
    flex: 2; /* Форма занимает две части */
   
}


.login-container .login-image img {
    max-width: 100%;
    height: auto;
    border-radius: 5px;
}

.login-container h2 {
    margin-bottom: 20px;
}

.input-group {
    margin-bottom: 15px;
    text-align: left;
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
.remember-me-check{
margin-bottom:20px;
text-align: left;
}



button {
    width: 100%;
    padding: 10px;
    background-color: #1abc9c;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    margin-left: 5%;
}

button:hover {
    background-color: #1abc9c;
}

.links {
    margin-top: 15px;
}

.links a {
    color: #007bff;
    text-decoration: none;
    margin: 0 10px;
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
                <li><a href="Controller?command=go_to_index_main">Главная</a></li>
                <li><a href="Controller?command=go_to_all_news_page">Новости</a></li>
                <li><a href="Controller?command=go_to_category_page">Категории</a></li>
            </ul>
            <div class="auth-buttons">
                <a href="goToAuto" class="login-button">Войти</a>
            </div>
        </nav>
    </header>
    <div class="login-container">
        <div class="login-image">
           <img src="<%= request.getContextPath() %>/images/auth.jpg" alt="Login Image">
        </div>
        
        <form action="Controller" method="post">
        <h2>Вход</h2>
        <div class="error-message" id="error-message" style="color: red; margin-top:0;">
        	<c:set var="authError" value="${param.authError}" />
            <c:if test="${not empty authError}">
                <c:out value="${authError}" />
            </c:if>
        </div>
            <input type="hidden" name="command" value="do_auth">
            <div class="input-group">
                <label for="login">Логин</label>
                <input type="text" id="login" name="login" required>
            </div>
            <div class="input-group">
                <label for="password">Пароль</label>
                <input type="password" id="password" name="password" required>
            </div>
           <div class="remember-me-check">
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
