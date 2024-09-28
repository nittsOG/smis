<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Semester Subject Details</title>
</head>
<body>
    <h1>Student Semester Subject Details</h1>

    <p><strong>Student ID:</strong> ${studentSemesterSubject.studentSemester.student.studentId}</p>
    <p><strong>Semester:</strong> ${studentSemesterSubject.studentSemester.semester.name}</p>
    <p><strong>Subject:</strong> ${studentSemesterSubject.subject.name}</p>

    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.studentSemesterSubjectId}/edit">Edit</a> |
    <a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Back to list</a>
</body>
</html>
