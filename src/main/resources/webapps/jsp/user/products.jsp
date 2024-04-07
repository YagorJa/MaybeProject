<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.ankudovich.entity.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders</title>
    <style>
        :root {
            --primary-color: #2F80ED;
            --secondary-color: #333333;
            --background-color: #F2F2F2;
            --white: #FFFFFF;
            --black: #000000;
        }

        body, html {
            margin: 0;
            padding: 0;
            background-color: var(--background-color);
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100%;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 800px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
            background-color: var(--white);
        }

        h2 {
            font-weight: bold;
            margin-bottom: 20px;
            color: var(--primary-color);
        }

        .product-card {
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin-bottom: 20px;
            background-color: var(--white);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .product-card h4 {
            margin: 0;
            font-size: 16px;
            color: var(--primary-color);
        }

        .product-card p {
            margin: 5px 0;
            font-size: 14px;
            color: var(--secondary-color);
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 15px;
            background-color: var(--primary-color);
            color: var(--white);
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: darkblue(var(--primary-color), 10%);
        }
    </style>
</head>
<body>
<div class="container">
    <form method="post" action="http://localhost:8090/TempDz4/products">
        <h2>Товары</h2>

        <c:if test="${not empty products}">
            <div class="product-grid">
                <c:forEach var="product" items="${products}">
                    <div class="product-card">
                        <h4>ID: ${product.id}</h4>
                        <h4>Code: ${product.codeOfProduct}</h4>
                        <h4>${product.nameOfProduct}</h4>
                        <p>Price: ${product.price}</p>
                        <p>Quantity: ${product.quantity}</p>
                    </div>
                </c:forEach>
            </div>
        </c:if>

        <button type="submit" class="show-products" name="showproducts">Показать все товары</button>

        <h2>Добавить в корзину</h2>
        <label for="idProduct">ID товара:</label>
        <input type="text" name="idProduct" placeholder="ID">
        <label for="ProductCount">Количество:</label>
        <input type="text" name="ProductCount" placeholder="Количество">
        <button type="submit" name="addProductByBasket">Добавить в корзину</button>
    </form>

    <form method="post" action="http://localhost:8090/TempDz4/basket">
        <button type="submit" name="basket">Перейти в корзину</button>
    </form>
</div>
</body>
</html>
