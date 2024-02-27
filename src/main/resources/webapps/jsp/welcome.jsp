<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<%@ page import="by.ankudovich.entity.User.*" %>--%>
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
</div>
</body>
</html>
