<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
 color:white;
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

footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 10px 0;
}
footer a{
 color: #1abc9c;
}

.news-container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.news-title {
    font-size: 2em;
    margin-bottom: 10px;
}

.news-brief {
    font-size: 1.2em;
    margin-bottom: 20px;
    color: #555;
}

.news-content {
    font-size: 1em;
    line-height: 1.6;
    margin-bottom: 20px;
}

.news-author {
    font-size: 0.9em;
    color: #888;
}

.news-date {
    font-size: 0.9em;
    color: #888;
}

.news-views {
    font-size: 0.9em;
    color: #888;
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
                <li><a href="Controller?command=go_to_category_page" >Категории</a></li>
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

    <div class="news-container">
        <div class="news-title">${news.title}</div>
        <div class="news-brief">${news.brief}</div>
        <div class="news-content">${news.content}</div>
        <div class="news-author">Автор: ${news.author}</div>
        <div class="news-date">Дата публикации: <fmt:formatDate value="${news.publicationDate}" pattern="dd.MM.yyyy HH:mm" /></div>
        <div class="news-views">Просмотры: ${news.views}</div>
    </div>

    </main>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>