<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>(Режим администратора) Активация пользователей.</title>
    <script src="../../resource/js/jquery-2.1.4.js" type="application/javascript"></script>
    <link href="../../resource/css/admin.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<div id="myNav" class="myNav">
    <div>
        <h2><p><label>
            <a href="/" style="color: #AFafaf;">StudentEnergo</a>
        </label></p></h2>
    </div>
    <div>
        <p><a href="/admin/activateuser">Новые пользователи</a></p>
        <p><a href="/admin/allusers">Все пользователи</a></p>
        <p><a href="/admin/claimstarif">Заявки на смену тарифа</a></p>
        <p><a href="#" onclick="openEditDiv()">Режим редактирования</a></p>

        <div id="editDiv" style="display: none; text-align: right;">
            <input type="hidden" id="editDivHidden" value="1"/>
            <p><a href="/admin/edit/tarifs" class="color-black">Тарифы</a></p>
            <p><a href="/admin/edit/firms" class="color-black">Фирмы</a></p>
            <p><a href="/admin/edit/advices" class="color-black">Советы</a></p>
            <p><a href="/admin/edit/newses" class="color-black">Новости</a></p>
        </div>
    </div>
</div>

<div id="myFooter" class="myFooter">
<#include footer>
</div>
</body>
<script type="application/javascript">
    openEditDiv = function () {
        var editDiv = document.getElementById("editDiv");
        var x = $("#editDivHidden").val();
        if (x == 1) {
            editDiv.setAttribute("style", "text-align: right; padding-right : 30px;")
            $("#editDivHidden").val(0);
        } else {
            $("#editDivHidden").val(1);
            editDiv.setAttribute("style", "display:none; text-align: right;")
        }
    }
</script>
</html>