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

    reference css file  -                        use proper app name
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

<div id="wrapper">
    <div id="header">

    </div>
</div>

<div id="container">
    <div id="content">

<%-- Button: add new customer -  window.lo... will call the controller's action--%>
        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>


        <%--add html table--%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <%--        loop over and print all customers--%>

            <c:forEach var="tempCustomer" items="${customers}">
<%-- construct an update link with customer id--%>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td>  <a href="${updateLink}">Update </a>  </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>
