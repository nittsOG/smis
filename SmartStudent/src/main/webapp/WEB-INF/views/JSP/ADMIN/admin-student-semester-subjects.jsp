<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Manage Student Semester Subjects</title>
</head>
<body>
    <h1>Student Semester Subjects</h1>

    <form method="get" action="${pageContext.request.contextPath}/admin/student-semester-subjects">
        <label for="studentId">Filter by Student ID:</label>
        <input type="number" name="studentId" id="studentId" value="${param.studentId}">
        <input type="submit" value="Filter">
    </form>

    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Student Semester</th>
                <th>Subject</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="studentSemesterSubject" items="${studentSemesterSubjects}">
                <tr>
                    <td>${studentSemesterSubject.studentSemester.student.studentId}</td>
                    <td>${studentSemesterSubject.studentSemester.semester.name}</td>
                    <td>${studentSemesterSubject.subject.name}</td>
                    <td>
                     <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.studentSemesterSubjectId}">view</a>
                        <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.studentSemesterSubjectId}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.studentSemesterSubjectId}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/new">Add New</a>
</body>
</html>
