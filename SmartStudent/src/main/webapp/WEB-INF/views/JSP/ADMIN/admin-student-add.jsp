<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Add Student</title>
</head>
<body>
    <h1>Add New Student</h1>
    <form action="${pageContext.request.contextPath}/admin/students/add" method="post" enctype="multipart/form-data">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="division">Division:</label>
        <select id="division" name="division" required>
            <c:forEach var="division" items="${divisions}">
                <option value="${division.id}">${division.name}</option>
            </c:forEach>
        </select><br>

        <label for="photo">Photo:</label>
        <input type="file" id="photo" name="photo"><br>

        <input type="submit" value="Add Student">
    </form>
</body>
</html>
