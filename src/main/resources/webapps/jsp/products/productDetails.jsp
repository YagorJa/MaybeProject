<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Информация о товаре</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .product-info {
            margin-top: 20px;
        }
        .product-info label {
            font-weight: bold;
        }
        .product-info p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Информация о товаре</h2>
    <div class="product-info">
        <label>ID товара:</label>
        <p><c:out value="${product.id}" /></p>
        <label>Код товара:</label>
        <p><c:out value="${product.codeOfProduct}" /></p>
        <label>Наименование товара:</label>
        <p><c:out value="${product.nameOfProduct}" /></p>
        <label>Цена товара:</label>
        <p>
            <c:out value="${product.price}" /></p>
        <label>Количество на складе:</label>
        <p>
        <c:out value="${product.quantity}" /></p>
        <label>Тип продукта:</label>
        <p><%--@elvariable id="product" type="by.ankudovich.entity.Product"--%>
            <c:out value="${product.typeOfProduct}" /></p>
    </div>
</div>
</body>
</html>
