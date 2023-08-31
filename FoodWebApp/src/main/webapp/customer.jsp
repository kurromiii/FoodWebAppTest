<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <jsp:include page="includes.jsp"/>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="navbar.jsp"/>
</div>

<form action="/customer" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="family" placeholder="Family">
    <input type="text" name="phone" placeholder="Phone Number">
    <input type="submit">
</form>



</body>
</html>
