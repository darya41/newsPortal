<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Категории новостей</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
            margin-left: 20px;
        }

        nav {
            display: flex;
            align-items: center;
            justify-content: space-between;
            width: 100%;
            background-color: #333;
            padding: 10px 0;
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

        footer a {
            color: #1abc9c;
        }

        .categories-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .category-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .category-list {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .category-list li {
            font-size: 18px;
            margin-bottom: 10px;
        }

        .category-list li a {
            text-decoration: none;
            color: #333;
        }

        .category-list li a:hover {
            text-decoration: underline;
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
                <li><a href="#">Главная</a></li>
                <li><a href="Controller?command=go_to_all_news_page">Новости</a></li>
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
        <div class="categories-container">
            <div class="category-title">Категории новостей</div>
            <ul class="category-list">
            	<c:forEach var="item" items="${category}">
            	 	<li><a href="Controller?command=go_to_category&category=politics">"$category.title"</a></li>
            	</c:forEach>                            
            </ul>
        </div>
    </main>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>
