<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Division</title>
</head>
<body>
    <h1>New Division</h1>
    <form action="${pageContext.request.contextPath}/admin/divisions/new" method="post">
        <p>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required/>
        </p>
        <button type="submit">Save</button>
        <a href="${pageContext.request.contextPath}/admin/divisions">Cancel</a>
    </form>
</body>
</html>
