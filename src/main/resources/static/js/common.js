var common={
    /*发送ajax*/
    ajaxSend: function(url, data, callback, error,async) {
        $.ajax({
            url: url,
            type: 'post',
            dataType: 'json',
            data: data,
            async:async,
            timeout: 3000,
            success: function(data) {
                callback(data);
            },
            error: function(err) {
                if(error && typeof(error) == 'function') {
                    error(err);
                }
            },
        });
    },
    // 设置缓存
    setCookie: function(cname, value, days) {
        var exp = new Date();
        exp.setTime(exp.getTime() + days * 24 * 60 * 60 * 1000);
        var arr = document.cookie.match(new RegExp("(^| )" + cname + "=([^;]*)(;|$)"));
        document.cookie = cname + "=" + escape(value) + ";expires=" + exp.toGMTString();
    },
    // 获取缓存
    getCookie: function(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i = 0; i < ca.length; i++) {
            var c = ca[i].trim();
            if(c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    },

}