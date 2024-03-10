<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.ankudovich.entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f0f0f0;
        }

        .welcome-message {
            text-align: center;
        }

        .smiley {
            font-size: 100px;
        }
    </style>
</head>
<body>
<div class="welcome-message">
    <h1>Welcome, ${user.name} ${user.surname}!</h1>
    <div class="smiley">&#128515;</div>
    <a href="${pageContext.request.contextPath}/editProfile" class="edit-button">Редактировать свои данные</a>
    <%-- короче тут изза того что у меня тег <a> без явного указания метода
      используется метод GET по дефолту типо. Поэтому, для обработки GET-запросов в моей сервлете редактирования профиля
      EditProfileServlet, я должен явно указать метод doGet(), чтобы обработать GET-запросы и открыть форму редактирования профиля.
      а вот уже на самой форме я использую метод пост для работы с данными и само собой должен определить его в сервлетике
     --%>
</div>
</body>
</html>
