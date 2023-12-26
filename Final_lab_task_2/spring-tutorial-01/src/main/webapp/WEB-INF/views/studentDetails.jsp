<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sakibul.domain.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h2>Student Details</h2>


        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Quota</th>
                <th>Country</th>
            </tr>
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.dateOfBirth}</td>
                <td>${student.gender}</td>
                <td>${student.quota}</td>
                <td>${student.country}</td>
            </tr>
        </table>
        <br><br>

            <form action="${pageContext.request.contextPath}/students/${student.id}/edit" method="get">
                <button type="submit">Edit</button>
            </form>

    <br><br>
    <a href="${pageContext.request.contextPath}/allStudent">Back to All Students</a>
</body>
</html>
