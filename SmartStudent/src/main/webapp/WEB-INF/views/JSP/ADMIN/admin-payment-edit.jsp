<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Payment</title>
</head>
<body>
    <h1>Edit Payment</h1>
    <form action="${pageContext.request.contextPath}/admin/payments/${payment.id}/edit" method="post">
        <input type="hidden" name="id" value="${payment.id}" />
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" value="${payment.amount}" required /><br>
        <label for="date">Date:</label>
        <input type="text" id="date" name="date" value="${payment.date}" required /><br>
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" value="${payment.studentId}" required /><br>
        <button type="submit">Update Payment</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/payments">Back to List</a>
</body>
</html>
