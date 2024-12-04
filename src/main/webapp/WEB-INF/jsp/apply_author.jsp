<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Заявка на автора</title>
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
    margin: 0 15px; 
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
/* Стили для формы подачи заявки на автора */
button[type="submit"] {
    width: 30%;
      margin: 0 auto;
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

main {
display:flex;
justify-content: space-between;

 
    
}
.form-apply-author{
	background-color: #ffffff;#
   
   
    
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 60%;
    margin: 10px auto;
}

.form-apply-author h2 {
    text-align: center;
    color: #333333;
}

form {
    display: flex;
    flex-direction: column;
     padding: 20px 50px;
}

label {
    margin-bottom: 5px;
    color: #555555;
}

input[type="text"],
input[type="email"],
input[type="password"],
input[type="confirm-password"],
input[type="tel"],
textarea {
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #cccccc;
    border-radius: 5px;
    width: 100%;
    box-sizing: border-box;
}

input[type="file"] {
    margin-bottom: 15px;
}

input[type="checkbox"] {
    margin-right: 10px;
}


h3 {
    color: #333333;
    margin-bottom: 10px;
}

textarea {
    resize: vertical;
}
</style>
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
    <main>
    <div class="form-apply-author">
    <h2>Заявка на автора</h2>
    <form action="goController" method="post" >
        <input type="hidden" name="command" value="do_apply_author">

       <h3>Основная информация:</h3>
        <label for="firstName">Имя:</label>
        <input type="text" id="firstName" name="firstName" value="${sessionScope.authorApply.firstName}" required><br><br>
        <label for="lastName">Фамилия:</label>
        <input type="text" id="lastName" name="lastName" value="${sessionScope.authorApply.lastName}" required><br><br>
        <label for="email">Электронная почта:</label>
        <input type="email" id="email" name="email" value="${sessionScope.authorApply.email}" required><br><br>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required><br><br>
        <div class="error-message" id="error-message" style="color: red; margin-top:0;">
            <c:if test="${not empty requestScope.authError}">
                <c:out value="${requestScope.authError}" />
            </c:if>
        </div>
        <label for="confirm-password">Подтвердите пароль:</label>
        <input type="password" id="confirm-password" name="confirm-password" required><br><br>

        <h3>Профессиональная информация:</h3>
        <label for="bio">Биография:</label><br>
        <textarea id="bio" name="bio" rows="4" cols="50" required>${sessionScope.authorApply.bio}</textarea><br><br>
        <label for="specialization">Темы, в которых вы специализируетесь:</label><br>
        <textarea id="specialization" name="specialization" rows="2" cols="50" required>${sessionScope.authorApply.specialization}</textarea><br><br>
        <label for="workExamples">Примеры работ (ссылки):</label><br>
        <textarea id="workExamples" name="workExamples" rows="2" cols="50">${sessionScope.authorApply.workExamples}</textarea><br><br>

        <h3>Контактная информация:</h3>
        <label for="phone">Телефонный номер:</label>
        <input type="tel" id="phone" name="phone" value="${sessionScope.authorApply.phone}" required><br><br>
        <label for="socialLinks">Ссылки на профили в социальных сетях:</label><br>
        <textarea id="socialLinks" name="socialLinks" rows="2" cols="50">${sessionScope.authorApply.socialLinks}</textarea><br><br>

        <h3>Согласие и подтверждение:</h3>
        <label>
            <input type="checkbox" name="terms" required>
            Согласие с условиями использования и политикой конфиденциальности
        </label><br><br>

        <button type="submit">Отправить заявку</button>
    </form>
    </div>
    </main>
     <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>