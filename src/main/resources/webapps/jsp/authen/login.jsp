<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
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
    <h4>We are The Lotus Team</h4>

    <form action="http://localhost:8090/TempDz4/login" method="post">
        Please login to your account<br><br>

        Username<br>
        <input type="text" name="login" placeholder=""><br>

        Password<br>
        <input type="password" name="password" placeholder=""><br><br>

        <button type="submit">LOG IN</button><br><br>

        Don't have an account? <button type="button" class="create-new">CREATE NEW</button>
    </form>

</div>

<script>
    document.querySelector('.create-new').addEventListener('click', function() {
        window.location.href = 'jsp/authen/register.jsp';
    });
</script>

</body>
</html>
