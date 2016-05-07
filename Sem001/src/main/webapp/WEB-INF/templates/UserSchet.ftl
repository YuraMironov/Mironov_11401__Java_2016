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
                    </a>
                        <a href="/userschet/pay?dolg=${dolg}&lastNow=${lastNow}">
                            <button type="button" class="btn btn-danger">Оплатить</button>
                        </a>
                    </p>
                </div>
            </div>
            <center>
    </div>
    </#if>
    <#if (er_mes?? && er_mes = "changeSchetchik") || model["currentUser"].getLast() = 99999>
    <div class="er_mes">
        <div class="bs-example">
            <div class="alert alert-danger fade in">
                <#if activeUser.schetchik = 99999>
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
                    <#if model["currentUser"].schetchik = 99999>
                        <a href="/pay?dolg=${dolg}&lastNow=${lastNow}">
                            <button type="button" class="btn btn-danger">Оплатить</button>
                        </a>
                    </#if>
                </p>
            </div>
        </div>
    </div>
    </#if>
    <#if (er_mes?? && er_mes = "payError") >
    <div class="er_mes">
        <div class="bs-example">
            <div class="alert alert-danger fade in">
                <h4>Внимание!</h4>

                <p>Уважаемый, ${model["currentUser"].getLogin()}
                </p>

                <p>Что-то пошло не так...</p>

                <p>Повторите операцию</p>

                <p><a href="/userschet">
                    <button type="button" class="btn btn-danger">Повторить!!</button>
                </a>
                </p>
            </div>
        </div>
    </div>
    </#if>
<div class="content">
    <div class="SchetBlock">
        <@form.form commandName="userschet_form" action="/userschet" method="POST" onsubmit="return (validSchetchik() && valideDate())">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <#if er_mes?? && er_mes = "uncor_tarif">
                <center>Выбирите свой тариф!!!</center>
            </#if>
            <span class="label label-default">Номер счета</span>
            <@form.input path="schetNumber" type="number" id="schetNumber" name="schetNumber" class="form-control"
                placeholder="Ваш номер счета"/>
            <div class="res"><@form.errors path="schetNumber"/></div>
            <span class="label label-default">Дата установки</span>
            <@form.input path="date" type="text" id="date" name="date" class="form-control" placeholder="DD.MM.YYYY"
                oninput="return valideDate()"/>

            <div id="res" class="res"><@form.errors path="date"/></div>
            <span class="label label-default">Текущие показания</span>
            <@form.input path="schetchik" type="number"
                max="99999" name="schetchik"
                id="schetchik" class="form-control" placeholder="Показания счетчика"
                oninput="return validSchetchik()"/>

            <div id="res2" class="res"><@form.errors path="schetchik"/></div>
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
            return boolean;
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
            return boolean;
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
        </@form.form>
    </div>
</div>
</#if>
<#--} else {-->
<#--response.sendRedirect("/error404");-->
<#--}-->
<#--%>-->
<#include "DownBlockUserBlock.ftl">

<script>
    $("#schetNumber").attr('required', '').attr('autofocus', '');
    $("#date").attr('required', '');
    $("#schetchik").attr('required', '');
</script>
</body>
</html>
