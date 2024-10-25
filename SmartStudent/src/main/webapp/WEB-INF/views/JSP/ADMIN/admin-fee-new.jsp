<!DOCTYPE html>
<html>

<head>
    <title>Create New Fee</title>
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

        /* Table-like layout for form fields */
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
            width: 40%;
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
            width: 60%;
            font-size: 1rem;
        }

        .value input {
            width: 90%;
            padding: 10px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
        }

        .value select {
            width: 50%;
            /* Increased width of the select box */
            padding: 8px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            font-size: 1rem;
        }

        /* Button styling */
        .status {
            display: flex;
            justify-content: space-between;
        }

        .select {
            width: 70%;
            font-size: 1rem;
        }

        button,
        .link {
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
        .link:hover {
            background-color: #5a1fa7;
            transform: translateY(-2px);
        }

        button i,
        .link i {
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

            .label,
            .value {
                width: 100%;
                margin-bottom: 5px;
            }

            button {
                padding: 8px 15px;
                font-size: 0.9rem;
            }
        }

        @media (max-width: 576px) {
            h2 {
                font-size: 1.4rem;
            }

            button {
                padding: 6px 12px;
                font-size: 0.85rem;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <h2><i class="fas fa-plus-circle"></i> Create New Fee</h2>
        <form action="${pageContext.request.contextPath}/admin/fees/new" method="post">

            <div class="row">
                <div class="label">
                    <i class="fas fa-id-card"></i> StudentSemesterID:
                </div>
                <div class="value">
                    <input type="text" id="studentSemesterId" name="studentSemesterId" required />
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <i class="fas fa-dollar-sign"></i> Total Amount:
                </div>
                <div class="value">
                    <input type="text" id="totalAmount" name="totalAmount" required />
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <i class="fas fa-money-bill-wave"></i> Paid Amount:
                </div>
                <div class="value">
                    <input type="text" id="paidAmount" name="paidAmount" required />
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <i class="fas fa-calendar-alt"></i> Due Date:
                </div>
                <div class="value">
                    <input type="date" id="dueDate" name="dueDate" required />
                </div>
            </div>

            <div class="status">
                <button type="submit"><i class="fas fa-save"></i> Create</button>
                <a class="link" href="${pageContext.request.contextPath}/admin/fees">
                    <i class="fas fa-arrow-left"></i> Cancel
                </a>
            </div>
        </form>
    </div>
</body>


</html>
