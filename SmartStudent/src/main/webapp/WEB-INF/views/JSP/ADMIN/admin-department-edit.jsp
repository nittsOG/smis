<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Department</title>
</head>
<body>
    <h2>Edit Department</h2>
    <form action="<c:url value='/admin/departments/${department.departmentId}/edit'/>" method="post">
        <input type="hidden" name="departmentId" value="${department.departmentId}">
        <p>Name: <input type="text" name="name" value="${department.name}" required/></p>
        <p>Description: <input type="text" name="description" value="${department.description}"/></p>
        <p>Field: <input type="text" name="field" value="${department.field}"/></p>
        <button type="submit">Save</button>
    </form>
    <a href="<c:url value='/admin/departments'/>">Cancel</a>
</body>
</html>
