<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="allProducts" scope="request" type="java.util.List"/>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f0f0f0;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #4606a1;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
            font-size: 2.5em;
            padding: 20px;
            border-radius: 10px;
            background: linear-gradient(45deg, #0533c7, #1fc8db, #2cb5e8);
            margin: 20px auto;
            width: 50%;
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
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            transform: scale(1.02);
            transition: transform .3s ease;
        }
    </style>
</head>
<body>
<h1>Список продуктов</h1>
<table>
    <tr>
        <th>ID товара</th>
        <th>Код товара</th>
        <th>Наименование товара</th>
        <th>Цена товара</th>
        <th>Количество на складе</th>
        <th>Тип продукта</th>
    </tr>



    <jsp:useBean id="allProducts" scope="request" type="java.util.List"/>
    <c:forEach items="${allProducts}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.codeOfProduct}</td>
            <td>${product.nameOfProduct}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.typeOfProduct}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
