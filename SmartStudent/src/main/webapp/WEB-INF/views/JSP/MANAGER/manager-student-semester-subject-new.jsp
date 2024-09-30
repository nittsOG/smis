<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Create New Student Semester Subject</title>
</head>
<body>
    <h1>Add New Student Semester Subject</h1>

    <form method="post" action="${pageContext.request.contextPath}/manager/student-semester-subjects/new">
        <label for="studentSemester">Select Student Semester:</label>
        <select name="studentSemester.studentSemesterId" id="studentSemester">
            <c:forEach var="studentSemester" items="${studentSemesters}">
                <option value="${studentSemester.studentSemesterId}">${studentSemester.student.studentId} - ${studentSemester.semester.name}</option>
            </c:forEach>
        </select><br>

        <label for="subject">Select Subject:</label>
        <select name="subject.subjectId" id="subject">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.subjectId}">${subject.name}</option>
            </c:forEach>
        </select><br>

        <input type="submit" value="Save">
    </form>

    <a href="${pageContext.request.contextPath}/manager/student-semester-subjects">Back to list</a>
</body>
</html>
