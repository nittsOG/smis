<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>New Semester</title>
</head>
<body>
	<h1>New Semester</h1>
	<form:form
		action="${pageContext.request.contextPath}/admin/semesters/new"
		method="post" modelAttribute="semester">
		<table border="1">
			<tr>
				<th>Name</th>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<th>Start Date</th>
				<td><form:input path="startDate" type="date" /></td>
			</tr>
			<tr>
				<th>End Date</th>
				<td><form:input path="endDate" type="date" /></td>
			</tr>
			<tr>
				<th>Duration</th>
				<td><form:input path="duration" type="number" /></td>
			</tr>
			<tr>
				<th>Course</th>
				<td><form:select path="course.courseId">
						<!-- Change path from course.id to course.courseId -->
						<c:forEach var="course" items="${courses}">
							<form:option value="${course.courseId}" label="${course.name}" />
						</c:forEach>
					</form:select></td>
			</tr>

		</table>
        <input type="submit" value="Create" />
	</form:form>
	<a href="${pageContext.request.contextPath}/admin/semesters">Back
		to List</a>
</body>
</html>
