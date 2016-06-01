<!DOCTYPE html>
<html lang="en">
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
    <script>
        function autoinput() {
            $("#login").val("<#if model["login"]?? >${model["login"]}<#else></#if>");
            $("#email").val("<#if model["email"]?? >${model["email"]}<#else></#if>");
            $("#schetchik").val(<#if model["schetchik"]?? >${model["schetchik"]}<#else></#if>);
        }
        function init() {
            autoinput();
        }
    </script>
</head>
<body onload="init()">
<#include "TopBlock.ftl">
<#include "TopBlockReg.ftl">
<div class="content">
    <div class="SchetBlock">
    <@form.form commandName="registration_form" action="/reg" method="post" onsubmit="wannaSub();">
        <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
        <span class="label label-default">Логин</span>
        <@form.input path="login" type="text" id="login" name="login" class="form-control" placeholder="Имя пользователя"
        oninput="validLogin()"/>

        <div id="res4" class="res"><@form.errors path="login"/></div>

        <span class="label label-default">Пароль</span>
        <@form.input path="password" type="password" id="pass" name="pass" class="form-control" placeholder="Введите пароль"
        oninput="eqvPass()"/>

        <div id="res3" class="res"><@form.errors path="password"/></div>

        <@form.input path="password2" type="password" id="pass2" name="pass2" class="form-control pass2" placeholder="Повторите пароль"
        oninput="checkedPass()"/>

        <div id="res2" class="res"><@form.errors path="password2"/></div>

        <span class="label label-default">Укажите свой электронный адресс</span>
        <@form.input path="email" type="email" id="email" name="email" class="form-control" placeholder="Email"
        oninput="eqvEmail()"/>

        <div id="res" class="res"><@form.errors path="email"/></div>
        <span class="label label-default">Укажите своего поставщика</span>

        <select class="form-control" id="optionDefault" name="produce" required>
            <#list  firms as firm>
                <option value="${firm.getIdFirm()}">${firm.getNameF()}</option>
            </#list>
        </select>

        <span class="label label-default">Тариф</span>
        <select class="form-control" name="tarif" required>
            <#list tarifs as tarif>
                <option value="${tarif.getIdTarif()}">${tarif.getNameT()}</option>
            </#list>
        </select>

        <span class="label label-default">Показания счетчика</span>
        <@form.input path="schetchik" type="text" id="schetchik" name="schetchik" class="form-control"
        placeholder="Показание счетчика при последней оплате" oninput="validSchetchik()"/>
        <div class="res 5" id="res5"><@form.errors path="schetchik"/></div>
        <br>
        <input type="submit" class="btn btn-default" value="Зарегистрироваться">
    </@form.form>
    </div>
</div>
<#include "DownBlockRegValidateForm.ftl">
<#include "DownBlockUserBlock.ftl">

<script>
    $("#login").attr('required', '').attr('autofocus', '');
    $("#pass").attr('required', '');
    $("#pass2").attr('required', '');
    $("#email").attr('required', '');
    $("#schetchik").attr('required', '');
</script>
</body>
</html>
