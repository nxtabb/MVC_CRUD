<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/2
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管理系统</title>
    <script src="js/js.js"></script>

</head>
<body>
<h1 align="center">新闻管理系统</h1>
<form action="/login" method="post" id="form_sub">
    <table align="center">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" id="input_username"><span id="error1">${error1}</span></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" id="input_password"><span id="error2">${error2}</span></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="登录" id="btn"></td>
        </tr>
    </table>
</form>
</body>
</html>
