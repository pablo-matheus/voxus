<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Voxus - Import Payment</title>
</head>
<body>
    <h1>Import .xlsx Payment</h1>
    <form:form action="${s:mvcUrl('payment.upload').build()}" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept=".xlsx"/>
        <br><br>
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>