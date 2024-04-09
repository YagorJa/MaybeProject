<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Удаление товара</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            color: #444;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .registration-cssave {
            width: 80%;
            max-width: 500px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h3 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            font-weight: bold;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            display: block;
            width: 100%;
            background-color: #f44336;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-bottom: 10px;
        }

        button:hover {
            background-color: #d32f2f;
        }

        .success-message {
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="registration-cssave">
    <form method="post" action="http://localhost:8090/TempDz4/deleteProduct">
        <h3>Delete Product</h3>
        <div>
            <label>
                <span>Product ID:</span>
                <input class="form-control item" type="text" name="deleteProductId" placeholder="DeleteProductId"
                       required>
            </label>
        </div>
        <button class="btn btn-primary btn-block create-account" type="submit" name="action" value="delete">Delete
            Product
        </button>
    </form>
  
    <c:if test="${not empty message}">
        <div class="success-message">${message}</div>
    </c:if>
</div>
</body>
</html>
