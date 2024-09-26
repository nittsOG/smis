<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Course Details</title>
<script>
	<c:if test="${not empty alert}">
	alert("${alert}");
	</c:if>
</script>
</head>
<body>
	<h1>Course Details</h1>
	<p>ID: ${course.getCourseId()}</p>
	<p>Department: ${course.department.name}</p>
	<p>Name: ${course.name}</p>
	<p>Description: ${course.description}</p>
	<a href="${pageContext.request.contextPath}/admin/courses">Back to
		List</a>
</body>
</html>
