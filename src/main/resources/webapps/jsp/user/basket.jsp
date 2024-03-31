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
            background: #51d211;
            background-blend-mode: overlay;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .basket form {
            max-width: 800px;
            padding: 50px 70px;
            border-radius: 10px;
            box-shadow: 4px 4px 15px rgba(0, 0, 0, 0.2);
            background-color: #fff;
        }

        .basket form h3 {
            font-weight: bold;
            margin-bottom: 30px;
        }

        .basket form label {
            display: flex;
            flex-direction: column;
            margin-bottom: 25px;
        }

        @media (max-width: 576px) {
            .basket form {
                padding: 50px 20px;
            }
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
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #7c7676;
        }

        .product-card h4 {
            margin: 0;
        }

        .product-card p {
            margin: 5px 0;
            font-size: 14px;
            color: #555;
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
                    <h4>${product.name}</h4>
                    <p>${product.type}</p>
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
