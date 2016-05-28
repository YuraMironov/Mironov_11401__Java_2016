<html>
<head>
    <title>Смена тарифа</title>
</head>
<body>
<#if model["currentUser"]??>
    <#include "TopBlock.ftl">
<div class="content">
    <div class="SchetBlock" style="height: auto;">
        <form action="/changetarif" method="post" style="width: 80%; margin-left: 10%;"
              onsubmit="return eqvPass() && checkedPass();">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <center>Форма смены тарифа.</center>
            <br>
            <#if model["message"]??>
                <#if model["message"] == "success">
                    <div style="color:green;">Заявка принята</div>
                <#else>
                    <div style="color:red;">Не должно быть пустых полей</div>
                </#if>
                <br>
            </#if>
            <span class="label label-default">Выберите фирму</span>
            <select class="form-control" id="optionDefault" name="produce" required oninput="getTarif()">
                <#if model["firms"]??> <#assign firms = model["firms"]></#if>
                <option selected>Выберите фирму</option>
                <#list  firms as firm>
                    <option value="${firm.getIdFirm()}">${firm.getNameF()}</option>
                </#list>
            </select>
            <div id="tarifs"></div>
            <div id="comment"></div>
            <div id="subbmit" style="display: none;">
                <input type="submit" class="btn btn-default" value="Сменить тариф">
            </div>
        </form>
    </div>
</div>
<script type="application/javascript">
    getTarif = function () {
        $.ajax({
            url: "/changetarif/tarifs",
            dataType: "json",
            success: function (response_data) {
                $("#tarifs").html("");
                $("#tarifs").append("<br>")
                $("#tarifs").append("<span class='label label-default'>Выберите новый тариф</span>")
                $("#tarifs").append("<select id='sel' class='form-control' name='tarif' required>")
                $("#tarifs").append("</select>")
                for (var i = 0; i < response_data.length; i++) {
                    $("#sel").append("<option value='" + response_data[i].idTarif + "'>" + response_data[i].nameT + "</option>")
                }
            }
        })
        $("#comment").html("");
        $("#comment").append("<span class='label label-default'>Причина смены тарифа</span>")
        $("#comment").append("<input type='text' class='form-control' name='comment'/>")
        document.getElementById("subbmit").removeAttribute("style")
    }
</script>
</#if>
<#--} else {-->
<#--response.sendRedirect("/error404");-->
<#--}-->
<#--%>-->
<#include "DownBlockUserBlock.ftl">
</body>
</html>
