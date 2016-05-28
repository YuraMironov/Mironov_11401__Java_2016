<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Тарифы</title>
</head>
<body>
<#assign count=model["count"] tarifs=model["tarifs"] k=model["tarifsSize"]>
<#include "MaxPageAndMaxIdForPagination.ftl">
<#--if (count > maxPage){-->
<#--response.sendRedirect("/error404?backPage=" + request.getRequestURI().substring(1, request.getRequestURI().length()));-->
<#--}else{%>-->
<#include "TopBlock.ftl">
<div class="content">
    <div class="panel panel-default">
        <div class="panel-heading">Тариф</div>
        <table class="table">
            <thead>
            <tr>
                <th>Название</th>
                <th>Особенность</th>
                <th>Стоимость(руб.кВтч)</th>
                <th>Поставщик</th>
            </tr>
            </thead>
            <tbody>
            <#list tarifs as tarif>
            <tr>
                <td> ${tarif.getNameT()}</td>
                <td> ${tarif.getSpecialty()}</td>
                <td> ${tarif.getCost()}</td>
                <td> ${tarif.getProduce().getNameF()} <br>( ${tarif.getProduce().getPhone().getNumbers()} )</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
<#include "Pagination.ftl">
<#include "DownBlockUserBlock.ftl">
</div>
</body>
</html>