<%@ page import="am.itspace.myfriend.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/style/style2.css">
    <link rel="stylesheet" href="/style/btn_style.css">

</head>
<body>
<nav>
    <%if (session.getAttribute("user") == null){%>
    <div class="text-box" id="home_btn1">
        <a href="/login" class="btn btn-white ">Singing</a>
    </div>
    <%} else {%>
    <div class="text-box" id="home_btn2">
        <a href="/logout" class="btn btn-white ">Logout</a>
    </div>
    <div class="text-box" id="myProfil_nav">
        <a href="/myProfil" class="btn btn-white " >My Profil</a>
    </div>
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
