<table class="table" xmlns="http://www.w3.org/1999/html">
    <thead>
    <tr>
    <#if tarifs??>
        <th><label>Название тарифа</label></th>
        <th><label>Особенности тарифа</label></th>
        <th><label>Стоимость услуг </label></th>
        <th><label>Фирма поставщик </label></th>
        <th></th>
        <th></th>
    <#else >
        <th>Новых тарифов нет</th>
    </#if>
    </tr>
    </thead>
    <tbody id="tbody">
    <tr>
        <form action="/admin/edit/tarifs/add" method="post">
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td><input type="text" name="nameT"/> </td>
            <td><textarea cols="40" rows="3" type="text" name="specialty"></textarea></td>
            <td><input type="number" step="0.01" name="cost"/> </td>
            <td><select class="form-control" id="optionDefault" name="fid" required oninput="getTarif()">
                <#list firms as firm>
                    <option value="${firm.getIdFirm()}">${firm.getNameF()}</option>
                </#list>
                </select></td>
            <td><input type="submit" value="Добавить"/></td>
        </form>
    </tr>
    <#list tarifs as tarif>
    <tr>
        <form action="/admin/edit/tarifs/save" method="post">
            <input type="hidden" name="tid" value="${tarif.getIdTarif()}"/>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td>${tarif.getNameT()}</td>
            <td><textarea name="specialty" cols="40" rows="3">${tarif.getSpecialty()}</textarea></td>
            <td><input name="cost" step="0.01" value="${tarif.getCost()}"/></td>
            <td>${tarif.getProduce().getNameF()}</td>
            <td><input type="submit" value="Сохранить"/></td>
        </form>
        <form action="/admin/edit/tarifs/delete" method="post">
            <input type="hidden" name="tid" value="${tarif.getIdTarif()}"/>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
            <td><input type="submit" value="Удалить"/></td>
        </form>
    </tr>
    </#list>
    </tbody>
</table>