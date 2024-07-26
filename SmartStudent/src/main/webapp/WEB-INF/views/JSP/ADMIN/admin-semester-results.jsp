<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semester Results List</title>
</head>
<body>
    <h1>Semester Results List</h1>
    <hr>
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Semester</th>
                <th>Subject Code</th>
                <th>Subject Name</th>
                <th>Credit</th>
                <th>Grade</th>
                <th>Grade Point</th>
                <th>Credit Point</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${semesterResults}" var="result">
                <tr>
                    <td>${result.studentId}</td>
                    <td>${result.semester}</td>
                    <td>${result.subjectCode}</td>
                    <td>${result.subjectName}</td>
                    <td>${result.credit}</td>
                    <td>${result.grade}</td>
                    <td>${result.gradePoint}</td>
                    <td>${result.creditPoint}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/semester-results/${result.studentId}/${result.semester}/${result.subjectCode}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/semester-results/${result.studentId}/${result.semester}/${result.subjectCode}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/semester-results/${result.studentId}/${result.semester}/${result.subjectCode}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr>
    <a href="${pageContext.request.contextPath}/admin/semester-results/new">Add New Result</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
