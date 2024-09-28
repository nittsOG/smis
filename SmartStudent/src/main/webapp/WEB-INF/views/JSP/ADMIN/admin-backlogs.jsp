<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Backlogs</title>
</head>
<body>
    <h1>Backlogs List</h1>

    <form action="${pageContext.request.contextPath}/admin/backlogs" method="get">
        <label for="studentId">Filter by Student ID:</label>
        <input type="text" id="studentId" name="studentId" value="${studentId}" />
        <button type="submit">Filter</button>
        <a href="${pageContext.request.contextPath}/admin/backlogs">Clear Filter</a>
    </form>

    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Subject Code</th>
                <th>Semester</th>
                <th>Backlog Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="backlog" items="${backlogs}">
                <tr>
                    <td>${backlog.studentId}</td>
                    <td>${backlog.subjectCode}</td>
                    <td>${backlog.semester}</td>
                    <td>${backlog.backlogStatus}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.studentId}/${backlog.subjectCode}/${backlog.semester}">View</a> |
                        <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.studentId}/${backlog.subjectCode}/${backlog.semester}/edit">Edit</a> |
                        <a href="${pageContext.request.contextPath}/admin/backlogs/${backlog.studentId}/${backlog.subjectCode}/${backlog.semester}/delete" onclick="return confirm('Are you sure you want to delete this backlog?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/backlogs/new">Add New Backlog</a>
</body>
</html>
