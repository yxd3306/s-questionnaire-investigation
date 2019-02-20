
(function ($) {
    "use strict";



    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })
    })


    var input = $('.validate-input .input100');

    $('#toLogin').on('click',function(){
        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                return ;
            }
        }
        var data={
            username:$('#username').val(),
            password:$('#password').val()
        };
        var path = ""+window.location.pathname
        var student = RegExp(/student/);
        var teacher = RegExp(/teacher/);
        if(student.test(path)){
            studentLogin(data);
        }else if(teacher.test(path))
            teacherLogin(data);
    });
    $('#toRegister').on('click',function(){
        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                return ;
            }
        }
        var data={
            username:$('#username').val(),
            password:$('#password').val(),
            name:$('#name').val(),
            email:$('#email').val(),
        };
        var path = ""+window.location.pathname
        var student = RegExp(/student/);
        var teacher = RegExp(/teacher/);
        if(student.test(path)){
            studentRegister(data);
        }else if(teacher.test(path))
            teacherRegister(data);
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }




    /**/
    function studentLogin(data) {
        common.ajaxSend(
            "/student/login",
            data,
            function (e) {
                if(e.code==0)
                    alert(e.msg)
                else
                    window.location.href="/teacher/index.html";
            },
            function (e) {

            }
        );
    }
    function teacherLogin(data) {
        common.ajaxSend(
            "/teacher/login",
            data,
            function (e) {
                if(e.code==0){
                    alert(e.msg)
                }
                else{
                    common.setCookie("teacherUserName",e.data.username,7);
                    common.setCookie("teacherUserId",e.data.id,7);
                    window.location.href="/teacher/index.html";
                }

            },
            function (e) {

            }
        );
    }

    function studentRegister(data) {
        common.ajaxSend(
            "/student/register",
            data,
            function (e) {
                if(e.code==0){
                    alert(e.msg)
                }
                else{
                    window.history.go(-1);
                    alert(e.msg)
                }

            },
            function (e) {

            }
        );
    }
    function teacherRegister(data) {
        common.ajaxSend(
            "/teacher/register",
            data,
            function (e) {
                if(e.code==0){
                    alert(e.msg)
                }
                else{
                    window.history.go(-1);
                }

            },
            function (e) {

            }
        );
    }

})(jQuery);