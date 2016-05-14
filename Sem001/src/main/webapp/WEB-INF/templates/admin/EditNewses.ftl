<table class="table" xmlns="http://www.w3.org/1999/html">
    <thead>
    <tr>
    <#if newses??>
        <th><label>Заголовок новости</label></th>
        <th><label>Тело новости</label></th>
        <th></th>
        <th></th>
    <#else >
        <th>Новостей нет</th>
    </#if>
    </tr>
    </thead>
    <tbody id="tbody">
    <tr>
        <form action="/admin/edit/newses/add" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <td><input type="text" name="title" /></td>
            <td><textarea name="body" cols="80" rows="3"></textarea></td>
            <td><input type="submit" value="Добавить"/></td>
        </form>
    </tr>
    <#list newses as news>
    <tr>
        <form action="/admin/edit/newses/save" method="post">
            <input type="hidden" name="nid" value="${news.getIdNews()}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <td><input type="text" name="title" value="${news.getTitle()}"/></td>
            <td><textarea name="body" cols="80" rows="3">${news.getBody()}</textarea></td>
            <td><input type="submit" value="Сохранить"/></td>
        </form>
        <form action="/admin/edit/newses/delete" method="post">
            <input type="hidden" name="nid" value="${news.getIdNews()}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <td><input type="submit" value="Удалить"/></td>
        </form>
    </tr>
    </#list>
    </tbody>
</table>