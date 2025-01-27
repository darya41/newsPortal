<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Заявка принята</title>
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
        main {
            padding: 20px;
            text-align: center;
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #1abc9c;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .content-section {
            margin-top: 20px;
            text-align: left;
        }
        .content-section h3 {
            color: #333;
        }
        .content-section ul {
            list-style: none;
            padding: 0;
        }
        .content-section ul li {
            margin-bottom: 10px;
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
                <a href="goToAuto" class="login-button">Войти</a>
            </div>
        </nav>
    </header>
    <main>
        <h2>Заявка успешно принята!</h2>
        <p>Спасибо за вашу заявку. Мы свяжемся с вами после её рассмотрения администратором. Пожалуйста, ожидайте подтверждения.</p>
        <a href="index.html" class="back-button">Вернуться на главную страницу</a>

        <div class="content-section">
            <h3>Рекомендованные статьи:</h3>
            <ul>
                <li><a href="#">Как писать увлекательные статьи</a></li>
                <li><a href="#">Советы по улучшению стиля письма</a></li>
                <li><a href="#">Последние новости в мире журналистики</a></li>
            </ul>
        </div>

        <div class="content-section">
            <h3>Полезные ресурсы:</h3>
            <ul>
                <li><a href="#">Инструменты для проверки грамматики</a></li>
                <li><a href="#">Сайты с бесплатными изображениями</a></li>
                <li><a href="#">Руководства по написанию статей</a></li>
            </ul>
        </div>
    </main>
    <footer>
        <p>© 2024 Новостной Портал. Все права защищены.</p>
        <p><a href="#">Политика Конфиденциальности</a> | <a href="#">Условия Использования</a></p>
    </footer>
</body>
</html>
