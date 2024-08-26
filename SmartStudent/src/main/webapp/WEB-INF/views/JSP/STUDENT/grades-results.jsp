<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Grades and Results</title>
</head>
<body>
    <h2>Grades and Results</h2>
    
    <h3>Semester-wise Results</h3>
    <table border="1">
        <thead>
            <tr>
                <th>Semester</th>
                <th>Subject Code</th>
                <th>Subject Name</th>
                <th>Credit</th>
                <th>Grade</th>
                <th>Grade Point</th>
                <th>Credit Point</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="result" items="${results}">
                <tr>
                    <td>${result.semester}</td>
                    <td>${result.subjectCode}</td>
                    <td>${result.subjectName}</td>
                    <td>${result.credit}</td>
                    <td>${result.grade}</td>
                    <td>${result.gradePoint}</td>
                    <td>${result.creditPoint}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h3>Semester Summary</h3>
    <table border="1">
        <thead>
            <tr>
                <th>Semester</th>
                <th>Total Credits</th>
                <th>Total Credit Points</th>
                <th>SGPA</th>
                <th>CGPA</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="summary" items="${summaries}">
                <tr>
                    <td>${summary.id.semester}</td>
                    <td>${summary.totalCredits}</td>
                    <td>${summary.totalCreditPoints}</td>
                    <td>${summary.sgpa}</td>
                    <td>${summary.cgpa}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
