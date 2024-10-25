<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <title>Edit Faculty</title>
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
            min-width: 200px;
            margin-top: 20px;
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

        .value select {
            width: 50%;
            /* Increased width of the select box */
            padding: 8px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            font-size: 1rem;
        }

        .value input {
            width: 90%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1rem;
        }

        /* Button styling */
        button,
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

        button:hover,
        a:hover {
            background-color: #5a1fa7;
            transform: translateY(-2px);
        }

        button i,
        a i {
            margin-right: 8px;
        }

        .link {
            background-color: #e17055;
        }

        .link:hover {
            background-color: #d63031;
        }

        .photo-preview {
            width: 150px;
            height: auto;
            display: block;
            margin: 10px auto;
        }

        /* Responsive styling */
        @media (max-width: 768px) {
            .container {
                width: 90%;
                margin: 30px auto;
                padding: 20px;
            }

            h1,
            h2 {
                font-size: 1.6rem;
            }

            .row {
                flex-direction: column;
                align-items: flex-start;
            }

            .value input,
            .value select {
                width: 100%;
                font-size: 1rem;
            }

            button,
            a {
                padding: 8px 15px;
                font-size: 0.9rem;
            }
        }

        @media (max-width: 576px) {

            button,
            a {
                padding: 6px 12px;
                font-size: 0.85rem;
            }

            h1,
            h2 {
                font-size: 1.4rem;
            }
        }
    </style>
    <script type="text/javascript">
        function encodeImageFileAsBase64() {
            var file = document.getElementById("photo").files[0];
            var reader = new FileReader();

            reader.onloadend = function () {
                document.getElementById("photoBase64").value = reader.result;
                document.getElementById("photoPreview").src = reader.result;
            }

            if (file) {
                reader.readAsDataURL(file);
            }
        }
    </script>
</head>

<body>
    <div class="container">
        <h2><i class="fas fa-edit"></i> Edit Faculty</h2>
        <form action="${pageContext.request.contextPath}/admin/faculty/${faculty.facultyId}/edit" method="post">
            <div class="row">
                <div class="label"><i class="fas fa-id-badge"></i> ID:</div>
                <div class="value"><input type="text" name="username" value="${faculty.facultyId}" required /> </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-user-tag"></i> Username:</div>
                <div class="value"><input type="text" name="username" value="${faculty.username}" required />
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-key"></i> Password:</div>
                <div class="value"><input type="password" name="password" value="${faculty.password}" required />
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-envelope"></i> Email:</div>
                <div class="value"><input type="email" name="email" value="${faculty.email}" required /></div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-building"></i> Department:</div>
                <div class="value">
                    <select name="department.departmentId" required>
                        <c:forEach var="department" items="${departments}">
                            <option value="${department.departmentId}"
                                ${department.departmentId==faculty.department.departmentId ? 'selected' : '' }>
                                ${department.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-briefcase"></i> Position:</div>
                <div class="value"><input type="text" name="position" value="${faculty.position}" required />
                </div>
            </div>

            <h2><i class="fas fa-map-marker-alt"></i> Address Information</h2>
            <div class="row">
                <div class="label"><i class="fas fa-road"></i> Street:</div>
                <div class="value"><input type="text" name="street" value="${faculty.facultyAddress.street}" required />
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-city"></i> City:</div>
                <div class="value"><input type="text" name="city" value="${faculty.facultyAddress.city}" required />
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-map"></i> State:</div>
                <div class="value"><input type="text" name="state" value="${faculty.facultyAddress.state}" required />
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-flag"></i> Country:</div>
                <div class="value"><input type="text" name="country" value="${faculty.facultyAddress.country}"
                        required /></div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-envelope"></i> Zip Code:</div>
                <div class="value"><input type="text" name="zipCode" value="${faculty.facultyAddress.zipCode}"
                        required /></div>
            </div>

            <h2><i class="fas fa-info-circle"></i> Additional Faculty Information</h2>
            <div class="row">
                <div class="label"><i class="fas fa-calendar-alt"></i> Date of Birth:</div>
                <div class="value"><input type="date" name="dateOfBirth"
                        value="<fmt:formatDate value='${faculty.dateOfBirth}' pattern='yyyy-MM-dd' />" required />
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-venus-mars"></i> Gender:</div>
                <div class="value">
                    <select name="gender" required>
                        <option value="Male" ${faculty.gender=='Male' ? 'selected' : '' }>Male</option>
                        <option value="Female" ${faculty.gender=='Female' ? 'selected' : '' }>Female</option>
                        <option value="Other" ${faculty.gender=='Other' ? 'selected' : '' }>Other</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-phone"></i> Contact Number:</div>
                <div class="value"><input type="text" name="contactNumber" value="${faculty.phone}" required />
                </div>
            </div>
            <div class="row">
                <div class="label"><i class="fas fa-globe"></i> Nationality:</div>
                <div class="value"><input type="text" name="nationality" value="${faculty.nationality}" required />
                </div>
            </div>

            <h2><i class="fas fa-image"></i> Photo</h2>
            <div class="row">
                <div class="label"><i class="fas fa-camera"></i> Photo:</div>
                <div class="value">
                    <input type="file" id="photo" onchange="encodeImageFileAsBase64()" accept="image/*" />
                </div>
            </div>
            <input type="hidden" id="photoBase64" name="photoBase64" />
            <img id="photoPreview" src="#" alt="Photo Preview" class="photo-preview" />

            <div style="text-align: center;">
                <button type="submit"><i class="fas fa-save"></i> Save Changes</button>
                <a href="${pageContext.request.contextPath}/admin/faculty" class="link"><i
                        class="fas fa-arrow-left"></i> Back to Faculty List</a>
            </div>
        </form>
    </div>
</body>

</html>
