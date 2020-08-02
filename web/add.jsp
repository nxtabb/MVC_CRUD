<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/2
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/crudnews" method="post">
    <input type="hidden" name="method" value="add">
    标题：<input type="text" name="title"><br>
    作者：<input type="text" name="author"><br>
    内容：<textarea name="content"></textarea><br>
    <input type="submit" value="添加">

</form>
</body>
</html>
