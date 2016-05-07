<#ftl encoding="utf-8">
<html>
<head>
    <title>LogIn</title>
    <link href="../../resource/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="../../resource/css/style.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<nav class="navbar navbar-default login-login-form">
    <div class="nav" style="width: auto;">
        <div style="padding-left: 10px;">
            <h1><a href="/">StudentEnergo</a></h1>
        </div>
        <div class="btnbar" style="margin-top: 5px;">
            <form class="login-form" action="j_spring_security_check" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="username">
                    <label for="j_username">Username: </label>
                <input id="j_username" name="j_username" size="20" maxlength="50" type="text"
                        class="form-control" required autofocus/>
                </div>
                <div class="password">
                <label for="j_password">Password: </label>
                <input id="j_password" name="j_password" size="20" maxlength="50" type="password"
                       class="form-control" required/>
                </div>
                <div class="password" style="padding-right: 0; margin-top: 20px; margin-bottom: 20px;">
                <label for="remember-me">Remember me:  <input name="remember-me" type="checkbox"/>
                    <p><a href="/reg">Регистрация</a> </p></label>

                <div class="sub">
                    <button type="submit" class="btn btn-default login-btn">LogIn</button>
                </div>
                </div>
            </form>
        </div>
    </div>
</nav>
</body>
</html>