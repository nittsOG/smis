<!DOCTYPE html>
<html>
<head>
    <title>Create New Fee</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h2>Create New Fee</h2>

    <form action="${pageContext.request.contextPath}/manager/fees/new" method="post">
    
        <label for="totalAmount">StudentSemesterID:</label>
        <input type="text" id="studentSemesterId" name="studentSemesterId" required><br>
        
        <label for="totalAmount">Total Amount:</label>
        <input type="text" id="totalAmount" name="totalAmount" required><br>

        <label for="paidAmount">Paid Amount:</label>
        <input type="text" id="paidAmount" name="paidAmount" required><br>

        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" required><br>

        <button type="submit">Create</button>
        <a href="${pageContext.request.contextPath}/manager/fees">Cancel</a>
    </form>
</body>
</html>
