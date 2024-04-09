<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.ankudovich.entity.*" %>
<html>
<head>
    <title>Корзина товаров</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #f5f5f5;
        }

        .basket form {
            max-width: 800px;
            padding: 50px 70px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        .basket form h2 {
            font-weight: 500;
            margin-bottom: 30px;
            color: #333;
        }

        .product-cards {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .product-card {
            width: 200px;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: #f8f8f8;
        }

        .product-card h4 {
            margin: 0;
            color: #333;
        }

        .product-card p {
            margin: 5px 0;
            font-size: 14px;
            color: #666;
        }

        button[type="submit"] {
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            background-color: #007BFF;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<main class="basket">
    <form method="post" action="http://localhost:8090/TempDz4/basket">
        <h2>Корзина товаров</h2>
        <div class="product-cards">
            <c:forEach var="product" items="${orders.products}">
                <article class="product-card">
                    <h4>${product.nameOfProduct}</h4>
                    <p>${product.typeOfProduct}</p>
                    <p>Цена: ${product.price}</p>
                </article>
            </c:forEach>
        </div>
        <div>
            <h2>Статус заказа:</h2>
            <p>${orderStatus}</p>
        </div>
        <button type="submit" name="makeOrder">Оформить</button>
        <button type="submit" name="cleanBasket">Удалить все</button>
    </form>
</main>
</body>
</html>
