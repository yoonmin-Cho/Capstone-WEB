<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
		String category = (String)session.getAttribute("category");
		String sub = (String)session.getAttribute("subCategory");
	%>

	<div class="row" align="center">	
		<div class="col-md-1"></div>
		<div class="col-md-1"></div>
		<div class="col-md-1"></div>
		<div class="col-md-1"><a href="/ZEBRA/product?category=0&sub=<%=sub%>">All</a></div>
		<div class="col-md-1"><a href="/ZEBRA/product?category=1&sub=<%=sub%>">Appliances</a></div>
		<div class="col-md-1"><a href="/ZEBRA/product?category=2&sub=<%=sub%>">Beauty</a></div>
		<div class="col-md-1"><a href="/ZEBRA/product?category=3&sub=<%=sub%>">Book</a></div>
		<div class="col-md-1"><a href="/ZEBRA/product?category=4&sub=<%=sub%>">Food</a></div>
		<div class="col-md-1"><a href="/ZEBRA/product?category=5&sub=<%=sub%>">Necessaries</a></div>
	</div>
</body>
</html>