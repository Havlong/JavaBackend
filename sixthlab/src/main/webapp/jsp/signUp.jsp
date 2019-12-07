<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Шестая лабораторка</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Лабораторная работа №6</a>
</nav>
<div class="container-fluid">
    <div class="card">
        <div class="card-header">
            <div class="card-title h2">
                Регистрация в системе:
            </div>
        </div>
        <div class="card-body">
            <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger" role="alert">
                ${alert}
            </div>
            <% } %>
            <form method="post" action="${pageContext.request.contextPath}/signUp">
                <div class="form-group">
                    <label for="userName">Логин</label>
                    <input autofocus class="form-control" id="userName" name="userName"
                           placeholder="Введите логин здесь..." required>
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Введите пароль здесь..." required>
                </div>
                <div class="form-group">
                    <label for="firstName">Имя</label>
                    <input class="form-control" id="firstName" name="firstName"
                           placeholder="Введите своё имя здесь..." required>
                </div>
                <div class="form-group">
                    <label for="lastName">Фамилия</label>
                    <input class="form-control" id="lastName" name="lastName"
                           placeholder="Введите свою фамилию здесь..." required>
                </div>
                <div class="form-group">
                    <label for="car">Машина</label>
                    <input class="form-control" id="car" name="car"
                           placeholder="Введите марку автомобиля здесь..." required>
                </div>
                <button class="btn btn-success" type="submit">
                    Регистрация
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>