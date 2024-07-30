<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Edit Student</title>
</head>
<body>
    <h1>Edit Student</h1>
    <form action="${pageContext.request.contextPath}/admin/students/${student.studentId}/edit" method="post">
        <p>Username: <input type="text" name="username" value="${student.username}" required /></p>
        <p>Password: <input type="password" name="password" value="${student.password}" required /></p>
        <p>Email: <input type="email" name="email" value="${student.email}" required /></p>

        <h2>Address Information</h2>
        <p>Street: <input type="text" name="address.street" value="${address.street}" required /></p>
        <p>City: <input type="text" name="address.city" value="${address.city}" required /></p>
        <p>State: <input type="text" name="address.state" value="${address.state}" required /></p>
        <p>Country: <input type="text" name="address.country" value="${address.country}" required /></p>
        <p>Zip Code: <input type="text" name="address.zipCode" value="${address.zipCode}" required /></p>

        <h2>Division Information</h2>
        <p>Division: 
            <select name="division.divisionId" required>
                <c:forEach var="division" items="${divisions}">
                    <option value="${division.divisionId}" ${division.divisionId == student.division.divisionId ? 'selected' : ''}>${division.name}</option>
                </c:forEach>
            </select>
        </p>

        <button type="submit">Update</button>
    </form>
</body>
</html>
