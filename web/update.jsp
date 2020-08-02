<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/2
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/crudnews" method="post">
    <input type="hidden" name="method" value="update">
    id:<input type="text" name="id" value="${new1.nid }" readonly><br>
    标题:<input type="text" name="title" value="${new1.title }"><br>
    作者:<input type="text" name="author" value="${new1.author}"><br>
    内容:<textarea name="content">${new1.content}</textarea><br>
    <select name="lockflag">
        <option value="0" selected>
        解锁
        </option>
        <option value="1">
        锁定
        </option>
    </select><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
