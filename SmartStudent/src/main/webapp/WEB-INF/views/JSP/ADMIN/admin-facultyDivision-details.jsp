<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Faculty Division Details</title>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
                    integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />
                <style>
                    /* General styling */
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
                        margin-top: 20px;
                        margin-bottom: 20px;
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

                    /* Table-like layout */
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
                        display: flex;
                        align-items: center;
                        color: #444;
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

                    .value select {
                        width: 50%;
                        /* Increased width of the select box */
                        padding: 8px;
                        border: 1px solid #e0e0e0;
                        border-radius: 5px;
                        font-size: 1rem;
                    }

                    button,
                    .back-link {
                        display: inline-flex;
                        align-items: center;
                        justify-content: center;
                        padding: 10px 20px;
                        margin: 10px 5px;
                        background-color: #6c5ce7;
                        color: white;
                        border: none;
                        text-decoration: none;
                        border-radius: 5px;
                        cursor: pointer;
                        font-size: 1rem;
                        transition: background-color 0.3s ease, transform 0.3s ease;
                    }

                    button:hover,
                    .back-link:hover {
                        background-color: #5a1fa7;
                        transform: translateY(-2px);
                    }

                    button i,
                    .back-link i {
                        margin-right: 8px;
                    }

                    .back-link {
                        background-color: #e17055;
                    }

                    .back-link:hover {
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

                        .label,
                        .value {
                            width: 100%;
                            margin-bottom: 5px;
                        }

                        button,
                        .back-link {
                            padding: 8px 15px;
                            font-size: 0.9rem;
                        }
                    }

                    @media (max-width: 576px) {
                        h2 {
                            font-size: 1.4rem;
                        }

                        button,
                        .back-link {
                            padding: 6px 12px;
                            font-size: 0.85rem;
                        }
                    }
                </style>
            </head>



            <body>
                <div class="container">
                    <h2><i class="fas fa-info-circle"></i> Faculty Division Details</h2>

                    <!-- Faculty Division ID -->
                    <div class="row">
                        <div class="label">
                            <i class="fas fa-id-badge"></i> Faculty Division ID:
                        </div>
                        <div class="value">
                            ${facultyDivision.facultyDivisionId}
                        </div>
                    </div>

                    <!-- Faculty Details -->
                    <h2><i class="fas fa-user"></i> Faculty Information</h2>

                    <div class="row">
                        <div class="label">
                            <i class="fas fa-user-tag"></i> Username:
                        </div>
                        <div class="value">
                            ${facultyDivision.faculty.username}
                        </div>
                    </div>

                    <div class="row">
                        <div class="label">
                            <i class="fas fa-envelope"></i> Email:
                        </div>
                        <div class="value">
                            ${facultyDivision.faculty.email}
                        </div>
                    </div>

                    <div class="row">
                        <div class="label">
                            <i class="fas fa-phone"></i> Phone:
                        </div>
                        <div class="value">
                            ${facultyDivision.faculty.phone}
                        </div>
                    </div>

                    <div class="row">
                        <div class="label">
                            <i class="fas fa-briefcase"></i> Position:
                        </div>
                        <div class="value">
                            ${facultyDivision.faculty.position}
                        </div>
                    </div>

                    <div class="row">
                        <div class="label">
                            <i class="fas fa-building"></i> Department:
                        </div>
                        <div class="value">
                            ${facultyDivision.faculty.department.name}
                        </div>
                    </div>

                    <!-- Division Details -->
                    <h2><i class="fas fa-university"></i> Division Information</h2>

                    <div class="row">
                        <div class="label">
                            <i class="fas fa-tags"></i> Division Name:
                        </div>
                        <div class="value">
                            ${facultyDivision.division.name}
                        </div>
                    </div>

                    <div class="row">
                        <div class="label">
                            <i class="fas fa-building"></i> Department:
                        </div>
                        <div class="value">
                            ${facultyDivision.division.department.name}
                        </div>
                    </div>

                    <!-- isFr Status -->
                    <div class="row">
                        <div class="label">
                            <i class="fas fa-check-circle"></i> isFr Status:
                        </div>
                        <div class="value">
                            ${facultyDivision.fr ? "Yes" : "No"}
                        </div>
                    </div>

                    <!-- Links to go back or edit -->
                    <div class="status">
                        <a class="back-link" href="${pageContext.request.contextPath}/admin/facultyDivisions">
                            <i class="fas fa-arrow-left"></i> Back to List
                        </a> |
                        <a class="back-link"
                            href="${pageContext.request.contextPath}/admin/facultyDivisions/${facultyDivision.facultyDivisionId}/edit">
                            <i class="fas fa-edit"></i> Edit
                        </a>
                    </div>
                </div>
            </body>




            </html>
