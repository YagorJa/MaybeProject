<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.ankudovich.entity.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin panel</title>
    <style>
        :root {
            --primary-color: #4CAF50;
            --secondary-color: #008CBA;
            --danger-color: #f44336;
            --text-color: #ffffff;
        }

        body, html {
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100%;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        h3 {
            margin-bottom: 20px;
        }

        .button {
            border: none;
            color: var(--text-color);
            text-align: center;
            display: inline-block;
            transition-duration: 0.4s;
            cursor: pointer;
            padding: 15px 32px;
            text-decoration: none;
            margin: 4px 2px;
            font-size: 16px;
        }

        .button-primary {
            background-color: var(--primary-color);
        }

        .button-primary:hover {
            background-color: var(--text-color);
            color: var(--primary-color);
        }

        .button-secondary {
            background-color: var(--secondary-color);
        }

        .button-secondary:hover {
            background-color: var(--text-color);
            color: var(--secondary-color);
        }

        .button-danger {
            background-color: var(--danger-color);
        }

        .button-danger:hover {
            background-color: var(--text-color);
            color: var(--danger-color);
        }
    </style>
</head>
<body>
<h3>Панель админа</h3>
<form method="post" action="jsp/admin/editUser.jsp">
    <button type="submit" class="button button-primary">Редактировать пользователей</button>
</form>
<form method="post" action="jsp/admin/editProduct.jsp">
    <button type="submit" class="button button-secondary">Редактировать продукты</button>
</form>
<form id="logout-form" method="post" action="http://localhost:8090/TempDz4/admin">
    <button type="submit" class="button button-danger">Выйти</button>
</form>
</body>
</html>
