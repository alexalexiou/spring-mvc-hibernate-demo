<%--
  Created by IntelliJ IDEA.
  User: aalex
  Date: 11/27/2019
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>

<%--    reference css file  -                        use proper app name--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

<div id="wrapper">
    <div id="header">

    </div>
</div>

<div id="container">
    <div id="content">
        <%--add html table--%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>

            <%--        loop over and print all customers--%>

            <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>
