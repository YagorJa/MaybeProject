<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список пользователей</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap');
        body {
            font-family: 'Montserrat', sans-serif;
            background: linear-gradient(45deg, #5b247a, #1bcedf);
            color: #e1e1e1;
        }
        h1 {
            text-align: center;
            color: #0f3460;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
            font-size: 2.5em;
            padding: 20px;
            border-radius: 10px;
            background: linear-gradient(45deg, #ff9a9e, #fad0c4, #da4014);
            margin: 20px auto;
            width: 50%;
            animation: gradient 5s ease infinite;
        }
        @keyframes gradient {
            0% {background-position: 0% 50%;}
            50% {background-position: 100% 50%;}
            100% {background-position: 0% 50%;}
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            box-shadow: 0 0 20px rgba(0,0,0,0.15);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background-color: #1fc8db;
            color: #1346a6;
        }
        tr:nth-child(even) {
            background-color: #ac53d0;
        }
        tr:hover {
            transform: scale(1.02);
            transition: transform .3s ease;
        }
    </style>
</head>
<body>
<h1>Список пользователей</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Роль</th>
    </tr>


    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
