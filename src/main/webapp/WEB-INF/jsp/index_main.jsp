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
    <link rel="stylesheet" href=".\css\style.css">
    <title>Главная страница</title>
    
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

.more-btn,.edit-btn,.delete-btn {
    background-color: #1abc9c;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    text-align: center;
    display: inline-block;
    margin-top: 10px;
    width:80%;
}

.more-btn:hover,.edit-btn:hover,.delete-btn:hover {
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
.modal { display: none; position: fixed; z-index: 1000; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgb(0,0,0); background-color: rgba(0,0,0,0.4); } .modal-content { background-color: #fefefe; margin: 15% auto; padding: 20px; border: 1px solid #888; width: 80%; max-width: 500px; text-align: center; } .close { color: #aaa; float: right; font-size: 28px; font-weight: bold; } .close:hover, .close:focus { color: black; text-decoration: none; cursor: pointer; } .confirm-btn, .cancel-btn { padding: 10px 20px; margin: 10px; border: none; cursor: pointer; } .confirm-btn { background-color: #e74c3c; color: white; } .cancel-btn { background-color: #1abc9c; color: white; }
	
.logo-a{
	color:white;
}
.errorM{
color:red;
}
}
  </style>
     <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  
</head>
<body>
    <header>
        <div class="logo">
    		<a class="logo-a" href="#">Новостной Портал</a>
    	</div>
        <nav>
            <ul class="menu">
                <li><a href="#">Главная</a></li>
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
        <section class="hero">
        	<c:choose>
		    	<c:when test="${not empty sessionScope.user}">
		    		<c:if test="${sessionScope.user.role == 'user' }">
                      <h1> ${sessionScope.user.username} добро пожаловать на наш Новостной Портал!</h1>
                      
		        		<p>Последние новости и обновления</p>
                  </c:if>
		        	
		    	</c:when>
		    	<c:otherwise>
		        	<h1> Добро пожаловать на наш Новостной Портал!</h1>
            		<p>Последние новости и обновления</p>
            		
		   		 </c:otherwise>
			</c:choose>
			
			<c:if test="${sessionScope.user.role == 'admin'}">
    			<section class="admin-panel">
        		<h2>Панель администратора</h2>
        		<p>Здесь вы можете управлять пользователями и контентом.</p>
        		<!-- Добавьте ссылки на страницы управления -->
    			</section>
			</c:if>
			
			<c:if test="${sessionScope.user.role == 'author'}">
    			<section class="author-panel">
        		<h2>Панель автора</h2>
        		<c:set var="fullName" value=" ${user.username} ${user.lastName}" />
        		<h3>${user.username} ${user.lastName}</h3>
        		<p>Здесь вы можете создавать и редактировать свои новости.</p>
       		 	<button class="more-btn" onclick="window.location.href='goController?command=go_to_add_news_page'">Добавить новость</button>
    			</section>
			</c:if>
			
			<c:if test="${not empty errorMessage}">
                 <p class="errorM" style="color=red;">${errorMessage}</p>
            </c:if>
			
			           
        </section>
        <section class="slider">	
    <h2>Главные Новости</h2>
    <div class="carousel">
        <c:forEach var="item" items="${mainNews}">
            <div class="slide">
                <h3><c:out value="${item.title}" /></h3>
                <p><c:out value="${item.brief}" /></p>
                <p>Автор: <c:out value="${item.author}" /></p>
                 <c:if test="${not empty sessionScope.user}">
                	<button class="more-btn" onclick="window.location.href='goController?command=go_to_page_news&id=${item.id}'">Подробнее</button>
                 </c:if>
                 <c:if test="${empty sessionScope.user}">                
                 	<button class="more-btn" onclick="window.location.href='goController?command=no_auth'">Подробнее</button>
                </c:if>
                
                <c:if test="${not empty sessionScope.user}">
                    <c:set var="user" value="${sessionScope.user}" />
                     <c:if test="${not empty user.lastName}">
                    <c:set var="fullName" value="${user.username} ${user.lastName}" />
                    <c:choose>
                        <c:when test="${(fullName == item.author && user.role == 'author')}">
    						<button class="edit-btn" onclick="window.location.href='Controller?command=go_to_edit_news&id=${item.id}'">Редактировать</button>
    						<button class="delete-btn" onclick="showModal(${item.id}, '${item.title}')">Удалить</button>
						</c:when>

                    </c:choose>
                    </c:if>
               
                <c:choose>
                          <c:when test="${user.role == 'admin'}">
    						<button class="edit-btn" onclick="window.location.href='Controller?command=go_to_edit_news&id=${item.id}'">Редактировать</button>
    						<button class="delete-btn" onclick="showModal(${item.id}, '${item.title}')">Удалить</button>
						</c:when>
                    </c:choose>
                     </c:if>
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
                <p>Автор: <c:out value="${last.author}" /></p>
                 <c:if test="${not empty sessionScope.user}">
                	<button class="more-btn" onclick="window.location.href='Controller?command=go_to_page_news&id=${last.id}'">Подробнее</button>
                 </c:if>
                 <c:if test="${empty sessionScope.user}">                
                 	<button class="more-btn" onclick="window.location.href='Controller?command=no_auth'">Подробнее</button>
                </c:if>
                
                <c:if test="${not empty sessionScope.user}">
                    <c:set var="user" value="${sessionScope.user}" />
                     <c:if test="${not empty user.lastName}">
                    <c:set var="fullName" value="${user.username} ${user.lastName}" />
                    <c:choose>
                       <c:when test="${(fullName == last.author && user.role == 'author')}">
    						<button class="edit-btn" onclick="window.location.href='Controller?command=go_to_edit_news&id=${last.id}'">Редактировать</button>
    						<button class="delete-btn" onclick="showModal(${last.id}, '${last.title}')">Удалить</button>
						</c:when>
                    </c:choose>
                    </c:if>
               
                <c:choose>
                        <c:when test="${user.role == 'admin'}">
                           <button class="edit-btn" onclick="window.location.href='Controller?command=go_to_edit_news&id=${last.id}'">Редактировать</button>
    						<button class="delete-btn" onclick="showModal(${last.id}, '${last.title}')">Удалить</button>
                        </c:when>
                    </c:choose>
                     </c:if>
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
                    <p>Автор: <c:out value="${item.author}" /></p>
                     <c:if test="${not empty sessionScope.user}">
                	<button class="more-btn" onclick="window.location.href='goController?command=go_to_page_news&id=${item.id}'">Подробнее</button>
                 </c:if>
                 <c:if test="${empty sessionScope.user}">                
                 	<button class="more-btn" onclick="window.location.href='goController?command=no_auth'">Подробнее</button>
                </c:if>
                
                    <c:if test="${not empty sessionScope.user}">
                    <c:set var="user" value="${sessionScope.user}" />
                     <c:if test="${not empty user.lastName}">
                    <c:set var="fullName" value="${user.username} ${user.lastName}" />
                    <c:choose>
                        <c:when test="${(fullName == item.author && user.role == 'author')}">
                            <button class="edit-btn" onclick="window.location.href='Controller?command=go_to_edit_news&id=${item.id}'">Редактировать</button>
    						<button class="delete-btn" onclick="showModal(${item.id}, '${item.title}')">Удалить</button>
                        </c:when>
                    </c:choose>
                    </c:if>
               
                <c:choose>
                        <c:when test="${user.role == 'admin'}">
                           <button class="edit-btn" onclick="window.location.href='Controller?command=go_to_edit_news&id=${item.id}'">Редактировать</button>
    						<button class="delete-btn" onclick="showModal(${item.id}, '${item.title}')">Удалить</button>
                        </c:when>
                    </c:choose>
                     </c:if>
                </div>
            </li>
        </c:forEach>
    </ul>
</section>

        <c:if test="${not empty sessionScope.user}">
        	<c:if test="${sessionScope.user.role == 'user' && sessionScope.user.role == 'author' }">
            <section class="exclusive-news">
                <h2>Новости по вашим интересам</h2>
                <article>
                    <h3>Заголовок  Новости 1</h3>
                    <p>Краткое описание  новости...</p>
                </article>
            </section>
        	</c:if>
         </c:if>
         <div id="deleteModal" class="modal"> <div class="modal-content"> <span class="close" onclick="closeModal()">&times;</span> <h2>Подтверждение удаления</h2> <p id="modalMessage">Точно ли хотите удалить эту новость?</p> <button class="confirm-btn" onclick="confirmDelete()">Удалить</button> <button class="cancel-btn" onclick="closeModal()">Отмена</button> </div> </div>
    <script> let newsIdToDelete; function showModal(newsId, newsTitle) { newsIdToDelete = newsId; document.getElementById('modalMessage').innerText = "Точно ли хотите удалить эту новость?\n" + newsTitle; document.getElementById('deleteModal').style.display = 'block'; } function closeModal() { document.getElementById('deleteModal').style.display = 'none'; } function confirmDelete() { window.location.href = 'Controller?command=delete_news&id=' + newsIdToDelete; } </script>
    </main>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body> 

</html>
