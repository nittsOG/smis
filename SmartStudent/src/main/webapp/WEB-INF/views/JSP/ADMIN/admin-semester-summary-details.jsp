<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semester Summary Details</title>
</head>
<body>
    <h1>Semester Summary Details</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <td>${semesterSummary.id.studentId}</td>
        </tr>
        <tr>
            <th>Semester</th>
            <td>${semesterSummary.id.semester}</td>
        </tr>
        <tr>
            <th>Total Credits</th>
            <td>${semesterSummary.totalCredits}</td>
        </tr>
        <tr>
            <th>Total Credit Points</th>
            <td>${semesterSummary.totalCreditPoints}</td>
        </tr>
        <tr>
            <th>SGPA</th>
            <td>${semesterSummary.sgpa}</td>
        </tr>
        <tr>
            <th>CGPA</th>
            <td>${semesterSummary.cgpa}</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/admin/semester-summaries/${semesterSummary.id.studentId}/${semesterSummary.id.semester}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/semester-summaries">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
