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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body, html {
            margin: 0;
            padding: 0;
            background-color: #f3f3f3;
            font-family: Arial, sans-serif;
            height: 100%;
        }

        .admin-panel {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .admin-panel form {
            margin-bottom: 20px;
        }

        .admin-panel .create-account {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .admin-panel .create-account:hover {
            background-color: #45a049;
        }

        .admin-panel .all-users {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 80%;
            max-width: 800px;
        }

        .admin-panel .all-users h3 {
            color: #333;
            font-size: 24px;
            margin-bottom: 10px;
        }

        .admin-panel .all-users ul {
            list-style: none;
            padding: 0;
        }

        .admin-panel .all-users li {
            padding: 10px 0;
            border-bottom: 1px solid #ccc;
        }
    </style>
</head>
<body>
<div class="admin-panel">
    <h3>Admin Panel: Users</h3>
    <form method="post" action="http://localhost:8090/TempDz4/jsp/admin/findUser.jsp">
        <button type="submit" class="create-account">Search User</button>
    </form>
    <form method="post" action="http://localhost:8090/TempDz4/jsp/admin/deleteUser.jsp">
        <button type="submit" class="create-account">Delete User</button>
    </form>
    <form method="post" action="http://localhost:8090/TempDz4/editUsers">
        <button type="submit" class="create-account">Show All Users</button>
    </form>
    <%--@elvariable id="users" type="by"--%>
    <c:if test="${not empty users}">
        <div class="all-users">
            <h3>All Users</h3>
            <ul>
                <c:forEach var="user" items="${users}">
                    <li>ID: ${user.id}, Name: ${user.name}, Surname: ${user.surname}, Login: ${user.login},
                        Password: ${user.password}, Role: ${user.role}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</div>
</body>
</html>
