<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="login">Login</a>
<c:if test="${id != null || name != null || email != null}">
    <p>ID: ${id} <br/>Welcome ${name} <br/>Email: ${email}</p>
</c:if>
</body>
</html>
