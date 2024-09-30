<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Semester Summary Details</title>
</head>
<body>
    <h1>Manager Semester Summary Details</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <td>${semesterSummary.studentId}</td>
        </tr>
        <tr>
            <th>Semester</th>
            <td>${semesterSummary.semester}</td>
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
    <a href="${pageContext.request.contextPath}/manager/semester-summaries/${semesterSummary.studentId}/${semesterSummary.semester}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/manager/semester-summaries">Back to List</a>
    <a href="${pageContext.request.contextPath}/manager/dashboard">Back to Dashboard</a>
</body>
</html>
