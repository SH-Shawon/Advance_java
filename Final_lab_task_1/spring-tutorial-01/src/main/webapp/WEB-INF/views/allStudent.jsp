
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="sakibul.domain.Student" %>

<html>
<head>
    <title>All Students</title>
</head>
<body>
    <h2>All Students</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Quota</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.dateOfBirth}</td>
                <td>${student.gender}</td>
                <td>${student.quota}</td>
                <td>${student.country}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/students/${student.id}/details" method="get">
                        <button type="submit">Details</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/students/${student.id}/delete" method="post">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <a href="${pageContext.request.contextPath}">Home</a>
    <br><br>
    <a href="${pageContext.request.contextPath}/addStudent"> Add Student </a>
</body>
</html>