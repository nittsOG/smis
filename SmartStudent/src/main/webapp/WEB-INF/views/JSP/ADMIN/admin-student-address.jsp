<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Student Address</title>
</head>
<body>
    <h1>Student Address</h1>
    <p>Address Line 1: ${studentAddress.addressLine1}</p>
    <p>Address Line 2: ${studentAddress.addressLine2}</p>
    <p>City: ${studentAddress.city}</p>
    <p>State: ${studentAddress.state}</p>
    <p>Country: ${studentAddress.country}</p>
    <p>Postal Code: ${studentAddress.postalCode}</p>
    <p><a href="${pageContext.request.contextPath}/admin/students/${student.studentId}/address/edit">Edit Address</a></p>
    <p><a href="${pageContext.request.contextPath}/admin/students">Back to Students List</a></p>
</body>
</html>
