<%@ page import="am.itspace.myfriend.model.FriendRequest" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 22.11.2024
  Time: 1:29
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
<%List<FriendRequest> requests = ((List<FriendRequest>) request.getAttribute("friendRequests"));%>
<nav><a href="/" class="a_but" id="singin"><p>home</p></a></nav>
<div class="main_div">
    <h1>Friend_Responses</h1>
    <table>
        <tr>
            <th>img</th>
            <th>name</th>
            <th>surname</th>
            <th>email</th>
            <th>action</th>
        </tr>
        <%for(FriendRequest friendRequest : requests){%>
        <tr>
            <td><img src="/getImg?imgName=<%=friendRequest.getFromUser().getImage_name()%>" width="100" height="100"></td>
            <td><%=friendRequest.getFromUser().getName()%></td>
            <td><%=friendRequest.getFromUser().getSurname()%></td>
            <td><%=friendRequest.getFromUser().getEmail()%></td>
            <td><a href="/deleteFriendRequest?id=<%=friendRequest.getId()%>" class="a_but"><p>delete</p></a> <a href="/accept?id=<%=friendRequest.getId()%>" class="a_but"><p>accept</p></a></td>
        </tr>

        <%}%>
    </table>
</div>
</body>
</html>
