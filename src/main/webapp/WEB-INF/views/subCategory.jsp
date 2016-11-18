<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<%
		String category = (String)session.getAttribute("category");
	%>
	
	<div class="container" style="padding: 15px">
		<div class="row">
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A">
					<a href="/ZEBRA/mostPopular?category=<%=category%>">Popularity</a>
				</h4>
				<hr align="center" style="border: solid 3px #A91717; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A">
					<a href="/ZEBRA/mostReview?category=<%=category%>">MostReview</a>
				</h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
			<div class="col-md-4" align="center">
				<h4 id="" style="font-family: fantasy; color: #7A7A7A">
					<a href="/ZEBRA/mostScan?category=<%=category%>">MostScan</a>
				</h4>
				<hr align="center" style="border: solid 2px #F15F5F; width: 30%;">
			</div>
		</div>
	</div>

</body>
</html>