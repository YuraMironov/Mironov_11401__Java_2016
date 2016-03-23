<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 09/03/2016
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Привет, ${name}!</h1>
<form method="POST" action="/hi">
    <input type="text" placeholder="Введите имя" name="name"/>
    <button type="submit">Подтвердить</button>
</form>
</body>
</html>
