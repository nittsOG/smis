<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Semester Subject Details</title>
</head>
<body>

    <h2>Semester Subject Details</h2>

    <!-- Display Semester Subject Details -->
    <table border="1">
        <tr>
            <th>Semester Subject ID</th>
            <td>${semesterSubject.semesterSubjectId}</td>
        </tr>
        <tr>
            <th>Subject Name</th>
            <td>${semesterSubject.subject.name}</td>
        </tr>
        <tr>
            <th>Subject Code</th>
            <td>${semesterSubject.subject.code}</td>
        </tr>
        <tr>
            <th>Subject Description</th>
            <td>${semesterSubject.subject.description}</td>
        </tr>
        <tr>
            <th>Semester Name</th>
            <td>${semesterSubject.semester.name}</td>
        </tr>
        <tr>
            <th>Course Name</th>
            <td>${semesterSubject.semester.course.name}</td>
        </tr>
        <tr>
            <th>Semester Start Date</th>
            <td>${semesterSubject.semester.startDate}</td>
        </tr>
        <tr>
            <th>Semester End Date</th>
            <td>${semesterSubject.semester.endDate}</td>
        </tr>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.semesterSubjectId}/edit">Edit</a>
    <br>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects">Back to List</a>

</body>
</html>
