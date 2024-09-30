<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Semester Summaries List</title>
</head>
<body>
    <h1>Manager Semester Summaries List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Semester</th>
                <th>Total Credits</th>
                <th>Total Credit Points</th>
                <th>SGPA</th>
                <th>CGPA</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="summary" items="${semesterSummaries}">
                <tr>
                    <td>${summary.studentId}</td>
                    <td>${summary.semester}</td>
                    <td>${summary.totalCredits}</td>
                    <td>${summary.totalCreditPoints}</td>
                    <td>${summary.sgpa}</td>
                    <td>${summary.cgpa}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/manager/semester-summaries/${summary.studentId}/${summary.semester}">Details</a>
                        <a href="${pageContext.request.contextPath}/manager/semester-summaries/${summary.studentId}/${summary.semester}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/manager/semester-summaries/${summary.studentId}/${summary.semester}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/manager/dashboard">Back to Dashboard</a>
</body>
</html>
