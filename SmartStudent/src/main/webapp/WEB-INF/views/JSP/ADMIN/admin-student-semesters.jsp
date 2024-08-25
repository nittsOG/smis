<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Semesters</title>
</head>
<body>
    <h1>Student Semesters</h1>
    <a href="<c:url value='/admin/student-semesters/new' />">Add New Student Semester</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Student</th>
                <th>Semester</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentSemesters}" var="studentSemester">
                <tr>
                    <td>${studentSemester.studentSemesterId}</td>
                    <td>${studentSemester.student.username}</td>
                    <td>${studentSemester.semester.name}</td>
                    <td>
                        <a href="<c:url value='/admin/student-semesters/${studentSemester.studentSemesterId}' />">Details</a>
                        <a href="<c:url value='/admin/student-semesters/${studentSemester.studentSemesterId}/edit' />">Edit</a>
                        <a href="<c:url value='/admin/student-semesters/${studentSemester.studentSemesterId}/delete' />" onclick="return confirm('Are you sure you want to delete this semester?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
