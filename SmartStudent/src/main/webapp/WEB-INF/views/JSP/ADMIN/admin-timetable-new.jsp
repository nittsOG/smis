<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New Timetable</title>
</head>
<body>
    <h1>Create New Timetable</h1>

    <form action="${pageContext.request.contextPath}/admin/timetables/new" method="post">
        <label for="subjectId">Subject:</label>
        <select name="subjectId" id="subjectId">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.subjectId}">${subject.name}</option>
            </c:forEach>
        </select>

        <label for="facultyId">Faculty:</label>
        <select name="facultyId" id="facultyId">
            <c:forEach var="faculty" items="${faculties}">
                <option value="${faculty.facultyId}">${faculty.username}</option>
            </c:forEach>
        </select>

        <label for="divisionId">Division:</label>
        <select name="divisionId" id="divisionId">
            <c:forEach var="division" items="${divisions}">
                <option value="${division.divisionId}">${division.name}</option>
            </c:forEach>
        </select>

        <label for="dayOfWeek">Day of Week:</label>
        <input type="text" name="dayOfWeek">

        <label for="startTime">Start Time:</label>
        <input type="time" name="startTime">

        <label for="endTime">End Time:</label>
        <input type="time" name="endTime">

        <button type="submit">Save</button>
    </form>

    <a href="${pageContext.request.contextPath}/admin/timetables">Cancel</a>
</body>
</html>
