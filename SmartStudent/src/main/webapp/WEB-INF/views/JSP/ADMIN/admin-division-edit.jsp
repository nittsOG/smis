<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Division</title>
</head>
<body>
    <h1>Edit Division</h1>
    <form action="${pageContext.request.contextPath}/admin/divisions/${division.divisionId}/edit" method="post">
        <input type="hidden" name="_method" value="POST"/>
        <p>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${division.name}" required/>
        </p>
        <button type="submit">Update</button>
        <a href="${pageContext.request.contextPath}/admin/divisions">Cancel</a>
    </form>
</body>
</html>
