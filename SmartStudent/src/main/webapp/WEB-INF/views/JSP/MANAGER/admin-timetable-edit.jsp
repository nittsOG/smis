<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Timetable</title>
</head>
<body>
    <h1>Edit Timetable</h1>

    <form action="${pageContext.request.contextPath}/manager/timetables/${timetable.timetableId}/edit" method="post">
        <label for="subjectId">Subject:</label>
        <select name="subjectId" id="subjectId">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.subjectId}" <c:if test="${subject.subjectId == timetable.subject.subjectId}">selected</c:if>>${subject.name}</option>
            </c:forEach>
        </select>

        <label for="facultyId">Faculty:</label>
        <select name="facultyId" id="facultyId">
            <c:forEach var="faculty" items="${faculties}">
                <option value="${faculty.facultyId}" <c:if test="${faculty.facultyId == timetable.faculty.facultyId}">selected</c:if>>${faculty.username}</option>
            </c:forEach>
        </select>

        <label for="divisionId">Division:</label>
        <select name="divisionId" id="divisionId">
            <c:forEach var="division" items="${divisions}">
                <option value="${division.divisionId}" <c:if test="${division.divisionId == timetable.division.divisionId}">selected</c:if>>${division.name}</option>
            </c:forEach>
        </select>

        <label for="dayOfWeek">Day of Week:</label>
        <input type="text" name="dayOfWeek" value="${timetable.dayOfWeek}">

        <label for="startTime">Start Time:</label>
        <input type="time" name="startTime" value="${timetable.startTime}">

        <label for="endTime">End Time:</label>
        <input type="time" name="endTime" value="${timetable.endTime}">

        <button type="submit">Save</button>
    </form>

    <a href="${pageContext.request.contextPath}/manager/timetables">Cancel</a>
</body>
</html>
