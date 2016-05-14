<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<script src="../resource/js/jquery-2.1.4.js" type="application/javascript"></script>
<script src="../resource/js/myvalide.js" charset="UTF-8" type="text/javascript"></script>
<script src="../resource/js/jquery.dotdotdot.js" type="text/javascript"></script>
<script src="../resource/js/bootstrap.js" type="application/javascript"></script>
<link href="../resource/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="../resource/css/style.css" rel="stylesheet" type="text/css" media="screen"/>
<div class="head">
    <nav class="navbar navbar-default">
        <div class="nav">
            <div class="nameSite">
                <h1><a href="/">StudentEnergo</a></h1>
            </div>
            <div class="btnbar">
                <nav class="navbar navbar-inverse" role="navigation">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse"
                                    data-target="#bs-example-navbar-collapse-9">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
                            <ul class="nav navbar-nav">
                            <#assign path=model["path"]>
                                <li <#if path == "/home"> class="active"</#if>>
                                    <a href="/home">Домой</a>
                                </li>
                                <li <#if path == "/reg"> class="active"</#if>>
                                    <a href="/reg">Регистрация</a>
                                </li>
                                <li <#if path == "/firms"> class="active"</#if>>
                                    <a href="/firms">Фирмы</a>
                                </li>
                                <li <#if path == "/news"> class="active"</#if>>
                                    <a href="/news">Новости</a>
                                </li>
                                <li <#if path == "/advices"> class="active"</#if>>
                                    <a href="/advices">Советы</a>
                                </li>
                                <li <#if path == "/tarifs"> class="active"</#if>>
                                    <a href="/tarifs">Тарифы</a>
                                </li>
                                <li<#if path == "/we"> class="active"</#if>>
                                    <a href="/we">О нас!</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <div class="Userblock">
        <#if !model["currentUser"]??>
            <#if path?? && path != "error404">
                <form class="login-form" action="j_spring_security_check" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="username">
                        <input id="j_username" name="j_username" class="form-control" placeholder="Email address"
                               size="20" maxlength="50" type="email" required autofocus/>
                    <#--<input type="email" id="inputEmail"  name="name"-->
                    <#--<#if model["erLogin"]??>  passwordField="${model["erLogin"]}" </#if>-->
                    </div>
                    <div class="password">
                        <label for="password" class="sr-only">Password</label>
                        <input type="password" id="j_password" name="j_password" class="form-control"
                               placeholder="Password" required>
                    </div>
                    <div class="sub">
                        <input type="checkbox" name="remember-me"/>
                        <button type="submit" class="btn btn-default login-btn">LogIn</button>
                    </div>
                </form>
            </#if>
        <#else>
            <#assign currentUser=model["currentUser"]>
            <center>
                <div class="active_user">
                    <p></p>

                    <p><b>Добро пожаловать,</b></p>

                    <p><b>${currentUser.getLogin()}!!!</b></p>

                    <div class="dropdown">
                        <button class="btn active dropdown-toggle" data-toggle="dropdown">Мое меню<b
                                class="caret"></b>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                            <li><a tabindex="-1" href="/userschet">Счетчик</a></li>
                            <li><a tabindex="-1" href="/changepass">Сменить пароль</a></li>
                            <li><a tabindex="-1" href="/changetarif">Сменить тариф</a></li>
                            <li><a href="#" data-toggle="modal" data-target="#myModalProfile">Мой профиль</a>
                                <#if model["currentUser"]?? && model["currentUser"].isAdmin()>
                                    <li><a tabindex="-1" href="/admin/activateuser">Админка</a></li>
                                </#if>
                            </li>
                            <#if model["path"] == "/advices">
                                <li><a href="#" data-toggle="modal" data-target="#myModalAddAdv">Добавить совет</a>
                                </li>
                            </#if>
                            <li class="divider"></li>
                            <li><a tabindex="-1" href="/logout?uri=${model["path"]}">Выйти</a></li>
                        </ul>
                    </div>
                </div>
            </center>
        </#if>
        </div>
    </nav>
</div>
