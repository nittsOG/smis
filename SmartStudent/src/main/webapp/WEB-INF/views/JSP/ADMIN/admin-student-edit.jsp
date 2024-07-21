<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Edit Student</title>
</head>
<body>
    <h1>Edit Student</h1>
    <form action="${pageContext.request.contextPath}/admin/students/${student.studentId}/edit" method="post" enctype="multipart/form-data">
        <p>Username: <input type="text" name="username" value="${student.username}" required /></p>
        <p>Password: <input type="password" name="password" value="${student.password}" required /></p>
        <p>Email: <input type="email" name="email" value="${student.email}" required /></p>
        <p>Photo: <input type="file" name="photo" accept="image/*" /></p>
        <p><input type="submit" value="Save" /></p>
    </form>
    <p><a href="${pageContext.request.contextPath}/admin/students">Back to Students List</a></p>
</body>
</html>
