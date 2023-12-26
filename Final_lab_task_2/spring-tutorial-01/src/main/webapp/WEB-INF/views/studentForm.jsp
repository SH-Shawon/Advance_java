<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head><head>
<Body>
<h2> Student Form <h2>

<form:form method="post" action="students" modelAttribute="student">
<label>Name: </label>
<form:input path="name" id="name" />
<form:errors path="name" />

<br><br>

<label>Email: </label>
<form:input path="email" id="email" />
<form:errors path="email" />

<br><br>

<label>Birthday:</label>
<form:input type="date" path="dateOfBirth" id="dateOfBirth"/>
<form:errors path="dateOfBirth" />

<br><br>

<label>Gender</label>
<form:radiobutton path="gender" value="MALE" label="Male" />
<form:radiobutton path="gender" value="FEMALE" label="Female" />
<form:errors path="gender" />
<br><br>
<label>Quota</label>
<form:checkboxes path="quota"  items="${quotaOptions}" />
<form:errors path="quota" />


<br><br>


<label>Country<label>
<form:select path="country">
<form:option value="BANGLADESH"> BANGLADESH </form:option>
<form:option value="INDIA"> INDIA </form:option>
<form:option value="JAPAN"> JAPAN </form:option>
</form:select>
<form:errors path="country" />

<br><br>

<input type="submit" Value="Add"/>
</form:form>
<br><br>
<a href="${pageContext.request.contextPath}/allStudent"> See all students </a>
<br><br>
<a href="${pageContext.request.contextPath}">Home</a>


