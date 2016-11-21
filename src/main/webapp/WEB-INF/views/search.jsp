<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<style>
		#custom-search-input {
			margin: 0;
			margin-top: 10px;
			padding: 0;
		}
		
		#custom-search-input .search-query {
			padding-right: 3px;
			padding-right: 4px \9;
			padding-left: 3px;
			padding-left: 4px \9;
			/* IE7-8 doesn't have border-radius, so don't indent the padding */
			margin-bottom: 0;
			-webkit-border-radius: 3px;
			-moz-border-radius: 3px;
			border-radius: 3px;
		}
		
		#custom-search-input button {
			border: 0;
			background: none;
			/** belows styles are working good */
			padding: 2px 5px;
			margin-top: 2px;
			position: relative;
			left: -28px;
			/* IE7-8 doesn't have border-radius, so don't indent the padding */
			margin-bottom: 0;
			-webkit-border-radius: 3px;
			-moz-border-radius: 3px;
			border-radius: 3px;
			color: #D9230F;
		}
		
		.search-query:focus+button {
			z-index: 3;
		}
	</style>

	<div class="container">
		<div class="row" align="center"
			style="padding-top: 70px; padding-bottom: 50px;">
			<c:url var="addUrl" value="search" />
			<form action="${addUrl}" method="GET" id="searchBox">
				<div id="custom-search-input">
					<div class="input-group col-md-4">
						<input type="text" class="search-query form-control"
								name="productName" placeholder="Search Product" />
						<span class="input-group-btn">
							<button class="btn btn-danger" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>