<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Semester Subject Details</title>
</head>
<body>
    <h1>Semester Subject Details</h1>
    <p>ID: ${semesterSubject.id}</p>
    <p>Name: ${semesterSubject.name}</p>
    <p>Semester: ${semesterSubject.semester.name}</p>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.id}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.id}/delete">Delete</a>
</body>
</html>
