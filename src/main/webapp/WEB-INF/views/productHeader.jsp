<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<!-- navigation bar -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>

	<!-- search bar -->
	<jsp:include page="search.jsp" flush="false"></jsp:include>

	<!-- category -->
	<jsp:include page="category.jsp" flush="false"></jsp:include>
	
	<!-- Sub Category -->
	<jsp:include page="subCategory.jsp" flush="false"></jsp:include>
	
</body>
</html>