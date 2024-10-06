<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
    <div class="login-wrapper">
        <div class="login-container">
            <div class="left-half">
                <img src="${pageContext.request.contextPath}/resources/background.webp" alt="Background Image">
            </div>
            <div class="right-half">
                <form action="${pageContext.request.contextPath}/login" method="post" id="login-form">
                    <h2>Welcome!</h2>
                    <p>Good to see you back.</p>
                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <div class="role-container">
                        <label for="role">Login as a :</label>
                        <select id="role" name="role">
                            <option value="student" ${role == 'student' ? 'selected' : ''}>Student</option>
                            <option value="faculty" ${role == 'faculty' ? 'selected' : ''}>Faculty</option>
                        </select>
                    </div>
                    <div class="input-container">
                        <i class='bx bxs-id-card'></i>
                        <input type="text" id="id" name="id" placeholder="ID" required>
                    </div>
                    <div class="input-container">
                        <i class='bx bxs-lock-alt'></i>
                        <input type="password" id="password" name="password" placeholder="Password" required>
                        <i class='bx bxs-show toggle-password'></i>
                    </div>
                    <a href="${pageContext.request.contextPath}/forgot-password" class="forgot-password">Forgot password?</a>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/resources/script.js"></script>
</body>

</html>
