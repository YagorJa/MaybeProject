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
            background-color: #0cce26;
            background-blend-mode: overlay;
            display: flex;
            align-items: center;
            justify-content: center;
            background-repeat: no-repeat;
            background-size: cover;
            height: 100%;
        }

        body {
            background-color: transparent;
        }

        .registration-cssave {
            padding: 50px 0;
        }

        .registration-cssave form {
            max-width: 800px;
            padding: 50px 70px;
            border-radius: 10px;
            box-shadow: 4px 4px 15px rgba(0, 0, 0, 0.2);
            background-color: #fff;
        }

        .registration-cssave form h3 {
            font-weight: bold;
            margin-bottom: 30px;
        }

        .registration-cssave form label {
            display: flex;
            flex-direction: column;
            margin-bottom: 25px;
        }

        .registration-cssave form label > span {
            margin-bottom: 5px;
        }

        .registration-cssave .item {
            border-radius: 10px;
            padding: 10px 20px;
            width: 100%;
            box-sizing: border-box;
        }

        .registration-cssave .create-account {
            border-radius: 30px;
            padding: 10px 20px;
            font-size: 18px;
            font-weight: bold;
            background-color: #3f93ff;
            border: none;
            color: white;
            margin-top: 20px;
        }

        @media (max-width: 576px) {
            .registration-cssave form {
                padding: 50px 20px;
            }
        }

        .registration-cssave .create-account:hover {
            background-color: #2a6dbb;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="registration-cssave">
    <form method="post" action="http://localhost:8090/TempDz4/deleteuser">
        <h3>Delete User</h3>
        <div>
            <label>
                <span>User ID:</span>
                <input class="form-control item" type="text" name="deleteUser" placeholder="DeleteUserId"
                       required>
            </label>
        </div>
        <button class="btn btn-primary btn-block create-account" type="submit" name="action" value="delete">Delete
            User
        </button>
    </form>
    <c:if test="${not empty message}">
        <div class="success-message">${message}</div>
    </c:if>
</div>
</body>
</html>