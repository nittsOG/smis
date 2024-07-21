<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Fee</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>New Fee</h1>
    <form action="${pageContext.request.contextPath}/admin/fees/new" method="post">
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" required /><br>
        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" required /><br>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" required /><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/fees">Back to List</a>
</body>
</html>
