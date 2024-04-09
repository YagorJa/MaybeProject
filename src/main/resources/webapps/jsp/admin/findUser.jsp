<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.ankudovich.entity.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #f4f4f4;
        }

        .registration-cssave {
            width: 80%;
            max-width: 500px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h3 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            font-weight: bold;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            display: block;
            width: 100%;
            background-color: #f44336;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-bottom: 10px;
        }

        button:hover {
            background-color: #d32f2f;
        }

        .success-message {
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="registration-cssave">
    <form method="post" action="http://localhost:8090/TempDz4/finduser">
        <h3>Find User</h3>
        <div>
            <label>
                <span>Login:</span>
                <input class="form-control item" type="text" name="userLogin" placeholder="UserLogin">
            </label>
        </div>
        <div>
            <label>
                <span>ID:</span>
                <input class="form-control item" type="text" name="userId" placeholder="UserId">
            </label>
        </div>
        <button class="btn btn-primary btn-block create-account" type="submit" name="action" value="search">Search
        </button>
    </form>
    <c:if test="${not empty user}">
        <h3>User Details</h3>
        <p>ID: ${user.id}</p>
        <p>Name: ${user.name}</p>
        <p>Surname: ${user.surname}</p>
<%--        <p>Role: ${user.role}</p>--%>
        <p>Login: ${user.login}</p>
        <p>Password: ${user.password}</p>
    </c:if>
    <c:if test="${not empty searchResult}">
        <p>${searchResult}</p>
    </c:if>
</div>
</body>
</html>
