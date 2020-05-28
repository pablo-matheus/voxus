<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Voxus - Payment</title>
</head>
<body>
    <h1>Payments</h1>
    <a href="${s:mvcUrl('payment.register').build()}">New Payment</a>
    <a href="${s:mvcUrl('payment.import').build()}">Import from .xlsx File</a>
    <table border="1">
        <tr>
            <td>Title</td>
            <td>Value</td>
            <td>Date</td>
            <td>External Tax</td>
            <td>Comments</td>
            <td>Edit</td>
            <td>Remove</td>
        </tr>
        <c:forEach items="${payments}" var="payment">
            <tr>
                <td>${payment.title}</td>
                <td><fmt:formatNumber value="${payment.value}" type="currency"/></td>
                <td><fmt:formatDate value="${payment.date}"/></td>
                <td><fmt:formatNumber value="${payment.tax}" type="currency"/></td>
                <td>${payment.comment}</td>
                <td><a href="${s:mvcUrl('payment.edit').arg(0, payment.id).build()}">Edit</a></td>
                <td><a href="${s:mvcUrl('payment.remove').arg(0, payment.id).build()}">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>