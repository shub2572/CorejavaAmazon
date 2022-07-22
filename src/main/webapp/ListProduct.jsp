<%@page import="amazon.Bean.ProductBean"%>
<%@page import="amazon.Bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListProducts</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>

	<%
		ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("products");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">List Products</h2>

				<table class="display" id="users">
					<thead class="thead-light">
						<tr>
							<th>ProductId</th>
							<th>Name</th>
							<th>Price</th>
							<th>Qty</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (ProductBean p : products) {
						%>
						<tr>
							<td><%=p.getProductId()%></td>
							<td><%=p.getName()%></td>
							<td><%=p.getPrice()%></td>
							<td><%=p.getQty()%></td>
							<td>Delete</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>
</body>
</html>