<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Шестая лабораторка</title>
    <link href="${pageContext.request.contextPath}/static/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="#">Лабораторная работа №6</a>
</nav>
<div class="container-fluid">
    <div class="card">
        <div class="card-header">
            <div class="card-title h2">
                Войдите в систему
            </div>
        </div>
        <div class="card-body">
            <%if (request.getAttribute("error") != null) {%>
            <div class="alert alert-danger" role="alert">
                Логин или пароль введены неверно
            </div>
            <%} %>
            <form method="post" action="${pageContext.request.contextPath}/">
                <div class="form-group">
                    <label for="login">Логин</label>
                    <input autofocus class="form-control" id="login" name="login"
                           placeholder="Введите логин здесь..." required>
                </div>
                <div class="form-group">
                    <label for="password">Пароль</label>
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Введите пароль здесь..." required>
                </div>
                <div class="btn-group-vertical" role="group">
                    <button class="btn btn-success" type="submit">
                        Войти
                    </button>
                    <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/signUp">
                        Регистрация
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>