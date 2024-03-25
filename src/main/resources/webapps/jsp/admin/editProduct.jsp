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
    <style>
        body, html {
            margin: 0;
            padding: 0;
            background-color: #f3f4f6;
            font-family: Arial, sans-serif;
            height: 100%;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            padding: 20px;
        }

        .form-container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            margin-bottom: 20px;
            max-width: 400px;
            width: 100%;
        }

        .form-container h3 {
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center;
        }

        .form-container button {
            background-color: #3f93ff;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            margin-top: 10px;
            width: 100%;
        }

        .form-container button:hover {
            background-color: #2a6dbb;
        }

        .all-products {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-top: 20px;
            max-width: 800px;
            width: 100%;
        }

        .all-products h3 {
            font-weight: bold;
            margin-bottom: 20px;
        }

        .all-products ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .all-products li {
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            background-color: #f1f5f8;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <h3>Admin Panel: Products</h3>
        <form method="post" action="http://localhost:8090/TempDz4/jsp/admin/findProduct.jsp">
            <button type="submit">Find Product</button>
        </form>
        <form method="post" action="http://localhost:8090/TempDz4/jsp/admin/deleteProduct.jsp">
            <button type="submit">Delete Product</button>
        </form>
        <form method="post" action="http://localhost:8090/TempDz4/jsp/admin/addProduct.jsp">
            <button type="submit">Add New Product</button>
        </form>
        <form method="post" action="http://localhost:8090/TempDz4/jsp/products/displayProducts.jsp">
            <button type="submit">Show All Products</button>
        </form>
    </div>

    <c:if test="${not empty products}">
        <div class="all-products">
            <h3>All Products</h3>
            <ul>
                <c:forEach var="product" items="${products}">
                    <li>ID: ${product.id}, Name: ${product.name}, Type: ${product.type}, Price: ${product.price},
                        Quantity: ${product.quantity}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</div>
</body>
</html>
