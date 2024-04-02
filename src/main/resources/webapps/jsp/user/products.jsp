<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.ankudovich.entity.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Roboto', sans-serif;
            background-color: #f3f4f6;
        }

        .product-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h3 {
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }

        .create-account {
            background-color: #3f93ff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .create-account:hover {
            background-color: #1e78ff;
        }

        .all-products {
            margin-top: 40px;
        }

        .product-card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

        .product-card h4 {
            font-size: 20px;
            font-weight: 700;
            margin: 0 0 10px;
            color: #333;
        }

        .product-card p {
            margin: 0;
            color: #666;
            font-size: 16px;
        }

        .add-to-cart-btn {
            background-color: #4caf50;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .add-to-cart-btn:hover {
            background-color: #43a047;
        }

        input[type="number"] {
            width: 60px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
    </style>
</head>F
<body>
<div class="product-container">
    <h3>User Panel: Products</h3>
    <form method="post" action="http://localhost:8090/TempDz4/products">
        <div>
            <button type="submit" class="create-account">Show All Products</button>
        </div>
    </form>

<%--    <jsp:useBean id="products" scope="request" type="by.ankudovich.entity.Product"/>--%>
    <c:if test="${not empty products}">
        <div class="all-products">
            <h3>All Products</h3>
            <div class="product-grid">
                <c:forEach var="product" items="${products}">
                    <div class="product-card">
                        <h4>ID: ${product.id}</h4>
                        <h4>Code: ${product.codeOfProduct}</h4>
                        <h4>${product.nameOfProduct}</h4>
                        <p>Price: ${product.price}</p>
                        <p>Quantity: ${product.quantity}</p>
                        <form class="add-to-cart-form" method="post" action="http://localhost:8090/TempDz4/basket">
                            <input type="hidden" name="goodId" value="${product.id}">
                            <label for="count">Count:</label>
                            <input type="number" id="count" name="count" min="1" value="1">
                            <button type="submit" class="add-to-cart-btn">В корзину</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>