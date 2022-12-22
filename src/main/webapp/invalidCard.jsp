<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22.12.2022
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        b {
            color: darkred;
        }
    </style>
     <title>Not Found</title>
</head>
<body>
<b>Invalid card </b>
<form action="<c:url value="/store.jsp"/>" >

    <input type="submit" value="Return">
</form>
</body>
</html>
