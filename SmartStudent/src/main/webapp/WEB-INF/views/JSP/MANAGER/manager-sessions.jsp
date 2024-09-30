<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Session List</title>
</head>
<body>
    <h1>Session List</h1>

    <!-- Filter by Subject -->
    <form method="GET" action="${pageContext.request.contextPath}/manager/sessions">
        <label for="subjectId">Filter by Subject:</label>
        <select name="subjectId" id="subjectId" onchange="this.form.submit()">
            <option value="">All Subjects</option>
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.subjectId}" 
                    <c:if test="${selectedSubjectId == subject.subjectId}">selected</c:if>>
                    ${subject.name}
                </option>
            </c:forEach>
        </select>
    </form>

    <!-- Session Table -->
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Type</th>
                <th>Subject</th>
                <th>Division ID</th>
                <th>Faculty ID</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="session" items="${sessions}">
                <tr>
                    <td>${session.sessionId}</td>
                    <td>${session.sessionDate}</td>
                    <td>${session.sessionType}</td>
                    <td>${session.subject.name}</td>
                    <td>${session.division_Id}</td>
                    <td>${session.faculty_Id}</td>
                    <td>${session.startTime}</td>
                    <td>${session.endTime}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/manager/sessions/${session.sessionId}">View</a>
                        <a href="${pageContext.request.contextPath}/manager/sessions/${session.sessionId}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/manager/sessions/${session.sessionId}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/manager/sessions/new">Create New Session</a>
</body>
</html>
