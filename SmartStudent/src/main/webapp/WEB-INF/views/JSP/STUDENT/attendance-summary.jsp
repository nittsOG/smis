<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Attendance Summary</title>
</head>
<body>

<h2>Attendance Summary</h2>

<!-- Semester Filter Form -->
<form method="get" action="${pageContext.request.contextPath}/student/attendance">
    <input type="hidden" name="studentId" value="${param.studentId}">
    
    <label for="semesterId">Select Semester:</label>
    <select name="semesterId" id="semesterId" onchange="this.form.submit()">
        <option value="">-- Select Semester --</option>
        <c:forEach var="semester" items="${semesters}">
            <option value="${semester.semester.semesterId}" 
                    <c:if test="${semester.semester.semesterId == selectedSemesterId}">selected</c:if>>
                ${semester.semester.name}
            </option>
        </c:forEach>
    </select>
</form>

<!-- Attendance Summary Table -->
<c:if test="${not empty attendanceSummary}">
    <table border="1">
        <thead>
            <tr>
                <th>Subject Name</th>
                <th>Subject Code</th>
                <th>Total Present</th>
                <th>Total Absent</th>
                <th>Attendance Percentage</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="subjectSummary" items="${attendanceSummary}">
                <tr>
                    <td>${subjectSummary.value.subjectName}</td>
                    <td>${subjectSummary.value.subjectCode}</td>
                    <td>${subjectSummary.value.totalPresent}</td>
                    <td>${subjectSummary.value.totalAbsent}</td>
                    <td>${subjectSummary.value.attendancePercentage}%</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>