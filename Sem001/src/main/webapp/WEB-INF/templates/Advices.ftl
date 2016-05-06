<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Советы</title>
</head>
<body>
<#include "TopBlock.ftl">

<#include "DotDotDot.ftl">
<#assign advices=model["advices"]>
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
                        <#list model["allAdvices"] as advice>
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
<#assign styles = model["styles"]>
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
<#list model["allAdvices"] as advice>
    <#assign id++>
    <div class="modal fade mymodal" id="myModal${id}" tabindex="-1" role="dialog"
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


    <div class="modal fade" id="myModalAddAdv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Добавить совет</h4>
                </div>
                <div class="panel-body">
                    <form action="/advices" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <br>
                        <p><input type="text" class="form-control" name="title" placeholder="Ваш заголовок" width="30%">
                        </p>

                        <p><input type="text" class="form-control" name="body" placeholder="Ваш совет"></p>

                        <p><input type="text" class="form-control" name="filesrc" placeholder="Ссылка на картинку"></p>
                        <center>
                            <button type="submit" class="btn btn-default">Добавить совет</button>
                        </center>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

<#include "DownBlockUserBlock.ftl">
</body>
</html>