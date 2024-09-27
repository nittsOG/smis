<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>New Faculty Division</title>
<script>
	<c:if test="${not empty alert}">
	alert("${alert}");
	</c:if>
</script>
</head>
<body>
	<h1>New Faculty Division</h1>
	<form
		action="${pageContext.request.contextPath}/admin/facultyDivisions/new"
		method="post">
		<label for="faculty">Faculty ID:</label> <input type="text"
			id="faculty" name="faculty.facultyId" required> <label
			for="division">Division:</label> <select id="division"
			name="division.divisionId">
			<c:forEach var="division" items="${divisions}">
				<option value="${division.divisionId}">${division.name}</option>
			</c:forEach>
		</select> <label for="isFr">Is FR:</label> <input type="checkbox" id="isFr"
			name="isFr" value="true">

		<button type="submit">Save</button>
	</form>

	<a href="${pageContext.request.contextPath}/admin/facultyDivisions">Back
		to List</a>
</body>
</html>
