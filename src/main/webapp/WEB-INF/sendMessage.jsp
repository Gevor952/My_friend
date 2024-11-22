<%@ page import="java.util.List" %>
<%@ page import="am.itspace.myfriend.model.Message" %>
<%@ page import="am.itspace.myfriend.model.User" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 22.11.2024
  Time: 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%List<Message> messages = ((List<Message>) request.getAttribute("messages"));%>
<nav></nav>
<div class="main_div">
    <h1>Message</h1>

    <% for (Message message : messages) { %>
    <% if (message.getFromId().getId() == ((User) request.getSession().getAttribute("user")).getId()) { %>
    <p style="color: green"><%= message.getMessage() %></p>
    <% } else { %>
    <p style="color: #0033ff"><%= message.getMessage() %></p>
    <% } %>
    <% } %>

    <form action="/sendMessage" method="post">
        <input type="hidden" name="id" value="<%=request.getAttribute("idFriend")%>">
        <textarea name="message">
        </textarea>
        <input type="submit" value="send">
    </form>
</div>
</body>
</html>
