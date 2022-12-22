<%@ page import="java.util.List" %>
<%@ page import="com.test.task.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1>Customer it is your cart</h1>


<form action="<c:url  value="/Store"/>" method="post">
    <hr/>
    <%
        List<Product> list = (List<Product>) request.getAttribute("product");
        List<String> idList=new ArrayList<>();
        String[] index = new String[list.size()];

        for (Product product : list) {
            out.print("<li>" + product.getProductName() + "</li>");
            idList.add(String.valueOf(product.getId()));
        }
        String[] id  = idList.toArray(index);
        request.setAttribute("product", list);
    %>
    <hr/>


    <label>
       Change: <input type="checkbox" name="value" value="Change">
    </label>
    <label>
       Check: <input type="checkbox" name="value" value="Check">
    </label>
    <input type="submit" value="Choose">
</form>

</body>
</html>
