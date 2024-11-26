<%@ page import="java.util.List" %>
<%@ page import="am.itspace.myfriend.model.Images" %>
<%@ page import="am.itspace.myfriend.model.User" %><%--
  Created by IntelliJ IDEA.
  User: NITRO
  Date: 23.11.2024
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/style/style2.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>
<body>
<% List<Images> images = (List<Images>) request.getAttribute("images"); %>
<% User user = (User)request.getSession().getAttribute("user"); %>
<nav>
    <a href="/" class="a_but" id="singin"><p>home</p></a>
    <img src="/getImg?imgName=<%= user.getImage_name() %>" id="img_lg" height="50" width="50">
    <span id="span_lg"><%= user.getName() %> <%= user.getSurname() %></span>
</nav>
<div class="main_div" id="img_lg_id">
    <form action="/myProfil" method="post" enctype="multipart/form-data">
        <input type="file" name="img">
        <input type="submit" value="add">
    </form>
    <br>
    <% for (Images image : images) { %>

    <div class="outer-div">
        <div class="inner-div">
            <img src="/getImg?imgName=<%= image.getImgName() %>" alt="Example image">

        </div>
        <div class="porc">
            <%if(image.getLike()){%>
                <a href="/likeImg?id=<%=image.getId()%>&boolean=1"><i class='bx bxs-like' ></i></a>
            <%}else {%>
                <a href="/likeImg?id=<%=image.getId()%>&boolean=0"><i class='bx bx-like' ></i></a>
            <%}%>

        </div>
    </div>


    <% } %>
</div>
</body>
</html>

