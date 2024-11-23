<%@ page import="java.util.List" %>
<%@ page import="am.itspace.myfriend.model.User" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 21.11.2024
  Time: 23:17
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
<%List<User> friends = (List<User>) request.getAttribute("friends");%>
<nav><a href="/" class="a_but" id="singin"><p>home</p></a></nav>
<div class="main_div">
    <h1>Users</h1>
    <table>
        <tr>
            <th>img</th>
            <th>name</th>
            <th>surname</th>
            <th>email</th>
            <th>action</th>
        </tr>
        <%for(User friend : friends){%>
        <tr>
            <td><img src="/getImg?imgName=<%=friend.getImage_name()%>" width="100" height="100"></td>
            <td><%=friend.getName()%></td>
            <td><%=friend.getSurname()%></td>
            <td><%=friend.getEmail()%></td>
            <td><a href="/sendMessage?id=<%=friend.getId()%>"><p>Send Message</p></a></td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
