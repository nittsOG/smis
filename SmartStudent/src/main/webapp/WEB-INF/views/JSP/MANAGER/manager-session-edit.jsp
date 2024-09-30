<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Session</title>
</head>
<body>
	<h1>Edit Session</h1>

	<form method="POST"
		action="${pageContext.request.contextPath}/manager/sessions/${session.sessionId}/edit">
		<label for="sessionDate">Session Date:</label> <input type="date"
			id="sessionDate" name="sessionDate" value="${session.sessionDate}"
			required><br> <label for="sessionType">Session
			Type:</label> <input type="text" id="sessionType" name="sessionType"
			value="${session.sessionType}" required><br> <label
			for="startTime">Start Time:</label> <input type="time" id="startTime"
			name="startTime" value="${session.startTime}" required><br>

		<label for="endTime">End Time:</label> <input type="time" id="endTime"
			name="endTime" value="${session.endTime}" required><br>

		<label for="subjectId">Subject:</label> <select name="subjectId"
			id="subjectId" required>
			<c:forEach var="subject" items="${subjects}">
				<option value="${subject.subjectId}"
					<c:if test="${subject.subjectId == session.subject.subjectId}">selected</c:if>>
					${subject.name}</option>
			</c:forEach>
		</select><br> <label for="divisionId">Division:</label> <select
			name="divisionId" id="divisionId" required>
			<c:forEach var="division" items="${divisions}">
				<option value="${division.divisionId}"
					<c:if test="${division.divisionId == session.division_Id}">selected</c:if>>
					${division.name}</option>
			</c:forEach>
		</select><br> <label for="facultyId">Faculty ID:</label> <input
			type="number" id="facultyId" name="facultyId"
			value="${session.faculty_Id}" required><br> <input
			type="submit" value="Update Session">
	</form>
</body>
</html>
