<div class="er_mes">
<#if success_mes??>
    <center>
        <div class="bs-example">
            <div class="alert alert-success fade in">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>Вы успешно зарегестрирова<#if model["currentUser"]??>ли нового пользователя!!<#else>ны!!<p>Пожалуйста, авторизируйтесь!</p></#if>
                </h4>
                <p><a href="/home">
                    <button type="button" class="btn btn-danger">На главную!!</button>
                </a></p>
            </div>
        </div>
    </center>
</#if>
<#if er_mes?? && er_mes == "repeat">
    <center>
        <div class="bs-example">
            <div class="alert alert-danger fade in">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>Ошибка!!</h4>

                <p>При регистрации были введены некоректные данные!!</p>

                <p>Пожалуйста, повторите...</p>

                <p><a href="/home">
                    <button type="button" class="btn btn-danger">На главную!!</button>
                </a></p>
            </div>
        </div>
    </center>
</#if>
</div>