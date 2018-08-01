$(function () {
    /*一加载进来 先判断缓存中该用户是否登录*/
    $(document).ready(function () {
        //获取浏览器缓存的内容
        if (localStorage.getItem("key") == null){
            localStorage.setItem("key","this is page cache")
        }else {
            console.log(localStorage.getItem("key"))
        }
    })

    //提交按钮
    $('#btnSubmit').click(function(){
        var params = {};
        //params.XX必须与Spring Mvc controller中的参数名称一致
        //否则在controller中使用@RequestParam绑定
        params.username = $("#username").val();
        params.password = $.trim($("#password").val());
        params.email = $.trim($("#email").val());
        params.phone = $.trim($("#phone").val());
        console.log(params)
        $.ajax({
            async:false,
            type: "POST",
            url: "/first",//注意路径
            data:params,
            dataType:"json",
            success:function(data){
                if(data.message=='SUCCESS'){
                    alert("操作成功");
                }else{
                    alert("操作成功，失败原因【" + data + "】");
                }
            },
            error:function(data){
                alert(data.result);
            }
        });
    });

    //提交按钮
    $('#btnTest01').click(function(){
        var params1 = {};
        params1.username = "上海靠谱青年"
        params1.password = "123456"
        params1.email = "849902930@qq.com"
        params1.phone = "1571111111"
        console.log(params1)
        $.ajax({
            async:false,
            type: "POST",
            url: "/second",//注意路径
            data:params1,
            dataType:"json",
            success:function(data){
                if(data.message=='SUCCESS'){
                    alert("操作成功");
                }else{
                    alert("操作成功，失败原因【" + data + "】");
                }
            },
            error:function(data){
                alert(data.result);
            }
        });
    });

    //提交按钮
    $('#btnTest02').click(function(){
        var params2 = {};
        params2.username = "上海靠谱青年"
        params2.password = "123456"
        params2.email = "849902930@qq.com"
        params2.phone = "1571111111"
        console.log(params2)
        $.ajax({
            async:false,
            type: "POST",
            url: "/three",//注意路径
            data:JSON.stringify(params2),
            dataType:"json", //返回数据类型为json
            contentType: "application/json; charset=utf-8", //请求数据类型为json  controller使用@RequestBody接收
            success:function(data){
                if(data.message=='SUCCESS'){
                    alert("操作成功");
                }else{
                    alert("操作成功，失败原因【" + data + "】");
                }
            },
            error:function(data){
                alert(data.result);
            }
        });
    });

    //提交按钮
    $('#btnTest03').click(function(){
        var params3 = [
            {username: "上海靠谱青年", password: "123456", email: "849902930@qq.com", phone: "1571111111"},
            {username: "上海靠谱青年", password: "123456", email: "849902930@qq.com", phone: "1571111111"}
            ]
        console.log(params3)
        $.ajax({
            async:false,
            type: "POST",
            url: "/four",//注意路径
            data:JSON.stringify(params3),
            dataType:"json", //返回数据类型为json
            contentType: "application/json; charset=utf-8", //请求数据类型为json  controller使用@RequestBody接收
            success:function(data){
                if(data.message=='SUCCESS'){
                    alert("操作成功");
                }else{
                    alert("操作成功，失败原因【" + data + "】");
                }
            },
            error:function(data){
                alert(data.result);
            }
        });
    });
});