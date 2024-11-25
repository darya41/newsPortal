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
    <title>Главная страница</title>
    <link rel="stylesheet" href="./css/style.css">
   
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


.hero {
	background-color: #1abc9c;
	color: white;
	padding: 50px 20px;
	text-align: center;
}

.slider {
	padding: 20px;
	background-color: #fff;
}

.slider .carousel {
	display: flex;
	overflow-x: auto;
}

.slider .slide {
	min-width: 300px;
	margin-right: 20px;
	background-color: white;
	padding: 20px;
	border-radius: 5px;
	text-align: center;
}

.categories {
	padding: 20px;
	background-color: #f9f9f9;
}

.categories .category {
	background-color: #fff;
	margin: 10px 0;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.news {
	padding: 20px;
}

.news h2 {
	text-align: center;
}

.news article {
	background-color: white;
	margin: 20px 0;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.popular-news {
	padding: 20px;
	background-color: #f9f9f9;
}

.popular-news-list {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	/* Две колонки */
	gap: 20px;
	list-style-type: none;
	padding: 0;
}

.news-item {
	background-color: #fff;
	padding: 10px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border: 1px solid #ccc;
	background-color: #1abc9c;
}

.popular-slide {
	display: flex;
	flex-direction: column;
}

.more-btn {
	align-self: flex-start;
}

aside {
	padding: 20px;
	background-color: #f9f9f9;
}

.subscribe,
.social {
	margin-bottom: 20px;
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

.hero {
    background-color:#1abc9c;
    color: white;
    padding: 50px 20px;
    text-align: center;
}

.hero h1 {
    margin: 0;
    font-size: 2.5em;
}

.hero p {
    font-size: 1.2em;
}

.slider, .news, .popular-news, .exclusive-news {
    margin: 20px 0;
}

h2 {
    border-bottom: 2px solid #1abc9c;
    padding-bottom: 10px;
    margin-bottom: 20px;
}

.carousel {
    display: flex;
    overflow-x: auto;
    gap: 20px;
}
.popular-news-list {
    display: grid;
    grid-template-columns: repeat(2, 1fr); /* Два столбца одинаковой ширины */
    gap: 20px; /* Расстояние между элементами */
}

.slide, .news-item {
    background-color: white;
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 20px;
    flex: 0 0 300px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.slide h3, .news-item h3 {
    margin-top: 0;
}

.more-btn {
    background-color: #1abc9c;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    text-align: center;
    display: inline-block;
    margin-top: 10px;
}

.more-btn:hover {
    background-color: #005bb5;
}

.exclusive-news article {
    background-color: white;
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 20px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.exclusive-news h3 {
    margin-top: 0;
}
	
}
  </style>
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
        <section class="hero">
        	<c:choose>
		    	<c:when test="${not empty sessionScope.user}">
		        	<h1> ${sessionScope.user.lastName} добро пожаловать на наш Новостной Портал!</h1>
		        	<p>Последние новости и обновления</p>
		    	</c:when>
		    	<c:otherwise>
		        	<h1> Добро пожаловать на наш Новостной Портал!</h1>
            		<p>Последние новости и обновления</p>
		   		 </c:otherwise>
			</c:choose>           
        </section>
        <section class="slider">
            <h2>Главные Новости</h2>
            <div class="carousel">
            	<c:forEach var="item" items="${mainNews}">
                    <div class="slide">
                        <h3><c:out value="${item.title}" /></h3>
                        <p><c:out value="${item.brief}" /></p>
                         
                        <button class="more-btn" 
                        onclick="window.location.href='goController?command=no_auth'">Подробнее</button>

                    </div>
                </c:forEach>                
            </div>
        </section>
        
        <section class="news">
            <h2>Последние Новости</h2>
            <c:if test="${not empty latestNews}">
            	<c:forEach var="last" items="${latestNews}">
                    <div class="slide">
                        <h3><c:out value="${last.title}" /></h3>
                        <p><c:out value="${last.brief}" /></p>
                         
                        <button class="more-btn" 
                        onclick="window.location.href='goController?command=no_auth'">
                        Подробнее</button>

                    </div>
                </c:forEach>    
			</c:if>  
        </section>
        <section class="popular-news">
    		<h2>Популярные Новости</h2>
    		<ul class="popular-news-list">
        		<c:forEach var="item" items="${popularNews}">
            		<li class="news-item">
                		<div class="popular-slide">
                    		<h3><c:out value="${item.title}" /></h3>
                    		<p><c:out value="${item.brief}" /></p>
                    		<button class="more-btn" 
                    		onclick="window.location.href='goController?command=no_auth'">
                    		Подробнее</button>
                		</div>
            		</li>
        		</c:forEach>
    		</ul>
		</section>
        <c:if test="${not empty sessionScope.user}">
            <section class="exclusive-news">
                <h2>Новости по вашим интересам</h2>
                <article>
                    <h3>Заголовок  Новости 1</h3>
                    <p>Краткое описание  новости...</p>
                </article>
            </section>
        </c:if>
    </main>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>

</html>
