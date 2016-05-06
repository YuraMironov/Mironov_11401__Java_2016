<!DOCTYPE html>
<html lang="en">
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
    <script>
        function autoinput() {
            $("#login").val("<#if model["login"]?? >${model["login"]}<#else></#if>");
            $("#email").val("<#if model["email"]?? >${model["email"]}<#else></#if>");
            $("#schetchik").val(<#if model["last"]?? >${model["last"]}<#else></#if>);
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
    <#if er_mes?? && er_mes == "repeatEmail">
        <center>Пользователь с таким электронным адрессом уже существует!!!</center>
    </#if>
        <form action="/reg" method="post" onsubmit="wannaSub();">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <span class="label label-default">Логин</span>
            <input type="text" id="login" name="login" class="form-control" placeholder="Имя пользователя" required
                   autofocus oninput="validLogin()">
            <div id="res4" class="res"></div>
            <span class="label label-default">Пароль</span>
            <input type="password" id="pass" name="pass" class="form-control" placeholder="Введите пароль" required
                   oninput="eqvPass()">

            <div id="res3" class="res"></div>
            <input type="password" id="pass2" name="pass2" class="form-control pass2" placeholder="Повторите пароль"
                   required oninput="checkedPass()">

            <div id="res2" class="res"></div>
            <span class="label label-default">Укажите свой электронный адресс</span>
            <input type="email" id="email" name="email" class="form-control" placeholder="Email" required
                   oninput="eqvEmail()">

            <div id="res" class="res"></div>
            <span class="label label-default">Укажите своего поставщика</span>

            <select class="form-control" id="optionDefault" name="produce" required>
            <#if model["firms"]??> <#assign firms = model["firms"]></#if>
            <#list  firms as firm>
                <option value="${firm.getIdFirm()}">${firm.getNameF()}</option>
            </#list>
            </select>

            <span class="label label-default">Тариф</span>
            <select class="form-control" name="tarif" required>
            <#if model["tarifs"]??> <#assign tarifs = model["tarifs"]></#if>
            <#list tarifs as tarif>
                <option value="${tarif.getIdTarif()}">${tarif.getNameT()}</option>
            </#list>
            </select>

            <span class="label label-default">Показания счетчика</span>
            <input type="number" id="schetchik" name="last" class="form-control"
                   placeholder="Показание счетчика при последней оплате" required oninput="validSchetchik()">

            <div class="res 5" id="res5"></div>
            <br>
            <input type="submit" class="btn btn-default" value="Зарегестрироваться">
        </form>
    </div>
</div>
<#include "DownBlockRegValidateForm.ftl">
<#include "DownBlockUserBlock.ftl">
</body>
</html>