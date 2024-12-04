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
   <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.js'></script>

   <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/styleNew.css">
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


    .sidebar {
        width: 200px;
        float: left;
        background-color:#1abc9c;
        padding: 10px;
       padding: 10px;
        min-height: 75vh; 
        height: 100%; /* Растягиваем боковую панель на всю высоту страницы */
        box-sizing: border-box;
        
    }

    .sidebar ul {
        list-style-type: none;
        padding: 0;
    }

    .sidebar ul li {
        margin: 10px 0;
    }

    .sidebar ul li a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
    }

    .main-panel {
        margin-left: 220px;
        padding: 20px;
         
    }

    .content {
        display: none;
    }

    .content.active {
        display: block;
    }

    .profile {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }

    .profile img {
        border-radius: 50%;
        width: 100px;
        height: 100px;
        margin-right: 20px;
         border: 2px solid black; 
    }

    .content-profile {
        flex-grow: 1;
    }

    .content-profile h2 {
        margin: 0;
        font-size: 24px;
    }

    .content-profile p {
        margin: 5px 0;
        color: #666;
    }

    .edit_profile {
        color: #007bff;
        cursor: pointer;
        margin-top: 10px;
    }

    .stats {
        margin-top: 20px;
    }

    .stats h3 {
        margin-bottom: 10px;
    }

    .stats p {
        margin: 5px 0;
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
                <a href="goController?command=log_out" class="login-button">Выйти</a>
            </div>
        </nav>
    </header>
   <main>
    <div class="sidebar">
        <ul>
            <li><a href="#" onclick="showContent('profile')">Профиль</a></li>
            <li><a href="#" onclick="showContent('bookmarks')">Сохраненные новости</a></li>
            <li><a href="#" onclick="showContent('history')">История чтения</a></li>
            <li><a href="#" onclick="showContent('like')">Отметки "Нравятся"</a></li>
            <li><a href="#" onclick="showContent('comments')">Комментарии</a></li>
            <li><a href="#" onclick="showContent('time-spend')">Потраченное время</a></li>
            <li><a href="#" onclick="showContent('settings')">Настройки</a></li>
        </ul>
    </div>
    <div class="main-panel">
        <div id="profile" class="content active">
        <c:if test="${not empty sessionScope.user}">
	            <div class="profile">
	                <img src="profile.jpg" alt="">
	                <div class="content-profile">
	                    <h2><c:out value="${sessionScope.user.username} ${sessionScope.user.lastName}"/></h2>
	                    <c:if test="${sessionScope.user.role=='user'}">
	                    	<p>Пользователь новостного портала</p>
	                    </c:if>
	                    <c:if test="${sessionScope.user.role == 'author'}">
	                    	<p>Автор новостей</p>
	                    </c:if>
	                    <div class="edit_profile">Редактировать профиль ></div>
	                </div>
	            </div>
	            <div class="stats">
	                <h3>Информация о пользователе</h3>
	                <p><strong>Имя:</strong> <c:out value="${sessionScope.user.username}"/></p>
	                <p><strong>Фамилия:</strong> <c:out value="${sessionScope.user.lastName}"/></p>
	                <p><strong>Дата рождения:</strong> 
	                	<c:if test="${ not empty sessionScope.user.dateBirth}">
	                		<c:out value="${sessionScope.user.dateBirth}"/>
	                	</c:if>
	                	<c:if test="${empty sessionScope.user.dateBirth}">
	                		Отсутствует
	                	</c:if>
	                </p>
	                <p><strong>Роль:</strong> 
						<c:if test="${sessionScope.user.role=='user'}">
	                    	Пользователь новостного портала
	                    </c:if>
	                    <c:if test="${sessionScope.user.role == 'author'}">
	                    	Автор новостей
	                    </c:if>
					</p>
	                <p><strong>Электронная почта:</strong><c:out value="${sessionScope.user.email}"/> </p>
	                <p><strong>Номер телефона:</strong> 
	                <c:if test="${ not empty sessionScope.user.phone}">
	                		<c:out value="${sessionScope.user.phone}"/>
	                	</c:if>
	                	<c:if test="${empty sessionScope.user.phone}">
	                		Отсутствует
	                	</c:if>
	                </p>
	            </div>
	            <div class="stats">
	            <br>
	                <h3>Статистика</h3>
	                <p>Количество сохраненных новостей: 10</p>
	                <p>Количество отметок "Нравится": 25</p>
	                <p>Количество комментариев: 15</p>
	            </div>
            </c:if>
        </div>
        <div id="bookmarks" class="content">Сохраненные статьи</div>
        <div id="history" class="content">История чтения</div>
        <div id="like" class="content">Отметки "Нравятся"</div>
        <div id="comments" class="content">Комментарии</div>
        <div id="time-spend" class="content">Потраченное время</div>
        <div id="settings" class="content">Настройки</div>
    </div>
   
        

        <script>
        function showContent(id) {
            var contents = document.querySelectorAll('.content');
            contents.forEach(function(content) {
                content.classList.remove('active');
                content.style.display = 'none'; // Скрываем все элементы
            });
            var activeContent = document.getElementById(id);
            activeContent.classList.add('active');
            activeContent.style.display = 'block'; // Показываем выбранный элемент
        }
   

    </script>
</main>

    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>
