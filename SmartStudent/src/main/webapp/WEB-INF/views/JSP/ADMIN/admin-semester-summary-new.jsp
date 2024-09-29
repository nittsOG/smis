<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Semester Summary</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />"/>
</head>
<body>
    <h2>Create New Semester Summary</h2>

    <form method="post" action="${pageContext.request.contextPath}/admin/semester-summaries/new">
        <table>
            <!-- Student ID Field -->
            <tr>
                <td><label for="studentId">Student ID:</label></td>
                <td><input type="text" id="studentId" name="studentId" /></td>
            </tr>

            <!-- Semester Field -->
            <tr>
                <td><label for="semester">Semester:</label></td>
                <td><input type="text" id="semester" name="semester" /></td>
            </tr>

            <!-- Total Credits Field -->
            <tr>
                <td><label for="totalCredits">Total Credits:</label></td>
                <td><input type="text" id="totalCredits" name="totalCredits" /></td>
            </tr>

            <!-- Total Credit Points Field -->
            <tr>
                <td><label for="totalCreditPoints">Total Credit Points:</label></td>
                <td><input type="text" id="totalCreditPoints" name="totalCreditPoints" /></td>
            </tr>

            <!-- SGPA Field -->
            <tr>
                <td><label for="sgpa">SGPA:</label></td>
                <td><input type="text" id="sgpa" name="sgpa" /></td>
            </tr>

            <!-- CGPA Field -->
            <tr>
                <td><label for="cgpa">CGPA:</label></td>
                <td><input type="text" id="cgpa" name="cgpa" /></td>
            </tr>

            <!-- Submit Button -->
            <tr>
                <td colspan="2"><input type="submit" value="Save Semester Summary" /></td>
            </tr>
        </table>
    </form>

    <br/>
    <a href="${pageContext.request.contextPath}/admin/semester-summaries">Back to Semester Summaries</a>
</body>
</html>
