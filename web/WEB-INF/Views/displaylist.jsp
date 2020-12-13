<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>List of Students</title>
</head>
<body>
<%--

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
--%>

<form:form method="POST" action="addStudent" modelAttribute="Students">
    <table>
        <tr>
            <th>Student Number</th>
            <th>Student Name</th>
            <th>GPA</th>
        </tr>
        <c:forEach items="${Students.students}" var="student" varStatus="tagStatus">
            <tr>
                <td><form:input path="students.get(${tagStatus.index}).studentNumber" value="${student.studentNumber}"
                                readonly="true"/></td>
                <td><form:input path="students.get(${tagStatus.index}).studentName" value="${student.studentName}"
                                readonly="true"/></td>
                <td><form:input path="students.get(${tagStatus.index}).gpa" value="${student.gpa}"
                                readonly="true"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
