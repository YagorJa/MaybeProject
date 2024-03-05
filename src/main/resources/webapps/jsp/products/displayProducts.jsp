<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список продуктов</title>
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
<h1>Список продуктов</h1>
<table>
    <tr>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    ${allProducts}

    <c:forEach items="${allProducts}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.codeOfProduct}</td>
            <td>${product.price}</td>
            <td>${product.surname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
