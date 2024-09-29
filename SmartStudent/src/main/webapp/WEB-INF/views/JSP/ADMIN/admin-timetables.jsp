<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Timetable Management</title>
</head>
<body>
    <h1>Timetables</h1>

    <form action="${pageContext.request.contextPath}/admin/timetables" method="get">
        <label for="subjectId">Subject:</label>
        <select name="subjectId" id="subjectId">
            <option value="">All Subjects</option>
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.subjectId}" <c:if test="${subject.subjectId == selectedSubjectId}">selected</c:if>>${subject.name}</option>
            </c:forEach>
        </select>

        <label for="facultyId">Faculty:</label>
        <select name="facultyId" id="facultyId">
            <option value="">All Faculties</option>
            <c:forEach var="faculty" items="${faculties}">
                <option value="${faculty.facultyId}" <c:if test="${faculty.facultyId == selectedFacultyId}">selected</c:if>>${faculty.username}</option>
            </c:forEach>
        </select>

        <label for="divisionId">Division:</label>
        <select name="divisionId" id="divisionId">
            <option value="">All Divisions</option>
            <c:forEach var="division" items="${divisions}">
                <option value="${division.divisionId}" <c:if test="${division.divisionId == selectedDivisionId}">selected</c:if>>${division.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Filter</button>
    </form>

    <table border="1">
        <thead>
            <tr>
                <th>Subject</th>
                <th>Faculty</th>
                <th>Division</th>
                <th>Day</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="timetable" items="${timetables}">
                <tr>
                    <td>${timetable.subject.name}</td>
                    <td>${timetable.faculty.username}</td>
                    <td>${timetable.division.name}</td>
                    <td>${timetable.dayOfWeek}</td>
                    <td>${timetable.startTime}</td>
                    <td>${timetable.endTime}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/timetables/${timetable.timetableId}">View</a> |
                        <a href="${pageContext.request.contextPath}/admin/timetables/${timetable.timetableId}/edit">Edit</a> |
                        <a href="${pageContext.request.contextPath}/admin/timetables/${timetable.timetableId}/delete" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/timetables/new">Add New Timetable</a>
</body>
</html>
