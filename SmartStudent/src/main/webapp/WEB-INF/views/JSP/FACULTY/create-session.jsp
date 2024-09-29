<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>New Session and Attendnace</title>
</head>
<form action="${pageContext.request.contextPath}/faculty/attendance/sessions/newsession" method="post">
    <label for="division">Division:</label>
    <select name="divisionId" id="division">
        <option value="">Select Division</option>
        <c:forEach var="division" items="${divisions}">
            <option value="${division.divisionId}">${division.name}</option>
        </c:forEach>
    </select>

    <label for="subject">Subject:</label>
    <select name="subjectId" id="subject">
        <option value="">Select Subject</option>
        <c:forEach var="subject" items="${subjects}">
            <option value="${subject.subjectId}">${subject.name}</option>
        </c:forEach>
    </select>


	<!-- Session Date -->
	<label for="sessionDate">Session Date:</label> <input type="date"
		name="sessionDate" id="sessionDate" required />

	<!-- Session Type -->
	<label for="sessionType">Session Type:</label> <select
		name="sessionType" id="sessionType" required>
		<option value="Lecture">Lecture</option>
		<option value="Lab">Lab</option>
		<option value="Seminar">Seminar</option>
	</select>

	<!-- Start Time -->
	<label for="startTime">Start Time:</label> <input type="time"
		name="startTime" id="startTime" required />

	<!-- End Time -->
	<label for="endTime">End Time:</label> <input type="time"
		name="endTime" id="endTime" required />

	<!-- Submit Button -->
	<input type="submit" value="Create Session and Mark Attendance" />

</form>
