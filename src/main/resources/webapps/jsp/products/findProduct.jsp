<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Поиск товара</title>
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
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            border: none;
            color: #fff;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .result {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Поиск товара</h2>
    <form action="search" method="get">
        <label for="productId">Введите ID товара:</label>
        <input type="text" id="productId" name="productId" required>
        <button type="submit">Поиск</button>
    </form>
    <div class="result">
        <%-- Здесь будет отображаться результат поиска --%>
    </div>
</div>
</body>
</html>
