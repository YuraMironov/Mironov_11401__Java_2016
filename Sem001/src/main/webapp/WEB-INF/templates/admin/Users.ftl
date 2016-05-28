<input type="hidden" id="sorted"/>
<table class="table">
    <thead>
    <tr>
    <#if users??>
        <th><label>Логин <a href="" onclick='sort("login")'><input type="radio" name="sort"/></a></label></th>
        <th><label>Почта <input type="radio" name="sort" onclick="sort('email')"/></label></th>
        <th><label>Фирма <input type="radio" name="sort" onclick="sort('firm')"/></label></th>
        <th><label>Тариф <input type="radio" name="sort" onclick="sort('tarif')"/></label></th>
        <th><label>Показания счетчика <input type="radio" name="sort" onclick="sort('last')"/></label></th>
        <th><label>Состояние <input type="radio" name="sort" onclick="sort('status')"/></label></th>
    <#else >
        <th>Новых пользователей нет</th>
    </#if>
    </tr>
    </thead>
    <tbody id="tbody">
    <#list users as user>
    <tr>
        <td><a href="/admin/user/uid?uid=${user.getId()}"
               style="color: black; text-decoration: underline;">${user.getLogin()}</a></td>
        <td>${user.getEmail()}</td>
        <td>${user.getFirm().getNameF()}</td>
        <td>${user.getTarif().getNameT()}</td>
        <td>${user.getLast()}</td>
        <td style="text-align: center;">
            <#if uri = "allusers">
                <input type="checkbox" id="status${user.getId()}" name="status"
                       onclick="changeStatus(${user.getId()})" <#if user.isAccountNonLocked()> checked</#if>/>
            <#else >
                <form action="/admin/activateuser" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="hidden" name="uid" value="${user.getId()}"/>
                    <button type="submit">Подтвердить</button>
                </form>
            </#if>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
<script type="application/javascript">
    changeStatus = function (uid) {
        var x = false;
        var id = "#status" + uid;
        var checked = 0;
        if (document.getElementById('status' + uid).checked) {
            checked = 1;
        }
        $.ajax({
            url: "/admin/user/uid/non_locked?uid=" + uid,
            data: {"checked": checked},
            dataType: "html",
            async: false,
            success: function (response_data) {
                alert("Состояние пользователя успешно изменено");
            }
        });
        return x
    };
    sort = function (th) {
        var csrfn = "${_csrf.parameterName}";
        var csrfv = "${_csrf.token}";
        var uri = "${uri}";
        $.ajax({
            url: "/admin/allusers/sort?new=<#if uri = "allusers">false<#else>true</#if>",
            data: {"sort": th},
            dataType: "json",
            success: function (response_data) {
                if (response_data.length > 0) {
                    $("#tbody").html("");
                    for (var i = 0; i < response_data.length; i++) {
                        var string = "";
                        if (uri == "allusers") {
                            var string1 = response_data[i].nonlocked ? "' checked/>" : "'/>"
                            string = "<input type='checkbox' id='status" + response_data[i].id + "' name='status' onclick='changeStatus(" + response_data[i].id + ")";
                            string += string1;
                        } else {
                            string = "<form action='/admin/activateuser' method='post'>"
                                    + "<input type='hidden' name='" + csrfn + "' value='" + csrfv + "'/>"
                                    + "<input type='hidden' name='uid' value='" + response_data[i].id + "'/>"
                                    + "<button type='submit'>Подтвердить</button></form>";
                        }
                        $("#tbody").append("<tr><td>" + response_data[i].login + "</td><td>" +
                                response_data[i].email + "</td><td>" + response_data[i].firm.nameF +
                                "</td><td>" + response_data[i].tarif.nameT + "</td><td>" + response_data[i].last
                                + "</td><td style='text-align: center;'>" + string + "</td></tr>");
                    }
                } else {
                    $("#tbody").append("<tr><td>Новых пользователей нет</td></tr>");
                }
            }
        });
    }
</script>