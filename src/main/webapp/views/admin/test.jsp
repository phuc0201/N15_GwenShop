<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Title</title>
</head>
<body>
    <div>
        <c:forEach items="${UserList}" var="user" >
            <tr>
                <td>${user.id}</td>
                <td>${user.fullname}</td>
                <td>${user.email}</td>
                <td>${user.passwd}</td>b
                <td>${user.addr}</td>
                <td>${user.phonenumber}</td>
                <td>${user.salary}</td>
                <td>${user.roles}</td>
                <td>${user.create_at}</td>
                <td>${user.delete_at}</td>
            </tr>
        </c:forEach>
    </div>
</body>
</html>
