<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Voxus - Payment Register</title>
</head>
<body>
    <h1>Payment Register</h1>
    <form:form modelAttribute="payment" action="${s:mvcUrl('payment.insert').build()}" method="post">
        <br><br>
        <label for="title">Title: </label>
        <form:input type="text" path="title" name="title" placeholder="Title"/>
        <form:errors path="title"/>
        <br><br>
        <label for="value">Value: </label>
        <form:input type="number" path="value" name="value" step="0.01" placeholder="Value"/>
        <form:errors path="value"/>
        <br><br>
        <label for="date">Date: </label>
        <form:input type="date" path="date" name="date"/>
        <form:errors path="date"/>
        <br><br>
        <label for="comment">Comments: </label>
        <form:textarea path="comment" name="comment" placeholder="Comments"/>
        <form:errors path="comment"/>
        <br><br>
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>