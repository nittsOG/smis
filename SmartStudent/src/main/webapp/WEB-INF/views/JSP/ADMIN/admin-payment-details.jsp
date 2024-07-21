<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Details</title>
</head>
<body>
    <h1>Payment Details</h1>
    <p>ID: ${payment.id}</p>
    <p>Amount: ${payment.amount}</p>
    <p>Date: ${payment.date}</p>
    <p>Student ID: ${payment.studentId}</p>
    <a href="${pageContext.request.contextPath}/admin/payments">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/payments/${payment.id}/edit">Edit</a>
    <a href="${pageContext.request.contextPath}/admin/payments/${payment.id}/delete">Delete</a>
</body>
</html>
