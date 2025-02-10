<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Новости</title>
<link rel="icon" type="image/x-icon" href="<%=request.getContextPath() %>/images/news.ico">
<style>
footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 10px 0;
}
footer a{
 color: #1abc9c;
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
.logo a {
color: white;
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

  main {
            width: 80%;
            margin: 20px auto;
            overflow: hidden; /* Добавляем overflow: hidden; для корректной работы с float */
        }

        .search-bar {
            margin-bottom: 20px;
            text-align: center;
        }

        .search-bar form {
         display: flex;
            justify-content: center;  /* Center the search bar items */
            align-items: center;
        }

        .search-bar input[type="text"] {
            padding: 10px;
            width: 60%;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-right: 10px;
        }

        .search-bar button {
            background-color: #1abc9c; /* Updated Button Color */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .search-bar button:hover {
            background-color: #16a085; /* Darker shade for hover */
        }

        .news-list {
        margin-top:40px;
            display: flex; /* Use flexbox */
            flex-wrap: wrap; /* Allow items to wrap to the next line */
            justify-content: space-around; /* Distribute items evenly */
        }

        .news-item {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 20px;
            margin-bottom: 20px;
            width: 30%; /* Adjust as needed */
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
            box-sizing: border-box; /* Important for padding and width */
        }

        .news-item:hover {
            transform: translateY(-5px);
        }

        .news-item h2 {
            margin-top: 0;
            font-size: 20px;
            color: #333;
        }

        .news-item p {
            color: #666;
            font-size: 14px;
        }

        .news-item a {
            display: inline-block;
            background-color: #1abc9c;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .news-item a:hover {
            background-color: #2980b9;
        }

        /* Стили для пагинации */
        .pagination {
            text-align: center;
            margin-top: 20px;
        }

        .pagination a, .pagination span {
            display: inline-block;
            padding: 8px 12px;
            margin: 0 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
             text-decoration: none;
            color: #333;
            background-color: #fff;
            transition: background-color 0.3s ease;
        }

        .pagination a:hover {
            background-color: #eee;
        }

        .pagination .current-page {
            background-color: #1abc9c;
            color: white;
            border-color: #1abc9c;
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
            <li><a href="#">Новости</a></li>
            <li><a href="Controller?command=go_to_category_page">Категории</a></li>
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
	<div class="search-bar">
	    <form action="Controller" method="post">
    <input type="hidden" name="command" value="search_news">
    <c:choose>
        <c:when test="${empty param.query}">
            <input type="text" name="query" placeholder="Поиск новостей...">
        </c:when>
        <c:otherwise>
            <input type="text" name="query" value="${param.query}">
        </c:otherwise>
    </c:choose>
    <button type="submit">Поиск</button>
</form>

	</div>

    <div class="news-list">
        <c:forEach var="news" items="${newsList}">
            <div class="news-item">
                <h2><c:out value="${news.title}" /></h2>
                <p><c:out value="${news.brief}" /></p>
                <p>Автор: <c:out value="${news.author}" /></p>
                <a href="Controller?command=go_to_page_news&id=${news.id}">Подробнее</a>
            </div>
        </c:forEach>
    </div>
    <div class="pagination">
    <c:forEach var="i" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${i == currentPage}">
                <span class="current-page">${i}</span>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${empty query}">
                        <a href="Controller?command=go_to_all_news_page&page=${i}">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="Controller?command=search_news&page=${i}&query=${param.query}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>

</main>
<footer>
    <p>© 2024 Новостной Портал. Все права защищены.</p>
    <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
</footer>
</body>
</html>
