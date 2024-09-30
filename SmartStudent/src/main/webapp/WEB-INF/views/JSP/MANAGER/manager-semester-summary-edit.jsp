<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Edit Semester Summary</title>
</head>
<body>
    <h1>Edit Semester Summary</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/manager/semester-summaries/${semesterSummary.studentId}/${semesterSummary.semester}/edit" modelAttribute="semesterSummary">
        <table>
            <tr>
                <td><form:label path="studentId">Student ID:</form:label></td>
                <td><form:input path="studentId" readonly="true"/></td>
            </tr>
            <tr>
                <td><form:label path="semester">Semester:</form:label></td>
                <td><form:input path="semester" readonly="true"/></td>
            </tr>
            <tr>
                <td><form:label path="totalCredits">Total Credits:</form:label></td>
                <td><form:input path="totalCredits"/></td>
            </tr>
            <tr>
                <td><form:label path="totalCreditPoints">Total Credit Points:</form:label></td>
                <td><form:input path="totalCreditPoints"/></td>
            </tr>
            <tr>
                <td><form:label path="sgpa">SGPA:</form:label></td>
                <td><form:input path="sgpa"/></td>
            </tr>
            <tr>
                <td><form:label path="cgpa">CGPA:</form:label></td>
                <td><form:input path="cgpa"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update"/></td>
            </tr>
        </table>
    </form:form>
    <a href="${pageContext.request.contextPath}/manager/semester-summaries">Back to List</a>
</body>
</html>
