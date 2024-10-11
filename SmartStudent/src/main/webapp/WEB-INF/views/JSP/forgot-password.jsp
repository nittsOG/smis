<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h2>Forgot Password</h2>
    
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <!-- OTP Generation Form -->
    <form action="${pageContext.request.contextPath}/forgot-password/generate-otp" method="post">
        <h3>Generate OTP</h3>
        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="">Select Role</option>
            <option value="student" <c:if test="${selectedRole == 'student'}">selected</c:if>>Student</option>
            <option value="faculty" <c:if test="${selectedRole == 'faculty'}">selected</c:if>>Faculty</option>
        </select>
        
        <label for="id">ID:</label>
        <input type="number" id="id" name="id" required value="${enteredId != null ? enteredId : ''}" />
        
        <button type="submit">Send OTP</button>
    </form>

    <hr />

    <!-- Password Reset Form -->
    <form action="${pageContext.request.contextPath}/forgot-password/reset-password" method="post">
        <h3>Reset Password</h3>

        <label for="role">Role:</label>
        <c:if test="${not empty message && message == 'OTP sent to your email.'}">
            <!-- Display the selected role as text and keep it as a hidden field -->
            <input type="text" readonly value="${selectedRole}" />
            <input type="hidden" name="role" value="${selectedRole}" />
        </c:if>
        
        <c:if test="${empty message || message != 'OTP sent to your email.'}">
            <!-- Show the role selection dropdown if OTP hasn't been sent -->
            <select id="role" name="role" required>
                <option value="">Select Role</option>
                <option value="student" <c:if test="${selectedRole == 'student'}">selected</c:if>>Student</option>
                <option value="faculty" <c:if test="${selectedRole == 'faculty'}">selected</c:if>>Faculty</option>
            </select>
        </c:if>

        <label for="id">ID:</label>
        <input type="number" id="id" name="id" required value="${enteredId != null ? enteredId : ''}" />
        
        <label for="otp">OTP:</label>
        <input type="text" id="otp" name="otp" required />

        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required />
        
        <button type="submit">Reset Password</button>
    </form>

    <a href='${pageContext.request.contextPath}/login'>Back TO Login</a>
</body>
</html>
