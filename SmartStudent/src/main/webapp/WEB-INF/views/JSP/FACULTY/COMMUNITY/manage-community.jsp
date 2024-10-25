<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Community</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
        color: white;
        margin: 0;
        padding: 20px;
    }

    .container {
        max-width: 700px;
        margin: auto;
        background-color: rgba(0, 0, 0, 0.3);
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    h2 {
        font-family: 'Segoe UI', sans-serif;
        color: white;
        margin: 0;
        font-size: 2.2rem;/* Larger font size for better visibility */
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7), /* Main shadow */
                 0 0 25px rgba(255, 255, 255, 0.2); /* Glowing effect */
        margin-bottom: 20px; /* Space below the header */
        text-align: center; /* Centered title */
       
    }

    h3{
        text-align: center;
        text-decoration: underline;
    }

    ul {
        list-style: none;
        padding: 0;
    }

    li {
        padding: 10px;
        background-color: white;
        color: black;
        margin-bottom: 10px;
        border-radius: 5px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    label {
        font-weight: bold;
    }

    button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 5px 10px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 14px;
    }

    button:hover {
        background-color: #2a3e50;
    }

    input[type="text"] {
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 5px;
        margin-right: 10px;
        font-size: 14px;
    }

    .form-group {
        margin-bottom: 20px;
        text-align: center;
    }

    form {
        display: inline;
    }

    .back-link {
        display: block;
        text-align: center;
        margin-top: 20px;
    }

    .back-link a {
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
    }

    .back-link a:hover {
        color: white;
    }

</style>
</head>
<body>
    <div class="container">
        <h2>Manage Community: ${community.name}</h2>
        <hr>

        <h3>Community Members</h3>
        <ul>
            <c:forEach var="member" items="${communityMembers}">
                <li>
                    ${member.studentId} : ${member.username}
                    <form method="post"
                        action="${pageContext.request.contextPath}/faculty/community/removeStudent">
                        <input type="hidden" name="communityId"
                            value="${community.communityId}" /> 
                        <input type="hidden" name="studentId"
                            value="${member.studentId}" />
                        <button type="submit">Remove</button>
                    </form>
                </li>
            </c:forEach>
        </ul>
        <hr>

        <h3>Add New Member</h3>
        <div class="form-group">
            <form method="post"
                action="${pageContext.request.contextPath}/faculty/community/addStudent">
                <input type="hidden" name="communityId"
                    value="${community.communityId}" /> 
                <label for="studentId">Enter Student ID:</label>
                <input type="text" name="studentId" id="studentId" required />
                <button type="submit">Add Student</button>
            </form>
        </div>
        <hr>

        <h3>Delete Community</h3>
        <div class="form-group">
            <form method="post"
                action="${pageContext.request.contextPath}/faculty/community/delete">
                <input type="hidden" name="communityId"
                    value="${community.communityId}" />
                <button type="submit">Delete Community</button>
            </form>
        </div>

        <div class="back-link">
            <a href="${pageContext.request.contextPath}/faculty/community/list">Back to Community List</a>
        </div>
    </div>
</body>
</html>
