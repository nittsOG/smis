<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Edit Student Semester Subject</title>
</head>
<body>
	<h1>Edit Student Semester Subject</h1>

	<form method="post"
		action="${pageContext.request.contextPath}/admin/student-semester-subjects/${studentSemesterSubject.studentSemesterSubjectId}/edit">
		<input type="hidden" name="studentSemesterSubjectId"
			value="${studentSemesterSubject.studentSemesterSubjectId}" /> <label
			for="studentSemester">Select Student Semester:</label> <select
			name="studentSemester.studentSemesterId" id="studentSemester">
			<c:forEach var="studentSemester" items="${studentSemesters}">
				<option value="${studentSemester.studentSemesterId}"
					<c:if test="${studentSemester.studentSemesterId == studentSemesterSubject.studentSemester.studentSemesterId}">selected</c:if>>
					${studentSemester.student.studentId} -
					${studentSemester.semester.name}</option>
			</c:forEach>
		</select><br> <label for="subject">Select Subject:</label> <select
			name="subject.subjectId" id="subject">
			<c:forEach var="subject" items="${subjects}">
				<option value="${subject.subjectId}"
					<c:if test="${subject.subjectId == studentSemesterSubject.subject.subjectId}">selected</c:if>>
					${subject.name}</option>
			</c:forEach>
		</select><br> <input type="submit" value="Update">
	</form>


	<a
		href="${pageContext.request.contextPath}/admin/student-semester-subjects">Back
		to list</a>
</body>
</html>
