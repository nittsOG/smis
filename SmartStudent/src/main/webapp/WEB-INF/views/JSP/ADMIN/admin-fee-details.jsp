<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fee Details</title>
</head>
<body>
    <h1>Fee Details</h1>
    <p>ID: ${fee.id}</p>
    <p>Amount: ${fee.amount}</p>
    <p>Due Date: ${fee.dueDate}</p>
    <p>Status: ${fee.status}</p>
    <a href="${pageContext.request.contextPath}/admin/fees">Back to List</a>
</body>
</html>
