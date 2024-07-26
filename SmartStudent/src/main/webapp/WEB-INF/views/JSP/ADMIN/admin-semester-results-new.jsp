<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Semester Results</title>
</head>
<body>
    <h1>Add New Semester Results</h1>
    <hr>
    <form action="${pageContext.request.contextPath}/admin/semester-results/new" method="post">
        <table border="1">
            <tr>
                <th>Student ID</th>
                <td><input type="number" name="studentId" required></td>
            </tr>
            <tr>
                <th>Semester</th>
                <td><input type="number" name="semester" required></td>
            </tr>
            <tr>
                <th>Subject Code</th>
                <td><input type="text" name="subjectCode" required></td>
            </tr>
            <tr>
                <th>Subject Name</th>
                <td><input type="text" name="subjectName" required></td>
            </tr>
            <tr>
                <th>Credit</th>
                <td><input type="text" name="credit" required></td>
            </tr>
            <tr>
                <th>Grade</th>
                <td><input type="text" name="grade" required></td>
            </tr>
            <tr>
                <th>Grade Point</th>
                <td><input type="text" name="gradePoint" required></td>
            </tr>
            <tr>
                <th>Credit Point</th>
                <td><input type="text" name="creditPoint" required></td>
            </tr>
        </table>
        <hr>
        <button type="submit">Save</button>
        <a href="${pageContext.request.contextPath}/admin/semester-results">Cancel</a>
    </form>
    <hr>
    <a href="${pageContext.request.contextPath}/admin/semester-results">Back to List</a>
</body>
</html>
