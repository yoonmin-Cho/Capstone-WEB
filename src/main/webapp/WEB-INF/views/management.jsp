<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Roboto:900' rel='stylesheet' type='text/css'>

<title>Management</title>
</head>
<body>
	<style>
		blockquote {
			border-left: 2px solid #CC0000;
			padding: 0.5em 10px;
			color: #FFF;
		}
	</style>

	<!-- navigation bar -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>

	<div class="container" align="center" style="padding-top: 80px">
		<img src="/ZEBRA/resources/image/ourproduct.png"
			style="width: 1000px; height: 300px;" >
	</div>

	<div class="container" style="padding-top: 10px">
		<h2 style=" font-family: 'Anton', sans-serif; "align="left">Requested Product Table</h2>
		<blockquote style="background: FF3300">
			<table class="table table-striped" id="testTable">
				<thead>
					<tr>
						<th>Index</th>
						<th>Applied Barcode</th>
						<th>ProductName</th>
						<th>Requester</th>
						<th>Approval</th>
					</tr>
				</thead>
				<tbody>
					<%
						int index = 1;
					%>
					<c:forEach var="applyList" items="${applyListModel}">
						<tr>
							<td><%=index%></td>
							<td><c:out value="${applyList.barcode}"></c:out></td>
							<td><c:out value="${applyList.productName}"></c:out></td>
							<td><c:out value="${applyList.email}"></c:out></td>
							<td><a
								href="/ZEBRA/Confirm?barcode=${applyList.barcode}&productName=${applyList.productName}&email=${applyList.email}">Confirm</a></td>
						</tr>
						<%
							index++;
						%>
					</c:forEach>
				</tbody>
			</table>
		</blockquote>

		<!-- footer -->
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>