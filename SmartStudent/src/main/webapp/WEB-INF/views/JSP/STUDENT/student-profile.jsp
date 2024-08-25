<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Profile</title>
</head>
<body>
    <h1>Profile</h1>
    <table>
        <tr>
            <th>Username:</th>
            <td>${student.username}</td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>${student.email}</td>
        </tr>
        <tr>
            <th>Division:</th>
            <td>${student.division.name}</td>
        </tr>
        <tr>
            <th>Address:</th>
            <td>${student.address.street}, ${student.address.city}, ${student.address.state}, ${student.address.country} - ${student.address.zipCode}</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/student/dashboard">Back to Dashboard</a>
</body>
</html>
