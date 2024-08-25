<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student Semester</title>
</head>
<body>
    <h1>Edit Student Semester</h1>
    <form:form method="post" modelAttribute="studentSemester">
        <table>
            <tr>
                <td>ID:</td>
                <td><form:input path="studentSemesterId" readonly="true" /></td>
            </tr>
            <tr>
                <td>Student:</td>
                <td><form:input path="student.username" /></td>
            </tr>
            <tr>
                <td>Semester:</td>
                <td><form:input path="semester.name" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update" /></td>
            </tr>
        </table>
    </form:form>
    <a href="<c:url value='/admin/student-semesters' />">Back to List</a>
</body>
</html>
