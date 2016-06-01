<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Советы</title>
</head>
<body>
<#include "TopBlock.ftl">

<#include "DotDotDot.ftl">
<div class="content">
    <div class="headadvice">
        <center><a href="#" data-toggle="modal" data-target="#myModal"
                   style="color:#eee;  font-size: 17px; font-weight: bolder;">Посмотреть все советы</a></center>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body" style="width: 100%">
                    <div class="modal-header">Советы от наших пользователей
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <table class="table">
                        <tbody>
                        <#list allAdvices as advice>
                        <tr>
                            <td></td>
                            <td>
                                <a href="#" class="modal_href" data-toggle="modal"
                                   data-target="#myModal${advice.getId()}">
                                    <div style="margin-left: 35px;">${advice.getAdvname()}</div>
                                </a>
                            </td>
                            <td>
                            ${advice.getAuthor().getLogin()}
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>
<#assign id=1 >
<#list advices as advice>
    <#assign st=styles[id-1]>
    <div class="jumbotron ${st.getNamecss()}">
        <center>
            <h${st.getSizeh()}>
                <a href="#" class="" data-toggle="modal"
                   data-target="#myModal${advice.getId()}">${advice.getAdvname()}
                </a><sup>
                <small>${advice.getAuthor().getLogin()}</small>
            </sup>
            </h${st.getSizeh()}>
        </center>
        <div class="test${id}" id="dot${id}" <#if advice.getFilesrc() == "">style="width: 100%"</#if>>
        ${advice.getAdvbody()}
        </div>
        <#if (id < 4 || id > 5) && advice.getFilesrc() != "" >
            <div class="imagein">
                <img class="myimage" src="${advice.getFilesrc()}" width="${st.getFilesize()}">
            </div>
        </#if>
    </div>
    <#assign id++>
</#list>
<#assign id=0>
<#list allAdvices as advice>
    <#assign id++>
    <div class="modal fade mymodal" id="myModal${advice.getId()}" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel all">${advice.getAdvname()}
                    </h4>
                </div>
                <div>
                    <#if advice.getFilesrc() != "">
                        <div class="modal-body">
                        ${advice.getAdvbody()}
                        </div>
                        <div class="imagein">
                            <img class="myimage" src="${advice.getFilesrc()}" width="220">
                        </div>
                    <#else>
                        <p class="modal-body">${advice.getAdvbody()}
                        </p>
                    </#if>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>
</#list>


    <div class="modal fade<#if validInfo??> in</#if>" id="myModalAddAdv" tabindex="-1"
                            role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true"<#if validInfo??> style="display: block;"</#if>>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                <#if !validInfo??> <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></#if>
                    <h4 class="modal-title">Добавить совет</h4>
                </div>
                <div class="panel-body">
                    <@form.form commandName="adviceadd_form" action="/advices" method="post">
                        <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                        <br>
                        <p><@form.input path="title" type="text" class="form-control" name="title"
                            placeholder="Ваш заголовок" width="30%"/>
                        <div class="res"><@form.errors path="title"/></div>
                        </p>
                        <p><@form.input path="body" type="text" class="form-control" name="body" placeholder="Ваш совет"/>
                        <div class="res"><@form.errors path="body"/></div></p>

                        <p><@form.input path="filesrc" type="text" class="form-control" name="filesrc"
                            placeholder="Ссылка на картинку"/>
                        <div class="res"><@form.errors path="filesrc"/></div></p>
                        <center>
                            <button type="submit" class="btn btn-default">Добавить совет</button>
                        </center>
                    </@form.form>

                </div>
                <div class="modal-footer">
                    <#if validInfo??><a href="/advices"></#if>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <#if validInfo??>Вернуться к советам!<#else>Закрыть</#if>
                    </button>
                    <#if validInfo??></a> </#if>
                </div>
            </div>
        </div>
    </div>

<#include "DownBlockUserBlock.ftl">
    <#if validInfo??><div class="modal-backdrop fade in"></div></#if>
</body>
</html>