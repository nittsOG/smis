<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Fee</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h2>Edit Fee</h2>

    <form action="${pageContext.request.contextPath}/manager/fees/${fee.feeId}/edit" method="post">
        <label for="totalAmount">Total Amount:</label>
        <input type="text" id="totalAmount" name="totalAmount" value="${fee.totalAmount}" required><br>

        <label for="paidAmount">Paid Amount:</label>
        <input type="text" id="paidAmount" name="paidAmount" value="${fee.paidAmount}" required><br>

        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" value="${fee.dueDate}" required><br>

        <button type="submit">Save</button>
        <a href="${pageContext.request.contextPath}/manager/fees/${fee.feeId}">Cancel</a>
    </form>
</body>
</html>
