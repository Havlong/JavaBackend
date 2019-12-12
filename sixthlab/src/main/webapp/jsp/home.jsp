<%@ page import="ru.pnzgu.models.User" %>
<%@ page import="java.util.List" %>
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
    <form class="form-inline" method="get" action="${pageContext.request.contextPath}/logout">
        <button class="btn btn-danger my-2 my-sm-0" type="submit">Logout</button>
    </form>
</nav>
<div class="container-fluid">
    <div class="card">
        <div class="card-header">
            <div class="card-title h2">
                Пользователи системы:
            </div>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Логин</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Машина</th>
                </tr>
                </thead>
                <tbody>
                <%if (request.getAttribute("usersFromServer") != null) {%>
                <%List<User> userList = (List<User>) request.getAttribute("usersFromServer");%>
                <%for (int i = 0; i < userList.size(); ++i) {%>
                <tr>
                    <% User user = userList.get(i); %>
                    <th scope="row"><%=(i + 1)%>
                    </th>
                    <td>
                        <%=user.getUserName()%>
                    </td>
                    <td>
                        <%=user.getName()%>
                    </td>
                    <td>
                        <%=user.getSurname()%>
                    </td>
                    <td>
                        <%=user.getCar()%>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>