<table class="table" xmlns="http://www.w3.org/1999/html">
    <thead>
    <tr>
    <#if advices??>
        <th><label>Заголовок совета</label></th>
        <th><label>Тело совета</label></th>
        <th><label>Картинка</label></th>
        <th><label>Автор</label></th>
        <th></th>
        <th></th>
    <#else >
        <th>Фирм нет</th>
    </#if>
    </tr>
    </thead>
    <tbody id="tbody">
    <#list  advices as advice>
    <tr>
        <form action="/admin/edit/advices/save" method="post">
            <input type="hidden" name="aid" value="${advice.getId()}"/>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td><input type="text" name="advname" value="${advice.getAdvname()}"/></td>
            <td><textarea name="advbody" cols="20" rows="2">${advice.getAdvbody()}</textarea></td>
            <td><textarea cols="40" rows="3" type="text" name="filesrc">${advice.getFilesrc()}</textarea></td>
            <td>${advice.getAuthor().getLogin()} </td>
            <td><input type="submit" value="Сохранить"/></td>
        </form>
        <form action="/admin/edit/advices/delete" method="post">
            <input type="hidden" name="aid" value="${advice.getId()}"/>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td><input type="submit" value="Удалить"/></td>
        </form>
    </tr>
    </#list>
    </tbody>
</table>