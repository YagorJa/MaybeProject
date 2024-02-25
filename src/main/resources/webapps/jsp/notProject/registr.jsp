<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/jsp">
</head>
<body>
<form method="post" action="http://localhost:8090/TempDz4/registr">
    <div class="container">
        <label><b>Зарегистрировать пользователя</b></label>
        <input type="text" placeholder="Введите логин" name="login" required>
        <input type="password" placeholder="Введите пароль" name="password" required>
        <input type="text" placeholder="Введите имя" name="name" required>
        <input type="text" placeholder="Введите фамилию" name="surname" required>
        <button type="submit">Зарегистрировать</button>
    </div>
</form>
</body>
</html>