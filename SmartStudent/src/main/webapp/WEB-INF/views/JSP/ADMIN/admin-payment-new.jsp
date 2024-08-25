<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Payment</title>
</head>
<body>
    <h1>New Payment</h1>
    <form action="${pageContext.request.contextPath}/admin/payments/new" method="post">
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" required /><br>
        <label for="date">Date:</label>
        <input type="text" id="date" name="date" required /><br>
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required /><br>
        <button type="submit">Save Payment</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/payments">Back to List</a>
</body>
</html>
