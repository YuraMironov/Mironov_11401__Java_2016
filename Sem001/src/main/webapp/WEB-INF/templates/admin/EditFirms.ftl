<table class="table" xmlns="http://www.w3.org/1999/html">
    <thead>
    <tr>
    <#if tarifs??>
        <th><label>Название Фирмы</label></th>
        <th><label>Директор</label></th>
        <th><label>Адрес </label></th>
        <th><label>Рэйтинг</label></th>
        <th>Телефон</th>
        <th></th>
        <th></th>
    <#else >
        <th>Фирм нет</th>
    </#if>
    </tr>
    </thead>
    <tbody id="tbody">
    <tr>
        <form action="/admin/edit/firms/add" method="post">
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td><input type="text" name="nameF"/> </td>
            <td><textarea cols="20" rows="1" type="text" name="director"></textarea></td>
            <td><textarea cols="40" rows="3" type="text" name="addres"></textarea></td>
            <td><input type="number" min="0" max="5" name="raiting"/></td>
            <td><input type="text" name="phone"/></td>
            <td><input type="submit" value="Добавить"/></td>
        </form>
    </tr>
    <#list firms as firm>
    <tr>
        <form action="/admin/edit/firms/save" method="post">
            <input type="hidden" name="fid" value="${firm.getIdFirm()}"/>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td>${firm.getNameF()}</td>
            <td><textarea name="director" cols="20" rows="2">${firm.getDirector()}</textarea></td>
            <td><textarea cols="40" rows="3" type="text" name="addres">${firm.getAddres()}</textarea></td>
            <td><input type="number" min="0" max="5" name="raiting" value="${firm.getRaiting()}"/></td>
            <td><input type="text" name="phone" value="${firm.getPhone().getNumbers()}"/> </td>
            <td><input type="submit" value="Сохранить"/></td>
        </form>
        <form action="/admin/edit/firms/delete" method="post">
            <input type="hidden" name="fid" value="${firm.getIdFirm()}"/>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td><input type="submit" value="Удалить"/></td>
        </form>
    </tr>
    </#list>
    </tbody>
</table>