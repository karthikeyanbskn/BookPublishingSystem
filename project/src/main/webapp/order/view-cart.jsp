<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>
</head>
<body>
	<div class="wrapper">
		<div><%@ include file="../../layout/sidebar.jsp"%></div>
		<div class="main-panel">

			<div><%@ include file="../../layout/header.jsp"%></div>
			<div class="content">
				<div class="container-fluid">

					<div class="row">
						<div class="col-md-3">
							<table border=1>
								<c:forEach items="${cartList}" var="cart">


									<tr>
										<td><input type="hidden" name="book_id"
											value="${cart.book}" /></td>
									</tr>
									<tr>
										<td><input type="text" name="book_name" readonly
											value="${book.name}" /></td>
									</tr>
									<tr>
										<td><input type="text" name="book_price" readonly
											value="${book.price}" /></td>
									</tr>
									<tr>
										<td><button type="submit">add to cart</button></td>
									</tr>


								</c:forEach>
							</table>

							<a href="../carts/list">View Cart</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>