<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Новости</title>
</head>
<body>
<#assign k=newsesSize>
<#include "MaxPageAndMaxIdForPagination.ftl">
<#--if (count > maxPage){-->
<#--response.sendRedirect("/error404?backPage=" + request.getRequestURI().substring(1));-->
<#--}else{%>-->
<#include "TopBlock.ftl">
<div class="content">
    <div class="panel panel-default">
        <div class="panel-heading">
            <center>
                <div class="res"><h3><b>Наши новости!</b></h3></div>
            </center>
        </div>
        <div class="panel-group" id="accordion">
        <#assign y=maxID - (count - 1)*10 - 1>
        <#assign x=0>
        <#list newses as news>
            <#assign x++>
            <div class="mypanel panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse${x}">
                            ${news.getTitle()}
                        </a>
                    </h4>
                </div>
                <div id="collapse${x}"
                     class="panel-collapse collapse<#if x == 1> in</#if>">
                    <div class="panel-body">
                        ${news.getBody()}
                    </div>
                </div>
            </div>
        </#list>
        </div>
    <#include "Pagination.ftl">
    </div>
</div>
<#include "DownBlockUserBlock.ftl">
</body>
</html>