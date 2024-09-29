<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Create New Faculty Subject</title>
</head>
<body>
	<h2>Create New Faculty Subject</h2>

	<form
		action="${pageContext.request.contextPath}/admin/facultySubjects/new"
		method="post">
		<div>
			<label for="faculty">Faculty:</label> <input type="text"
				name="facultyId" value="${facultySubject.faculty.facultyId}"
				required />
		</div>

		<div>
			<label for="subject">Subject:</label> <select name="subjectId">
				<c:forEach var="subject" items="${subjects}">
					<option value="${subject.subjectId}">${subject.name}</option>
				</c:forEach>
			</select>
		</div>

		<div>
			<button type="submit">Save</button>
		</div>
	</form>

</body>
</html>
