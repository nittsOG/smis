<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Subject Details</title>
</head>
<body>
    <h1>Faculty Subject Details</h1>
    <p>ID: ${facultySubject.id}</p>
    <p>Name: ${facultySubject.name}</p>
    <p>Code: ${facultySubject.code}</p>
    <a href="${pageContext.request.contextPath}/admin/facultySubjects">Back to List</a>
</body>
</html>
