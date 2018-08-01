$(function () {
    /*一加载进来 先判断缓存中该用户是否登录*/
    $(document).ready(function () {
        console.log(localStorage.getItem("key"))


        var params1 = {};
        //params.XX必须与Spring Mvc controller中的参数名称一致
        //否则在controller中使用@RequestParam绑定
        params1.num = 12;
        params1.id = 13;
        params1.amount = 14;
        console.log(params1)
        $.ajax({
            async:false,
            type: "POST",
            url: "/update",//注意路径
            data:params1,
            dataType:"json",
            success:function(data){
                if(data.result=='SUCCESS'){
                    alert("操作成功");
                }else{
                    alert("操作成功，失败原因【" + data + "】");
                }
            },
            error:function(data){
                alert(data.result);
            }
        });


        var params2 = {};
        params2.num = 112;
        params2.id = 100;//注意params.名称  名称与实体bean中名称一致
        $.ajax({
            async:false,
            type: "POST",
            url: "/add",
            data:params2,
            dataType:"json",  //返回的数据格式
//	         		   contentType: "application/json; charset=utf-8",//此处不能设置，否则后台无法接值  (ajax请求Controller的数据格式)
            success:function(data){
                if(data.msg != ""){
                    alert( data.msg );
                }
            },
            error:function(data){
                alert("出现异常，异常原因【" + data + "】!");
            }
        });


        var params3 = {};
        params3.nums = 66666
        params3.id = 1;//parmas.参数名 注意与实体bean参数名称相同
        $.ajax({
            async:false,
            type: "POST",
            url: "/add02",
            data:JSON.stringify(params3),//json序列化
            datatype:"json", //此处不能省略
            contentType: "application/json; charset=utf-8",//此处不能省略
            success:function(data){
                alert(JSON.stringify(data));
            },
            error:function(data){
                alert(data)
            }
        });



    })

    //提交按钮
    $('#btnSubmit').click(function(){
        var param = {}
        param.userName = $('#username').val()
        param.passWord = $.trim($('#password').val())
        console.log(param)
        $.ajax({
            async:false,
            type: "POST",
            url: "/login",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(param),
            success: function(data){
                console.log(JSON.stringify(data))
                alert("success")
            },
            error:function (data) {
                console.log(JSON.stringify(data))
                alert("error")
            }
        });
    });

});