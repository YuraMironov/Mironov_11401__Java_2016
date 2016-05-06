<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserSchet</title>
</head>
<script>
    function autoinput() {
        $("#schetNumber").val("<#if schetNumber??>${schetNumber}</#if>");
        $("#date").val("<#if date??>${date}</#if>");
        $("#userName").val("<#if schetName??>${schetName}</#if>");
        $("#schetchik").val("<#if schetchik??>${schetchik}</#if>");
    }
    function init() {
        autoinput();
    }
</script>
<body onload="init()">
<#if model["currentUser"]??>
    <#include "TopBlock.ftl">
    <#if dolg?? && schetNumber??>
    <div class="er_mes">
        <center>
            <div class="bs-example">
                <div class="alert alert-success fade in">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>Информация о задолженности пользователя!!</h4>
                    <p>Уважаемый, ${model["currentUser"].getLogin()}
                    </p>
                    <p>ваша задолженость по счету</p>
                    <p>${schetNumber} составляет:</p>
                    <p>${dolg} рублей(рубля)!</p>
                    <p><a href="/home">
                        <button type="button" class="btn btn-danger">На главную!!</button>
                    </a><form action="/userschet/pay" method="POST">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" name="dolg" value="${dolg}"/>
                        <input type="hidden" name="lastNow" value="${lastNow}"/>
                        <button type="submit" class="btn btn-danger">Оплатить</button>
                    </form></p>
                </div>
            </div>
            <center>
    </div>
    </#if>
    <#if (er_mes?? && er_mes = "changeSchetchik") || model["currentUser"].getLast() = 99999>
    <div class="er_mes">
        <div class="bs-example">
            <div class="alert alert-danger fade in">
                <#if activeUser.last = 99999>
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                </#if>
                <h4>Внимание!</h4>

                <p>Уважаемый, ${model["currentUser"].getLogin()}
                </p>

                <p>Вам необходимо сменить свой счетчик</p>

                <p>Смотрите показания своего счетчика</p>

                <p><a href="/home">
                    <button type="button" class="btn btn-danger">На главную!!</button>
                </a>
                    <#if model["currentUser"].last = 99999>
                        <a href="/pay?dolg=${dolg}&lastNow=${lastNow}">
                            <button type="button" class="btn btn-danger">Оплатить</button>
                        </a>
                    </#if>
                </p>
            </div>
        </div>
    </div>
    </#if>
<div class="content">
    <div class="SchetBlock">
        <form action="/userschet" method="POST" onsubmit="return valideDate() && validSchetchik()">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <#if er_mes?? && er_mes = "uncor_tarif">
                <center>Выбирите свой тариф!!!</center>
            </#if>
            <span class="label label-default">Номер счета</span>
            <input type="number" max="99999999" id="schetNumber" name="schetNumber" class="form-control"
                   placeholder="Ваш номер счета" required autofocus>
            <span class="label label-default">Дата установки</span>
            <input type="text" id="date" name="date" class="form-control" placeholder="DD.MM.YYYY" required
                   oninput="valideDate()">

            <div id="res" class="res"></div>
            <span class="label label-default">Текущие показания</span>
            <input type="number" min="${model["currentUser"].getLast()}"
                   max="99999" name="lastNow"
                   id="schetchik" class="form-control" placeholder="Показания счетчика"
                   required
                   oninput="validSchetchik()">

            <div id="res2" class="res"></div>
            <script type="application/javascript">
                valideDate = function () {
                    var string = $("#date").val();
                    var regexp = new RegExp('([0-2][0-9]|3[01])\\.(0[0-9]|1[[0-2])\\.[0-9]{4}');
                    var boolean = regexp.test(string);
                    if (!boolean) {
                        $("#res").html("проверьте на ([0-2][0-9]|3[01])\\.(0[0-9]|1[[0-2])\\.[0-9]{4}");
                    } else {
                        $("#res").html("");
                    }
                };
                validSchetchik = function () {
                    var string = $("#schetchik").val();
                    var regexp = new RegExp('^[0-9]{5}$');
                    var boolean = regexp.test(string);
                    if (boolean) {
                        $("#res2").html("");
                    } else {
                        $("#res2").html("[0-9]{5}")
                    }
                };
            </script>
            <span class="label label-default">Тариф</span>
            <select class="form-control" id="optionDefault" name="tarif" required>
                <#list tarifs as tarif>
                    <option value="${tarif.getIdTarif()}">${tarif.getNameT()}
                    </option>
                </#list>
            </select>
            <br>
            <button type="submit" class="btn btn-default">Посчитать задолженность</button>
        </form>
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