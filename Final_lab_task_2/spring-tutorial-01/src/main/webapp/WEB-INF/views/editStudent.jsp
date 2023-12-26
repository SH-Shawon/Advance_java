<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sakibul.domain.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h2>Edit Student</h2>

    <form:form action="${pageContext.request.contextPath}/students/${student.id}/update" method="post" modelAttribute="student">
        <form:label path="name">Name:</form:label>
        <form:input path="name" />
        <form:errors path="name" /><br>

        <form:label path="email">Email:</form:label>
        <form:input path="email"  />
        <form:errors path="email" /><br>

        <form:label path="dateOfBirth">Birthday:</form:label>
        <form:input type="date" path="dateOfBirth"  />
        <form:errors path="dateOfBirth" /><br>

         <form:label path="gender">Gender:</form:label>
            <form:radiobutton path="gender" value="MALE" label="Male" />
            <form:radiobutton path="gender" value="FEMALE" label="Female" />
            <form:errors path="gender" /><br>



        <input type="submit" value="Update"/>
    </form:form>

    <br><br>
    <a href="${pageContext.request.contextPath}/allStudent">Back to All Students</a>
</body>
</html>
