<%@page import="amazon.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Update User</title>

<!-- Icons font CSS-->
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="css/main.css" rel="stylesheet" media="all">
<link href="css/validation.css" rel="stylesheet" media="all">
<style>
.error {
	color: red;
}
</style>
</head>

<body onload="showSnackbar()">

	<%
	UserBean user = (UserBean) request.getAttribute("user");
	String gender = user.getGender();
	String genderError = (String) request.getAttribute("genderError");
	String sQuestionValue = (String) request.getAttribute("sQuestionValue");
	String emailDuplicateError = (String) request.getAttribute("emailDuplicateError");
	%>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<h1 style="margin-top: 0px; margin-bottom: 20px; text-align: center;">
			<b>To Do List</b>
		</h1>
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Update Form</h2>

					<form method="post" action="UpdateUserController">
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">First name</label> <input
										class="input--style-4" type="text" name="firstName"
										value="${user.firstName}"><span class="error">${firstNameError}</span>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Last name</label> <input
										class="input--style-4" type="text" name="lastName"
										value="${user.lastName}"><span class="error">${lastNameError}</span>
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Email</label> <input
										class="input--style-4" type="email" name="email"
										value="${user.email}"><span class="error">${emailError}</span>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Contact Number</label> <input
										class="input--style-4" type="number" name="contact"
										value="${user.contact}"><span class="error">${contactError}
										${contactLenError} </span>
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Password</label>
									<div class="input-group-icon">
										<input class="input--style-4" type="password" name="password"
											value="${user.password}"><span class="error">${passwordError}</span>
									</div>
								</div>
							</div>
						</div>

						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Gender</label>
									<div class="p-t-10">
										<label class="radio-container m-r-45">Male <input
											type="radio" name="gender" value="male"
											<%=gender != null && gender.equals("male") ? "checked" : ""%>>
											<span class="checkmark"></span>
										</label> <label class="radio-container">Female <input
											type="radio" name="gender" value="female"
											<%=gender != null && gender.equals("female") ? "checked" : ""%>>
											<span class="checkmark"></span>
										</label>
									</div>
									<span class="error">${genderError}</span>
								</div>
							</div>

						</div>
						<input type="hidden" name="userId" value="${user.userId}">
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<button class="btn btn--radius-2 btn--blue" type="submit">Update</button>
								</div>
							</div>
						</div>

					</form>

				</div>
			</div>
		</div>
	</div>
	<%
	if (emailDuplicateError != null) {
	%><div id="snackbar">${emailDuplicateError}</div>
	<%
	}
	%>
	<!-- Jquery JS-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/datepicker/moment.min.js"></script>
	<script src="vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="js/global.js"></script>
	<script src="js/validation.js"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
</body>
</html>