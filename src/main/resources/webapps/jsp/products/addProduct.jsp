<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Добавление товара</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #d90b0b;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            background-color: #15a163;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #0533c7;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Добавление товара</h1>
    <form action="AddProductServlet" method="post">
        <label for="id">ID товара:</label><br>
        <input type="text" id="id" name="id"><br>

        <label for="code">Код товара:</label><br>
        <input type="text" id="code" name="code"><br>

        <label for="name">Наименование товара:</label><br>
        <input type="text" id="name" name="name"><br>

        <label for="price">Стоимость товара:</label><br>
        <input type="text" id="price" name="price"><br>

        <label for="quantity">Количество на складе:</label><br>
        <input type="text" id="quantity" name="quantity"><br><br>

        <input type="submit" value="Добавить товар">
    </form>
</div>
</body>
</html>
