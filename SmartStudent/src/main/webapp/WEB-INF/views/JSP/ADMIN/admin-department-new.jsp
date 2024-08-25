<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Department</title>
</head>
<body>
    <h2>Add New Department</h2>
    <form action="<c:url value='/admin/departments/new'/>" method="post">
        <p>Name: <input type="text" name="name" required/></p>
        <p>Description: <input type="text" name="description"/></p>
        <p>Field: <input type="text" name="field"/></p>
        <button type="submit">Save</button>
    </form>
    <a href="<c:url value='/admin/departments'/>">Cancel</a>
</body>
</html>
