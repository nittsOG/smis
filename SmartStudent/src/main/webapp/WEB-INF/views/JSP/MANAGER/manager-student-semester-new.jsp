<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student Semester</title>
</head>
<body>
    <h2>Add Student Semester</h2>

    <form action="${pageContext.request.contextPath}/manager/student-semesters/new" method="post">
        <label for="student">Student:</label>
        <select name="student.studentId" id="student">
            <c:forEach var="student" items="${students}">
                <option value="${student.studentId}">${student.username}</option>
            </c:forEach>
        </select>
        <br/>

        <label for="semester">Semester:</label>
        <select name="semesterId" id="semester"> <!-- Changed this line -->
            <c:forEach var="semester" items="${semesters}">
                <option value="${semester.semesterId}">${semester.name}</option>
            </c:forEach>
        </select>
        <br/>

        <button type="submit">Save</button>
    </form>

    <a href="${pageContext.request.contextPath}/manager/student-semesters">Back to List</a>
</body>
</html>