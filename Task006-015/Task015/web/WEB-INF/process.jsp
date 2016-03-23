<%--
  Created by IntelliJ IDEA.
  User: Юра
  Date: 22.03.2016
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/process" method="POST">
    <p><textarea rows="15" cols="100" name="text"></textarea></p>

    <select name="oper">
        <option oper="symbols">symbols</option>
        <option oper="words">words</option>
        <option oper="paragraphs">paragraphs</option>
        <option oper="sentences">sentences</option>
    </select>
    <input type="submit" value="result"><br></form>
</body>
</html>
