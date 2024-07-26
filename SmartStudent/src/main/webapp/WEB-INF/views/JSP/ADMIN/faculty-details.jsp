<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Details</title>
</head>
<body>
    <h1>Faculty Details</h1>
    <p>ID: ${faculty.facultyId}</p>
    <p>Username: ${faculty.username}</p>
    <p>Email: ${faculty.email}</p>
    <p>Department: ${faculty.department.name}</p>
    <a href="${pageContext.request.contextPath}/admin/faculty/showFormForUpdate?facultyId=${faculty.facultyId}">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/faculty/list">Back to List</a>
</body>
</html>
