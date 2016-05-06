<!DOCTYPE html>
<html lang="en">
<head>
    <title>Страница не найдена, SudentEnergo</title>

</head>
<body>
<#include "TopBlock.ftl">
<div class="er_mes">
<#if model["er_mes"]?? && model["er_mes"]="changePassReg">
<center>
    <div class="bs-example">
        <div class="alert alert-success fade in">
            <h4>Пароль успешно сменен!!</h4>

            <p>Повторите авторизацию!!</p>

            <p><a href="/home">
                <button type="button" class="btn btn-danger">На главную!!</button>
            </a></p>
        </div>
    </div>
<center>
</#if>

<#if model["er_mes"]?? && model["er_mes"]="erroraddadvice">
<center>
    <div class="bs-example">
        <div class="alert alert-success fade in">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4>УПС...!!!</h4>

            <p>Что-то пошло не так:</p>
            <p>Возможно вы указали пустые поля!!</p>

            <p><a href="/home">
                <button type="button" class="btn btn-danger">На главную!!</button>
            </a></p>
        </div>
    </div>
<center>
</#if>
</div>
<div class="content">
    <div class="SchetBlock">
        <h3>Извините, но такой страницы не существует. <span class="label label-default">4,0,4</span></h3>
        <%
        String uri = request.getParameter("backPage");
        if (uri != null) {
        %>
        <a href="/<%=uri%>">
            <div class="res" style="text-align:  right;">Вернуться назад</div>
        </a>

        <%}%>
    </div>
</div>
<#include "DownBlockUserBlock.ftl">
</body>
</html>