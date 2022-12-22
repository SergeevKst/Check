<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.test.task.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check</title>

</head>
<body>
<h1>Customer it is your check</h1>
<hr/>
<%
    List<Product> list = (List<Product>) request.getAttribute("product");
    int sumPrice = 0;
    for (Product product:list) {
        sumPrice += product.getPrice();
    }
    request.setAttribute("items",list);

    long count = list.stream().map(Product::getDiscount).count();

    if (count>=5){
        sumPrice=(sumPrice*10)/100;
    }
%>
<table>
    <thead>
    <tr>
        <th>Item</th>
        <th>Price in dollars</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">

        <tr>
            <td>${item.productName}</td>
            <td>${item.price}</td>

        </tr>

    </c:forEach>
    </tbody>
</table>
<%= "it is your bill "+ sumPrice + " in Dollars"%>
    <tbody>
    <hr/>
</body>
</html>
