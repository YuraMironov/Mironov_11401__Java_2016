<script type="application/javascript">
    eqvEmail = function (request, response) {
        var x = false;
        $.ajax({
            url: "/reg/checkedEmail",
            data: {"q": $("#email").val()},
            dataType: "json",
            async: false,
            success: function (response_data) {
                x = response_data.email == null;
                if (!x) {
                    $("#res").html("Пользователь с таким электронным адрecом уже зарегестрирован в системе");
                } else {
                    $("#res").html("Электронный адрес свободен");
                }
            }
        });
        return x
    };
    eqvPass = function () {
        var pass = $("#pass").val();
        var string = pass;
        var regexp = new RegExp('^[a-zA-Z0-9]+$');
        var boolean = regexp.test(string);
        var x;
        if (boolean) {
            if (pass.length < 6) {
                x = false;
                $("#res3").html("Плохой пароль, подберите другой");
            } else {
                x = true;
                $("#res3").html("");
            }
        } else {
            x = false;
            $("#res3").html("Пароль должен содержать только цифры и латинские буквы");
        }
        return x;
    };
    checkedPass = function () {
        var x;
        var pass2 = $("#pass2").val();
        if (pass2.length > 0) {
            if ($("#pass").val() != pass2) {
                x = false;
                $("#res2").html("Не верный пароль");
            } else {
                x = true;
                $("#res2").html("");
            }
        } else {
            x = false;
            $("#res2").html("");
        }
        return x;
    };
    validLogin = function () {
        var string = $("#login").val();
        var regexp = new RegExp('^([a-zA-Z]+[0-9_]*)*$');
        var boolean = regexp.test(string);
        if (boolean) {
            $("#res4").html("");
        } else {
            $("#res4").html("Логин не должен содержать: !№;%:?*()\//-=+")
        }
        return boolean;
    };
    validSchetchik = function () {
        var string = $("#schetchik").val();
        var regexp = new RegExp('^[0-9]{5}$');
        var boolean = regexp.test(string);
        if (boolean) {
            $("#res5").html("");
        } else {
            $("#res5").html("[0-9]{5}")
        }
        return boolean;
    };
    wannaSub = function () {
        return eqvEmail() && eqvPass() && valideProduce() && validSchetchik() && validLogin();
    };
</script>