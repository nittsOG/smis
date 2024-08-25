<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Semester Summary</title>
</head>
<body>
    <h1>New Semester Summary</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/admin/semester-summaries/new" modelAttribute="semesterSummary">
        <table>
            <tr>
                <td><form:label path="id.studentId">Student ID:</form:label></td>
                <td><form:input path="id.studentId"/></td>
            </tr>
            <tr>
                <td><form:label path="id.semester">Semester:</form:label></td>
                <td><form:input path="id.semester"/></td>
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
                <td colspan="2"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form:form>
    <a href="${pageContext.request.contextPath}/admin/semester-summaries">Back to List</a>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>
</body>
</html>
