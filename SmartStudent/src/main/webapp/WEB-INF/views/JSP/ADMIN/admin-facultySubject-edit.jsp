<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Edit Faculty Subject</title>
</head>
<body>
	<h2>Edit Faculty Subject</h2>

	<form
		action="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.facultySubjectId}/edit"
		method="post">
		<div>
			<label for="faculty">Faculty:</label> <input type="text"
				name="facultyId" value="${facultySubject.faculty.facultyId}"
				disabled="true" />
		</div>

		<div>
			<label for="subject">Subject:</label> <select name="subjectId">
				<c:forEach var="subject" items="${subjects}">
					<option value="${subject.subjectId}"
						${subject.subjectId == facultySubject.subject.subjectId ? 'selected' : ''}>${subject.name}</option>
				</c:forEach>
			</select>
		</div>

		<div>
			<button type="submit">Save</button>
		</div>
	</form>

</body>
</html>
