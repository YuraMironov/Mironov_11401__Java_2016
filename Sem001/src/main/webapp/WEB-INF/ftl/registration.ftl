<#ftl/>
<#import "spring.ftl" as spring />
<html lang="en">
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <meta charset="UTF-8">
    <title>example</title>
    <link href="<@spring.url '../../resource/css/bootstrap.min.css'/>" rel="stylesheet">

    <link href="<@spring.url '../../resource/fonts/css/font-awesome.min.css'/>" rel="stylesheet">
    <link href="<@spring.url '../../resource/css/animate.min.css'/>" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="<@spring.url '../../resource/css/custom.css'/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<@spring.url '../../resource/css/maps/jquery-jvectormap-2.0.3.css'/>"/>

    <script src="<@spring.url '../../resource/js/jquery.min.js'/>"></script>
    <script src="<@spring.url '../../resource/js/nprogress.js'/>"></script>
</head>
<script src="<@spring.url '../../resource/js/custom.js'/>"></script>
<body style="background:#F7F7F7;">
<div class="">
    <div id="wrapper">
        <div id="login" class="animate form">
            <section class="login_content">
            <@form.form commandName="regForm" action="/registration" acceptCharset="UTF-8" method="post" class="form-horizontal">
                <h1>Create Account</h1>
                <#if error??>
                    <h2 style="text-align: center; color: red">${error}</h2>
                </#if>
                <div>
                    <@form.input path="firstName" class="form-control" placeholder="first name"/>
                    <@form.errors path="firstName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input name="lastName" path="lastName" class="form-control"/>
                    <@form.errors path="lastName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input path="email" class="form-control" placeholder = "Email"/>
                    <@form.errors path="email" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.password path="password" class="form-control" placeholder="Password"/>
                    <@form.errors path="password" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.password path="confirmPassword" class="form-control" placeholder="confirm password"/>
                    <@form.errors path="confirmPassword" cssStyle="color: red;" />
                </div>
                <div>
                    <input type="submit" class="btn btn-default submit" value="Submit">
                </div>
                <div class="clearfix"></div>
                <div class="separator">
                    <div class="clearfix"></div>
                    <br/>
                    <div>
                        <h1><i class="fa fa-paw" style="font-size: 26px;"></i> Audi Autosalon</h1>
                        <p>©2015 All Rights Reserved. khan☺ </p>
                    </div>
                </div>
            </@form.form>
            </section>
        </div>
    </div>
</body>
</html>
