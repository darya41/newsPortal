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
.content {
    display: none;
}

.content.active {
    display: block;
}


    body {
    font-family: 'Roboto', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.sidebar {
    width: 200px;
    background-color: #1abc9c;
    color: white;
    padding: 20px;
    position: fixed;
    height: 100%;
}

.sidebar ul {
    list-style: none;
    padding: 0;
}

.sidebar ul li {
    margin: 20px 0;
}

.sidebar ul li a {
    color: white;
    text-decoration: none;
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

#profile {
     display: flex;  
    justify-content: space-between;
}

.profile, .calendar {
    flex: 1;
    margin: 10px;
    background-color: #ffffff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    padding: 20px;
}

.profile {
    width: 55%;
}

.calendar {
    width: 40%;
    height: 70vh;
    margin-right:40px;
}

.stats {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
}

.stats > div {
    flex: 1;
    margin: 10px;
    background-color: #ffffff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    padding: 20px;
}

/* Стили для заголовка */
.fc-toolbar {
    background-color: #f8f9fa;
    border-bottom: 1px solid #dee2e6;
    padding: 10px;
    border-radius: 10px 10px 0 0;
}

.first-item{
margin-left: 40px;
 width: 55%;
    height: 70vh;
}
/* Стили для кнопок */
.fc-button {
    background-color: #007bff;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    padding: 5px 10px;
    margin: 0 5px;
}

.fc-button:hover {
    background-color: #0056b3;
}

/* Стили для заголовка месяца */
.fc-toolbar-title {
    font-size: 1.5em;
    font-weight: bold;
    color: #343a40;
}

/* Дополнительные стили для улучшения внешнего вида */
.edit_profile {
    background-color: #007bff;
    color: white;
    padding: 10px;
    border-radius: 5px;
    text-align: center;
    cursor: pointer;
    margin-top: 10px;
}

.edit_profile:hover {
    background-color: #0056b3;
}
.profile{
 display: flex;
 justify-content: space-between;
 width:90%;
 padding: 0 auto;
}

.profile img {
    border-radius: 50%;
    width: 90%;
    height: 90%;
    object-fit: cover;
    margin-bottom: 10px;
    border-color:black;
}
.profile .content-profile{
	margin-left: 20px;
	width:90%;
}
.profile .content-profile h2 {
    font-size: 1.5em;
    margin: 10px 0;
}

.profile .content-profile p {
    color: #666;
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
                <a href="logout" class="login-button">Выйти</a>
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
            <div class="first-item">
                <div class="profile">
                
                    <img src="profile.jpg" alt="Ирина Рыбина">
                 
                 <div class= "content-profile">
                    <h2>Ирина Рыбина</h2>
                    <p>Руководитель подразделения продаж</p>
                    <div class="edit_profile">Редактировать профиль           ></div>
                    </div>
                </div>
                <div class="stats">
                    <h3>Статистика</h3>
                   
                </div>

             </div>
               
            <div id='calendar'></div>
        </div>
        <div id="bookmarks" class="content">Сохраненные статьи</div>
        <div id="history" class="content">История чтения</div>
        <div id="like" class="content">Отметки "Нравятся"</div>
        <div id="comments" class="content">Комментарии</div>
        <div id="time-spend" class="content">Потраченное время</div>
        <div id="settings" class="content">Настройки</div>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                events: [
                    {
                        title: 'Посещение',
                        start: '2024-11-01',
                        color: '#378006' // Цвет для выделения
                    },
                    {
                        title: 'Посещение',
                        start: '2024-11-05',
                        color: '#378006'
                    },
                    {
                        title: 'Посещение',
                        start: '2024-11-10',
                        color: '#378006'
                    }
                    // Добавьте больше событий по необходимости
                ],
                eventColor: '#378006', // Цвет событий
                themeSystem: 'bootstrap' // Использование темы Bootstrap
            });

            calendar.render();
        });
        </script>
        

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
