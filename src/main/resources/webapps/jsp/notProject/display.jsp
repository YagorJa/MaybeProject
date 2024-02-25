<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список пользователей</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #5f8172;
        }
    </style>
</head>
<body>
<h1>Список пользователей</h1>
<table>
    <tr>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    ${allUsers}

    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
