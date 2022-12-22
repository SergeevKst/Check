<%@ page import="com.test.task.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.test.task.service.ProductService" %>
<%@ page import="com.test.task.service.ProductServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        b {
            color: darkred;
        }
    </style>
    <title>Store</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1>Hello customer!</h1><br>
<h2>You can watch our products</h2>
<hr/>
    <%
              ProductService<Product> service = new ProductServiceImpl();

              List<Product> productList;

              productList= service.giveAccessToProductRepository();

              request.setAttribute("items",productList);
    %>
<form action="<c:url value="/Show"/>" method="post">
    <table>
        <thead>
        <tr>
            <th>Choose</th>
            <th>Item</th>
            <th>Price in dollars</th>
            <th>Discount</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="item" items="${items}">

            <tr>
                <td><label>
                    <input type="checkbox" name="id" value="${item.id}">
                </label></td>
                <td>${item.productName}</td>
                <td>${item.price}</td>
                <td>${item.discount}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
<hr/>
        Discount card <label>
    <input  name="card">
</label>
    <input type="submit" value="Save to cart"/>
</form>
</body>
</html>
