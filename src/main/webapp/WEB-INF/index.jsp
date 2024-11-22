<%@ page import="am.itspace.myfriend.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>1</title>


    <style>
        <%@include file="../style/style2.css"%>
    </style>

</head>
<body>
<nav>
    <%if (session.getAttribute("user") == null){%>
    <a href="/login" class="a_but" id="singin"><p>singin</p></a>
    <%} else {%>
    <a href="/logout" class="a_but" id="logout"><p>logout</p></a>
    <% }%>
</nav>
<div class="main_div" id="tlg">

    <h1>student-lesson-servlet</h1>
    <div class="buts">
        <%if (session.getAttribute("user") != null){%>
        <a href="/users" class="a_but"><p>View All Users</p></a>
        <a href="/friendResponses" class="a_but"><p>View Friend Responses</p> </a>
        <a href="/friendRequests" class="a_but"><p>View Friend Requests</p> </a>
        <a href="/friends" class="a_but"><p>View Friends</p></a>
        <%}%>
    </div>
</div>
</body>
</html>
