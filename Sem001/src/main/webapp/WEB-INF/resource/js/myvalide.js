///**
// * Created by Юра on 04.11.2015.
// */
//eqvEmail = function(request, response){
//    $.ajax({
//        url: "/checkedEmail",
//        data: {"q": $("#email").val()},
//        dataType: "json",
//        success: function(response_data){
//            if( response_data.results.length  > 0){
//                $("#res").html("Пользователь с таким электронным адрecом уже зарегестрирован в системе");
//            }else{
//                $("#res").html("");
//            }
//        }
//    });
//}
//eqvPass = function(){
//    if( $("#pass").val().length  <= 6){
//        $("#res3").html("Плохой пароль, подберите другой");
//    }else{
//        $("#res3").html("");
//    }
//}
//checkedPass = function(){
//    if($("#pass2").val().length > 0 ){
//        if ($("#pass").val() != $("#pass2").val()){
//            $("#res2").html("Не верный пароль");
//        }else{
//            $("#res2").html("");
//        }
//    }else{
//        $("#res2").html("");
//    }
//}
//valideProduce = function(){
//    var string = $("#produce").val();
//    var regexp = new RegExp('(ЗАО|ОАО|ОДО|ООО) [а-яА-Я ]');
//    var boolean = regexp.test(string);
//    if (boolean){
//        $("#res4").html("");
//    }else{
//        $("#res4").html("Название фирмы должно удовлетворять \n" +
//            "(ЗАО|ОАО|ОДО|ООО) [а-яА-Я ]")
//    }
//}
//validSchetchik = function () {
//    var string = $("#schetchik").val();
//    var regexp = new RegExp('[0-9]{5}');
//    var boolean = regexp.test(string);
//    if (boolean){
//        $("#res5").html("");
//    }else{
//        $("#res5").html("[0-9]{5}")
//    }
//}
//valideDate = function(){
//    var string = $("#date").val();
//    var regexp = new RegExp('([0-2][0-9]|3[01])\.(0[0-9]|1[[0-2])\.[0-9]{4}');
//    var boolean = regexp.test(string);
//    if(!boolean) {
//        $("#res").html("проверьте на ([0-2][0-9]|3[01])\\.(0[0-9]|1[[0-2])\\.[0-9]{4}");
//    }else{
//        $("#res").html("");
//    }
//}
