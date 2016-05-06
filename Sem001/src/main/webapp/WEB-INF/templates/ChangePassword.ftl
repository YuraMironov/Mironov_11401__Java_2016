<html>
<head>
    <title>Смена пароля</title>
</head>
<body>
<#if model["currentUser"]??>
<#include "TopBlock.ftl">
<div class="content">
    <div class="SchetBlock" style="height: auto;">
        <#if er_mes?? && er_mes="changePassReg">
        <center>
            <div class="bs-example">
                <div class="alert alert-success fade in">
                    <h4>Пароль успешно сменен!!</h4>

                    <p><a href="/home">
                        <button type="button" class="btn btn-danger">На главную!!</button>
                    </a></p>
                </div>
            </div>
        <center>
        </#if>

        <form action="/changepass" method="post" style="width: 80%; margin-left: 10%;"
              onsubmit="return eqvPass() && checkedPass();">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <center>Форма смены пароля.</center>
            <#if er_mes?? && er_mes="oldPass">
                <center><div style="color: red;">Был неверно введен старый пароль!!!</div> </center>
            </#if>
            <br>
            <span class="label label-default">Старый пароль</span>
            <input type="password" id="pass" name="oldPass" class="form-control" placeholder="Введите пароль" required
                   oninput="eqvPass()">
            <span class="label label-default">Новый пароль</span>
            <input type="password" id="pass1" name="pass" class="form-control" placeholder="Введите пароль" required
                   oninput="eqvPass()">

            <div id="res1" class="res"></div>
            <input type="password" id="pass2" name="newPass" class="form-control pass2" placeholder="Повторите пароль"
                   required oninput="checkedPass()">

            <div id="res2" class="res"></div>
            <input type="submit" class="btn btn-default" value="Сменить пароль">
        </form>
        <script>
            eqvPass = function () {
                var pass = $("#pass1").val();
                var string = pass;
                var regexp = new RegExp('^[a-zA-Z0-9]+$');
                var boolean = regexp.test(string);
                var x;
                if (boolean) {
                    if (pass.length < 6) {
                        x = false;
                        $("#res1").html("Плохой пароль, подберите другой");
                    } else {
                        x = true;
                        $("#res1").html("");
                    }
                } else {
                    x = false;
                    $("#res1").html("Пароль должен содержать только цифры и латинские буквы");
                }
                return x;
            };
            checkedPass = function () {
                var x;
                var pass2 = $("#pass2").val();
                if (pass2.length > 0) {
                    if ($("#pass1").val() != pass2) {
                        x = false;
                        $("#res2").html("Не верный пароль");
                    } else {
                        x = true;
                        $("#res2").html("");
                    }
                } else {
                    x = false;
                    $("#res2").html("");
                }
                return x;
            };
        </script>
    </div>
</div>
</#if>
<#--} else {-->
<#--response.sendRedirect("/error404");-->
<#--}-->
<#--%>-->
<#include "DownBlockUserBlock.ftl">
</body>
</html>