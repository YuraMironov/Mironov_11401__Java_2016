<table style="margin-left: 50px" xmlns="http://www.w3.org/1999/html">
    <thead>
    <#if claims??>
    <th>ID пользователя</th>
    <th>ID нового тарифа</th>
    <th>Причина</th>
    <th>Принять заявку</th>
    <#else>
    <th>Новых заявок нет</th>
    </#if>
    </thead>
    <tbody>
    <#list claims as claim>
    <tr>
        <td><a href="/admin/user/uid?uid=${claim.getUserid()}">${claim.getUserid()}</a> </td>
        <td>${claim.getNewtarifid()}</td>
        <td>${claim.getComment()}</td>
        <td>
            <form action="/admin/claimstarif/ok" method="post">
                <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                <input type="hidden" name="uid" value="${claim.getUserid()}"/>
                <input type="hidden" name="tid" value="${claim.getNewtarifid()}"/>
                <input type="hidden" name="ctid" value="${claim.getId()}"/>
                <input type="submit" value="Принять"/>
            </form>
            <form action="/admin/claimstarif/notok" method="post">
                <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                <input type="hidden" name="tid" value="${claim.getId()}"/>
                <input type="submit" value="Отклонить"/>
            </form>
        </td>
    </tr>
    </#list>
    </tbody>
</table>