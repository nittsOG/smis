<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grades and Results</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/STUDENT/dashboard.css">
</head>
<body>
    <!-- Sidebar Section -->
    <div id="sidebar" class="sidebar">
        <button id="close-btn" class="close-btn" onclick="toggleSidebar()"><</button>
        <a href="${pageContext.request.contextPath}/student/profile">Profile</a>
        <a href="${pageContext.request.contextPath}/student/attendance">Attendance</a>
        <a href="${pageContext.request.contextPath}/student/results">Results</a>
        <a href="${pageContext.request.contextPath}/student/timetable">Timetable</a>
        <a href="${pageContext.request.contextPath}/student/fees">Fees</a> 
        <a href="${pageContext.request.contextPath}/student/logout">Logout</a>
    </div>

    <!-- Main Content -->
    <div id="main-content" class="main-content">
        <button class="open-btn" onclick="toggleSidebar()">></button> <!-- Updated Open Button -->

        <!-- Grades and Results Information -->
        <h2>Grades and Results</h2>

        <h3>Semester-wise Results</h3>
        <table class="results-table">
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
        <table class="summary-table">
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
    </div>

    <script src="${pageContext.request.contextPath}/resources/STUDENT/dashboard.js"></script>
</body>
</html>
