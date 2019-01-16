<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
</head>
<body>
<main>
    <div class="mj_all">
        <form onsubmit="return doSubmit()">
            <label for="userphone">手机号：</label><input type="text" id="userphone" name="userphone"><br>
            <label for="password">登录密码：</label><input type="password" id="password" name="password"><br>
            <div>
                <input type="submit" value="登录"><input type="reset" value="重置"><br>
                <span id="mj_span"></span>
            </div>
        </form>
    </div>

</main>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function doSubmit(){
        var Param = new Object();
        Param.userphone = $("#userphone") .val();
        Param.password = $("#password") .val();
        $.ajax({
            url :"${pageContext.request.contextPath}/loginServlet.do",
            type:"POST",
            async:false,
            dataType:"json",
            data:param,
            success:function (data) {
                
            }
            })
    }
</script>
</html>