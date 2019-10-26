<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Пятая лабораторка</title>
    <link href="/fifth-lab-1.0/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<header>
    <div id="headerInside">
        <div id="logo">
            <img alt="Бригада №5"
                 src="/fifth-lab-1.0/images/logo.png"/>
        </div>

        <div id="name">
            <h1>
                Бригада № 5
            </h1>
            <h3>
                Специально для Основ Web-программирования
            </h3>
            <h3>
                Группа 18ВП2
            </h3>
        </div>
    </div>
</header>
<hr color="yellow" size="5">
<div id="content">
    <div>
        <h2>Состав бригады:</h2>
        <ul>
            <li>
                <h3>
                    Гришин Евгений
                </h3>
            </li>
            <li>
                <h3>
                    Николин Роман
                </h3>
            </li>
        </ul>
    </div>
</div>
<footer>
    <div><h3>Время сервера: ${serverTime}</h3></div>
    <div><h3>Текущее количество посещений: ${visitsCount}</h3></div>
</footer>
</body>
</html>