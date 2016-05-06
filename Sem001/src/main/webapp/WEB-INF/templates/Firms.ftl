<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Фирмы</title>
</head>
<body>
<#if model["count"]??>
    <#assign count=model["count"] k=model["firmsSize"] firms=model["firms"]>
    <#include "MaxPageAndMaxIdForPagination.ftl">
<#--if (count > maxPage) {-->
<#--response.sendRedirect("/error404?backPage=" + request.getRequestURI().substring(1));-->
<#--} else {%>-->
    <#include "TopBlock.ftl">
<div class="content">
    <div class="panel panel-default">
        <div class="panel-heading">Компании</div>
        <table class="table">
            <thead>
            <tr>
                <th>Название</th>
                <th>Руководитель</th>
                <th>Юридический адресс</th>
                <th>Контакты</th>
                <th>Рейтинг надежности</th>
            </tr>
            </thead>
            <tbody>
                <#list firms as firm>
                <tr>
                    <td>${firm.getNameF()}
                    </td>
                    <td>${firm.getDirector()}
                    </td>
                    <td>${firm.getAddres()}
                    </td>
                    <td>${firm.getPhone().getNumbers()}
                    </td>
                    <td>${firm.getRaiting()}
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <#include "Pagination.ftl">
    </div>
</div>
<#else>
</#if>
<#include "DownBlockUserBlock.ftl">
</body>
</html>