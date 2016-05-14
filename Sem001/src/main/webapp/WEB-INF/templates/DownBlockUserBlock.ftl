
<#if model["currentUser"]??>
<#assign user=model["currentUser"]>
<div class="modal fade" id="myModalProfile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Мой профиль</h4>
            </div>
            <div class="panel-body">

                <p>Логин: ${user.getLogin()}
                </p>

                <p>Электронный адрес: ${user.getEmail()}
                </p>

                <p>Поставщик: ${user.getFirm().getNameF()}
                </p>

                <p>Тариф: ${user.getTarif().getNameT()}
                </p>

                <p>Последнее показание счетчика: ${user.getLast()}
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>
</#if>