<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html>

<head>
    <title>Course Details</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
        integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #f5f5f5, #dfe6e9);
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        h2 {
            text-align: center;
            color: #6c5ce7;
            margin-top: 10px;
            font-size: 2rem;
        }

        .container {

            max-width: 600px;
            width: 100%;
            /* Ensures full width */
            min-width: 200px;
            padding: 25px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }

        .container:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }

        .row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
            font-size: 1.1rem;
            padding: 10px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        .label {
            width: 30%;
            font-weight: bold;
            color: #444;
            display: flex;
            align-items: center;
        }

        .label i {
            margin-right: 8px;
            color: #6c5ce7;
            font-size: 1.2rem;
        }

        .value {
            width: 70%;
            font-size: 1rem;
            color: #333;
        }

        /* Button styling */
        a {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            padding: 10px 20px;
            margin: 10px 5px;
            background-color: #6c5ce7;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease, transform 0.3s ease;
            font-size: 1rem;
        }

        a:hover {
            background-color: #5a1fa7;
            transform: translateY(-2px);
        }

        a i {
            margin-right: 8px;
        }

        .link {
            background-color: #e17055;
        }

        .link:hover {
            background-color: #d63031;
        }

        /* Responsive styling */
        @media (max-width: 768px) {
            .container {
                width: 90%;
                margin: 30px auto;
                padding: 20px;
            }

            h2 {
                font-size: 1.6rem;
            }

            .row {
                flex-direction: column;
                align-items: flex-start;
            }

            .value {
                text-align: left;
            }

            a {
                padding: 8px 15px;
                font-size: 0.9rem;
            }
        }

        @media (max-width: 576px) {
            a {
                padding: 6px 12px;
                font-size: 0.85rem;
            }

            h2 {
                font-size: 1.4rem;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <h2><i class="fas fa-book"></i> Course Details</h2>

        <div class="row">
            <div class="label"><i class="fas fa-id-badge"></i> ID:</div>
            <div class="value">${course.getCourseId()}</div>
        </div>
        <div class="row">
            <div class="label"><i class="fas fa-building"></i> Department:</div>
            <div class="value">${course.department.name}</div>
        </div>
        <div class="row">
            <div class="label"><i class="fas fa-tag"></i> Name:</div>
            <div class="value">${course.name}</div>
        </div>
        <div class="row">
            <div class="label"><i class="fas fa-file-alt"></i> Description:</div>
            <div class="value">${course.description}</div>
        </div>
        <div class="row">
            <div class="label"><i class="fas fa-star"></i> Specialization:</div>
            <div class="value">${course.specialization}</div>
        </div>

        <div>
            <a href="${pageContext.request.contextPath}/admin/courses/${course.getCourseId()}/edit">
                <i class="fas fa-edit"></i> Edit
            </a>
            <a class="link" href="${pageContext.request.contextPath}/admin/courses">
                <i class="fas fa-arrow-left"></i> Back
            </a>
        </div>
    </div>
</body>


</html>
