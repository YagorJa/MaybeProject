<%--@elvariable id="user" type="javax.xml.stream.util.StreamReaderDelegate"--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.ankudovich.entity.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User panel</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f2f4f8;
        }

        .registration-cssave {
            max-width: 800px;
            margin: 50px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        h3 {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-bottom: 30px;
        }

        .welcome-message {
            text-align: center;
            margin-bottom: 30px;
        }

        .welcome-message h1 {
            font-size: 28px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }

        .smiley {
            font-size: 36px;
        }

        .edit-button, .logout-button {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #3f93ff;
            color: #fff;
            text-decoration: none;
            margin-right: 10px;
            transition: background-color 0.3s ease;
        }

        .edit-button:hover, .logout-button:hover {
            background-color: #2a6dbb;
        }

        .create-account {
            display: block;
            width: 100%;
            padding: 15px;
            border: none;
            border-radius: 5px;
            background-color: #3f93ff;
            color: #fff;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            margin-bottom: 20px;
            transition: background-color 0.3s ease;
        }

        .create-account:hover {
            background-color: #2a6dbb;
        }

        .logout-button {
            background-color: #ff5c5c;
        }

        .logout-button:hover {
            background-color: #ff3333;
        }
    </style>
</head>
<body>
<div class="registration-cssave">
    <h3>Your Account</h3>
    <div class="welcome-message">
        <h1>Welcome, ${user.name} ${user.surname}!</h1>
        <div class="smiley">&#128515;</div>
        <form action="${pageContext.request.contextPath}/editProfile" method="post">
            <button type="submit" class="edit-button">Редактировать свои данные</button>
        </form>
    </div>
    <form method="post" action="jsp/user/products.jsp">
        <div>
            <button type="submit" class="create-account">Products</button>
        </div>
    </form>
    <form id="logout-form" method="post" action="http://localhost:8090/TempDz4/user">
        <div>
            <button type="submit" class="create-account logout-button">Log out</button>
        </div>
    </form>
</div>
</body>
</html>