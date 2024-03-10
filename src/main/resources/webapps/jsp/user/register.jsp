<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/jsp">
    <style>
        body {
            background-color: #2c2c2c;
            color: white;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 400px;
            margin: auto;
        }

        img {
            width: 100px;
            display: block;
            margin: auto;
        }

        input[type=text], input[type=password] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
        }

        button {
            padding: 10px 20px;
            background-color:#d8363a;
            border:none;
            color:white;
            cursor:pointer
        }

        button:hover {background-color:#ee7724}

        .create-new {
            text-align:center;
            display:block;
            margin-top:10px;
            color:white
        }
    </style>
</head>
<body>

<div class="container">
    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp" alt="logo">
    <h4>Зарегистрировать пользователя</h4>

    <form method="post" action="http://localhost:8090/TempDz4/registr">
        Введите логин<br>
        <input type="text" name="login" required><br>

        Введите пароль<br>
        <input type="password" name="password" required><br><br>

        Введите имя<br>
        <input type="text" name="name" required><br>

        Введите фамилию<br>
        <input type="text" name="surname" required><br><br>

        <button type="submit">Зарегистрировать</button><br><br>
    </form>

</div>

<script>
    document.querySelector('.create-new').addEventListener('click', function() {
        window.location.href = '/jsp/login.jsp';
    });
</script>


</body>
</html>
