<#ftl encoding="utf-8">
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<h1>Spring Security - Sign In</h1>

<form class="login-form" action="j_spring_security_check" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label for="j_username">Username: </label>
    <input id="j_username" name="j_username" size="20" maxlength="50" type="text"/>

    <label for="j_password">Password: </label>
    <input id="j_password" name="j_password" size="20" maxlength="50" type="password"/>

    <label for="remember-me">Remember me: </label>
    <input type="checkbox" name="remember-me"/>

    <input type="submit" value="Login"/>
</form>


</body>
</html>