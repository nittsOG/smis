<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Create New Session</title>
</head>
<body>
	<h1>Create New Session</h1>

	<form method="POST"
		action="${pageContext.request.contextPath}/manager/sessions/new">
		<label for="sessionDate">Session Date:</label> <input type="date"
			id="sessionDate" name="sessionDate" required><br> <label
			for="sessionType">Session Type:</label> <input type="text"
			id="sessionType" name="sessionType" required><br> <label
			for="startTime">Start Time:</label> <input type="time" id="startTime"
			name="startTime" required><br> <label for="endTime">End
			Time:</label> <input type="time" id="endTime" name="endTime" required><br>

		<label for="subjectId">Subject:</label> <select name="subjectId"
			id="subjectId" required>
			<c:forEach var="subject" items="${subjects}">
				<option value="${subject.subjectId}">${subject.name}</option>
			</c:forEach>
		</select><br> <label for="divisionId">Division:</label> <select
			name="divisionId" id="divisionId" required>
			<c:forEach var="division" items="${divisions}">
				<option value="${division.divisionId}">${division.name}</option>
			</c:forEach>
		</select><br> <label for="facultyId">Faculty ID:</label> <input
			type="number" id="facultyId" name="facultyId" required><br>

		<input type="submit" value="Create Session">
	</form>
</body>
</html>
