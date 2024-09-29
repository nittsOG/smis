<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Division</title>
</head>
<body>
	<h1>Edit Division</h1>
	<form
		action="${pageContext.request.contextPath}/admin/divisions/${division.divisionId}/edit"
		method="post">
		<input type="hidden" name="divisionId" value="${division.divisionId}" />
		<!-- Ensure the divisionId is passed -->
		<p>
			<label for="name">Name:</label> <input type="text" id="name"
				name="name" value="${division.name}" required />
		</p>
		<p>
			<label for="department">Department:</label> <select id="department"
				name="departmentId" required>
				<option value="">Select Department</option>
				<c:forEach var="department" items="${departments}">
					<option value="${department.departmentId}"
						<c:if test="${department.departmentId == division.department.departmentId}">selected</c:if>>${department.name}</option>
				</c:forEach>
			</select>
		</p>
		<button type="submit">Update</button>
		<a href="${pageContext.request.contextPath}/admin/divisions">Cancel</a>
	</form>

</body>
</html>
