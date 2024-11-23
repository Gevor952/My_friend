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
<%List<User> users = (List<User>) request.getAttribute("users");%>
<nav><a href="/" class="a_but" id="singin"><p>home</p></a></nav>
<div class="main_div">
  <h1>Users</h1>
  <%if(request.getAttribute("msg") != null){%>
  <p style="color: red">request.getAttribute("msg")</p>
  <%}%>
  <table>
    <tr>
      <th>img</th>
      <th>name</th>
      <th>surname</th>
      <th>email</th>
      <th>action</th>
    </tr>
    <%for(User user : users){%>
    <tr>
      <td><img src="/getImg?imgName=<%=user.getImage_name()%>" width="100" height="100"></td>
      <td><%=user.getName()%></td>
      <td><%=user.getSurname()%></td>
      <td><%=user.getEmail()%></td>
      <td><a href="/sendRequest?userId=<%=user.getId()%>"><p>sendRequest</p></a></td>
    </tr>

    <%}%>
  </table>
</div>
</body>
</html>
