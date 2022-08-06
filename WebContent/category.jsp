<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/categorybootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animate/categoryanimate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/categoryselect2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/categoryutil.css">
<link rel="stylesheet" type="text/css" href="css/categorymain.css">
<!--===============================================================================================-->
</head>
<body>
	<form method="post">

		<div class="limiter">
			<div class="container-table100">
				<div class="wrap-table100">
					<div class="table">
						<button type="submit" formaction="back"
							class="login100-form-btn">Back</button>
						<button class="login100-form-btn" type="submit"
							formaction="logout"
							onclick="return confirm('Are you sure you want to logout?')">Logout</button>
						<div class="row header">
							<div class="cell">Detail</div>
							<div class="cell">ID</div>
							<div class="cell">CategoryName</div>

						</div>
						<c:forEach var="row" items="${category }">

							<div class="row">
								<div class="cell">

									<button type="submit" name="cid" value="${row.cid}"
										formaction="gobyid">Go>></button>

								</div>
								<div class="cell">${row.cid }</div>
								<div class="cell">${row.categoryname }</div>
							</div>
						</c:forEach>

					</div>

				</div>
			</div>
		</div>

	</form>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/categorybootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>
</body>
</html>