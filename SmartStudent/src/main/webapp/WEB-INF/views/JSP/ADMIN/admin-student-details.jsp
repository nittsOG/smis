<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Student Details</title>
</head>
<body>
    <h1>Student Details</h1>
    <p>Username: ${student.username}</p>
    <p>Email: ${student.email}</p>
    <p>Division: ${student.division.name}</p>
    <c:if test="${student.photoBase64 != null}">
        <p>Photo: <img src="data:image/jpeg;base64,${student.photoBase64}" alt="Student Photo" /></p>
    </c:if>
    <p><a href="${pageContext.request.contextPath}/admin/students">Back to Students List</a></p>
</body>
</html>
