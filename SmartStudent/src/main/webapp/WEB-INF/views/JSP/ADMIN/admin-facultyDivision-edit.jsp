<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Faculty Division</title>
<script>
	<c:if test="${not empty alert}">
	alert("${alert}");
	</c:if>
</script>
</head>
<body>
	<h1>Edit Faculty Division</h1>
	<form
		action="${pageContext.request.contextPath}/admin/facultyDivisions/${facultyDivision.facultyDivisionId}/edit"
		method="post">
		<label for="faculty">Faculty ID:</label> <input type="text"
			id="faculty" name="faculty.facultyId"
			value="${facultyDivision.faculty.facultyId}" readonly> <label
			for="division">Division:</label> <select id="division"
			name="division.divisionId">
			<c:forEach var="division" items="${divisions}">
				<option value="${division.divisionId}"
					${facultyDivision.division.divisionId == division.divisionId ? 'selected' : ''}>${division.name}</option>
			</c:forEach>
		</select> <label for="isFr">Is FR:</label> <input type="checkbox" id="isFr"
			name="isFr" value="true" ${facultyDivision.fr ? 'checked' : ''}>

		<button type="submit">Update</button>
	</form>

	<a href="${pageContext.request.contextPath}/admin/facultyDivisions">Back
		to List</a>
</body>
</html>
