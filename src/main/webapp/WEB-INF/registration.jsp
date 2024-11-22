<%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 19.11.2024
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="../style/style2.css"%>
    </style>
</head>
<body>
<nav></nav>
<div class="main_div">
    <h1>registration</h1>
    <%if (request.getAttribute("msg") != null) {%>
    <p style="color: red"><%=request.getAttribute("msg")%>
    </p>
    <%}%>
    <form action="/registration" method="post" enctype="multipart/form-data">
        name: <input type="text" name="name">
        surname: <input type="text" name="surname">
        email: <input type="text" name="email">
        password: <input type="password" name="password">
        <input type="file" name="img">
        <input type="submit" value="add">
</form>
</div>
</body>
</html>
