<%--
  Created by IntelliJ IDEA.
  User: lxwudi666
  Date: 2022/5/23
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="CSS/LoginSource.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>

<body>

<script type="text/javascript" src="jquery/jquery-3.5.1.js"></script>
<script>
    $(function () {
        $(".Fade").hide();
        $(".Res").hide();
        $(".Log").hide();
        $(".zcd1").click(function () {
            $(".ResLog").hide();
            $(".Log").hide();
            $(".Res").show();

        });
        $(".zcd2").click(function () {
            $(".ResLog").hide();
            $(".Log").show();
            $(".Res").hide();

        });

    });
</script>
<div class="ResLog" id="LOGRES">
    <h2>Welcome!</h2>
    <div class="zcd1" id="zcd1">
        <input type="submit" class="register" value="REGISTER" />
    </div>
    <div class="zcd2" id="zcd2">
        <input type="submit" class="login" value="LOGIN" />
    </div>
</div>
<div class="Res" id="Resgister">
    <h1>Register</h1>
    <div class="Form">
        <form method="post" action="${pageContext.request.contextPath}/RegisterServlet">
            <div class="NaPwd">
                <i class="fa fa-user-circle" style="color: black;"></i>
                <input type="text" placeholder="用户名" name="name">
            </div>
            <div class="NaPwd">
                <i class="fa fa-key" style="color: black;"></i>
                <input type="password" placeholder="密码" name="pwd">
            </div>
            <div class="NaPwd">
                <i class="fa fa-key" style="color: black;"></i>
                <input type="text" placeholder="出生日期" name="date">
            </div>
            <div class="NaPwd">
                <i class="fa fa-key" style="color: black;"></i>
                <input type="text" placeholder="性别" name="sex">
            </div>
            <input type="submit" class="inputButton" value="REGISTER" >


        </form>
    </div>
</div>

<div id="Login" class="Log">
    <h1>LOGIN</h1>
    <div class="Form">
        <form method="post" action="${pageContext.request.contextPath}/LoginServlet">
            <div class="NaPwd">
                <i class="fa fa-user-circle" style="color: black;"></i>
                <input type="text" placeholder="用户名" name="name">
            </div>
            <div class="NaPwd">
                <i class="fa fa-key" style="color: black;"></i>
                <input type="password" placeholder="密码" name="pwd">
            </div>
            <input type="submit" class="inputButton" value="LOGIN" />
        </form>
    </div>
</div>
<script>
    function shut() {
         $(".Fade").show();
        $(".ResLog").hide();
    }
</script>

<%
    String verify1 = (String)request.getAttribute("Password");
    String verify2 = (String)request.getAttribute("not exist");
    String JSPVerify = "password is wrong";
    String JSPExist = "not exist";
    if(verify1 == JSPVerify) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=verify1%>");                                            // 弹出错误信息
    window.location= "Login.jsp";                            // 跳转到登录界面
</script>
<%
    }
    if(verify2 == JSPExist){
%>
<script type="text/javascript" language="javascript">
    alert("<%=verify2%>");                                            // 弹出错误信息
    window.location= "Login.jsp";                            // 跳转到登录界面
</script>
<%
    }

%>

<div class="Fade" id="fade" role="'dialog">
    <div class="modal-dialog" >
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button"class="close"data-dismiss="modal" aria-hidden="true" onclick="send()" align="center"> &times;</button>
                <h4 class="modal-title" id="myModalLabel">恭喜</h4>
            </div>
            <div class="modal-body">
                登陆成功
            </div>
            <div class="modal-footer" align="center">
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="send()">关闭</button>
            </div>
        </div>
    </div>
</div>
<script>
    function send() {

        location.href = "Login.jsp";

    }
</script>
</body>
</html>
