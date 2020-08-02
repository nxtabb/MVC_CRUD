<%@ page import="com.hrbeu.Entity.New" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrbeu.Entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/2
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻详情：</title>
</head>
<body>
<%User user = (User) session.getAttribute("user");
    String isadmin = user.getIsadmin();
    String authority = null;
    if(isadmin.equals("Y")){
        authority = "管理员";
    }
    else {
        authority = "普通用户";
    }
%>
<div>
    <span>欢迎您:<%=user.getUsername()%>,您是<%=authority%></span><br/>
    <a href="/crudnews?method=add">添加新闻</a>

</div>
<h1 align="center">新闻详情如下</h1>
<table align="center">
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>作者</th>
        <th>发布时间</th>
        <th>内容</th>
        <th>状态</th>
        <%if(isadmin.equals("Y")){
            %><th colspan="2">操作</th><%
        }%>

    </tr>
    <%List<New> news = (List<New>)request.getAttribute("news");
    for(New new_sel:news){%>
    <tr>
        <td><%=new_sel.getNid()%></td>
        <td><%=new_sel.getTitle()%></td>
        <td><%=new_sel.getAuthor()%></td>
        <td><%=new_sel.getPubdate()%></td>
        <td><%=new_sel.getContent()%></td>
        <% if(new_sel.getLockflag()==0){%><td>解锁</td><%}else{%><td>上锁</td><%}%>
        <%if(isadmin.equals("Y")){
        %><td><a href="/crudnews?method=update&id=<%=new_sel.getNid()%>">修改新闻</a></td><%
        }%>
        <%if(isadmin.equals("Y")){
        %><td><a href="/crudnews?method=delete&id=<%=new_sel.getNid()%>">删除新闻</a></td><%
        }%>
    </tr>
    <%}%>
</table>
<%  int pageno = (int)request.getAttribute("pageno");
    int max_page = 0;
    int count = (int) request.getAttribute("count");
    if(count/5==0){
        max_page = 1;
    }else if(count%5!=0) {
        max_page = count/5+1;
    }else {
        max_page = count/5;
    }
    int page_next = 0;
    int page_pre = 0;
    if(pageno+1>max_page){
       page_next = pageno;
    }
    else {
        page_next = pageno+1;
    }
    if(pageno-1<1){
        page_pre=1;
    }
    else {
        page_pre =pageno-1;
    }
    %>
<div align="center">
    <a href="/welcome?page=1">首页</a>
    <a href="/welcome?page=<%=page_pre%>">上一页</a>
    <a href="/welcome?page=<%=page_next%>">下一页</a>
    <a href="/welcome?page=<%=max_page%>">尾页</a>
</div>
</body>
</html>
