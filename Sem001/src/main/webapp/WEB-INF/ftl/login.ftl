[#ftl/]
[#import "spring.ftl" as spring /]
[#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/]
<html>
<head>
    <meta charset="UTF-8">
    <title>example</title>
    <link href="[@spring.url '../../resource/css/bootstrap.min.css'/]" rel="stylesheet">

    <link href="[@spring.url '../../resource/fonts/css/font-awesome.min.css'/]" rel="stylesheet">
    <link href="[@spring.url '../../resource/css/animate.min.css'/]" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="[@spring.url '../../resource/css/custom.css'/]" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="[@spring.url '../../resource/css/maps/jquery-jvectormap-2.0.3.css'/]"/>

    <script src="[@spring.url '../../resource/js/jquery.min.js'/]"></script>
    <script src="[@spring.url '../../resource/js/nprogress.js'/]"></script>
</head>
<script src="[@spring.url '../../resource/js/custom.js'/]"></script>
<body style="background:#F7F7F7;">
<div id="wrapper">
    <div id="login" class="animate form">
        <section class="login_content">
            <form id="loginForm" action="/j_spring_security_check" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <h1>Login Form</h1>
                <div>
                    <input type="text" class="form-control" placeholder="Username" name="j_username"/>
                </div>
                <div>
                    <input type="password" class="form-control" placeholder="Password" name="j_password"/>
                </div>
                <div>
                    <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Remember me</label>
                </div>
                <div>
                    <input type="submit" class="btn btn-default submit" value="Log in"/>
                </div>
                <div class="clearfix"></div>
                <div class="separator">

                    <p class="change_link">New to site?
                        <a href="/registration" class="to_register"> Create Account </a>
                    </p>
                    [#--[@security.authorize access="isAuthenticated()"]--]
                    [#--<a href="/logout">Logout</a>--]
                [#--[/@security.authorize]--]
                <div class="clearfix"></div>
                <br/>
                <div>
                    <h1><i class="fa fa-paw" style="font-size: 26px;"></i> Audi Autosalon</h1>

                    <p>©2015 All Rights Reserved. Khan☺</p>
                </div>
    </div>
    </form>
    <!-- form -->
    </section>
</div>
</div>
</body>


