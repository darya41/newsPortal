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
                        <a href="goToPersonalAccount" class="login-button">Личный кабинет</a>
                    </c:when>
                    <c:otherwise>
                        <a href="goToAuto" class="login-button">Войти</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>
    </header>
    <main>
        <section class="hero">
        	<c:choose>
		    	<c:when test="${not empty sessionScope.user}">
		        	<h1> ${sessionScope.user.name} добро пожаловать на наш Новостной Портал!</h1>
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
