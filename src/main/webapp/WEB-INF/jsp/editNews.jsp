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
<title>Редактирование новости</title>
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
footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 10px 0;
	margin-top:40px;
}
footer a{
 color: #1abc9c;
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

.edit-news { 
	padding: 20px; 
	background-color: #fff; 
	border-radius: 5px; 
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
	 margin: 20px auto; 
	} 
.edit-news h1 { 
	text-align: center; 
	color: #333; 
	} 
	main{
	text-align:center;
	width: 80%; 
	margin:10px auto;
	}
.edit-news form { 

	display: flex; 
	flex-direction: column; 
	background-color: #fff; 
	border-radius: 5px; 
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
	
	
	
	} 
.edit-news label { 
	margin-bottom: 5px; 
	font-weight: bold; 
	} 
.edit-news input[type="text"], 
.edit-news input[type="datetime-local"], 
.edit-news input[type="number"], 
.edit-news textarea { 
	padding: 10px; 
	margin-bottom: 15px; 
	border: 1px solid #ddd; 
	border-radius: 5px; 
	width: 100%; 
	box-sizing: border-box; 
	} 
.edit-news button[type="submit"] { 
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
.edit-news button[type="submit"]:hover { 
	background-color: #005bb5; 
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
    <h1>Редактирование Новости</h1>
    <form action="goController" method="post" class="edit-news">
        <input type="hidden" name="command" value="edit_news">
        <input type="hidden" name="id" value="${news.id}">
        <br><br>

        <label for="title">Заголовок:</label>
        <br>
        <input type="text" id="title" name="title" value="${news.title}" required>
		<br><br>
		
        <label for="brief">Краткое описание:</label>
        <br>
        <textarea id="brief" name="brief" required>${news.brief}</textarea>
		<br><br>
		
        <label for="content">Содержание:</label>
        <br>
        <textarea id="content" name="content" required>${news.content}</textarea>
		<br><br>
		
        <label for="author">Автор:</label>
        <br>
        <input type="text" id="author" name="author" value="${news.author}" required>
		<br><br>
		
        
        <label for="idCategory">Категория:</label>
        <br>
       <select id="idCategory" name="idCategory" required> 
       		<c:forEach var="category" items="${categories}"> 
       			<option value="${category.id}" <c:if test="${category.id == news.id}">selected</c:if>>${category.name}
       			</option> 
       		</c:forEach> 
       </select>
		<br><br>
		
        <label for="priority">Приоритет:</label>
        <br>
        <input type="number" id="priority" name="priority" value="${news.priority}" required>
		<br><br>
		
        <button type="submit" >Сохранить</button>
    </form>
    </main>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>

