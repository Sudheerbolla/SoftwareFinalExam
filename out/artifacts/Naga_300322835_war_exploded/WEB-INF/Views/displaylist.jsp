<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Students</title>
</head>
<body>

<table>
    <tr>
        <th>Student Number</th>
        <th>Student Name</th>
        <th>GPA</th>
    </tr>
    <c:forEach items="${Students.students}" var="student" varStatus="tagStatus">
        <tr>
            <td>${student.studentNumber}</td>
            <td>${student.studentName}</td>
            <td>${student.gpa}</td>
        </tr>
    </c:forEach>
</table>


<%--
<form:form method="POST" action="saveUsers" modelAttribute="Users">
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${Users.users}" var="user" varStatus="tagStatus">
            <tr>
                <td><form:input path="users[${tagStatus.index}].firstName" value="${user.firstName}" readonly="true"/></td>
                <td><form:input path="users[${tagStatus.index}].lastName" value="${user.lastName}" readonly="true"/></td>
                <td><form:input path="users[${tagStatus.index}].email" value="${user.email}" readonly="true"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Save" />
</form:form>--%>
</body>
</html>
