<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<title>Product</title>
</head>
<body>
	<!-- navigation bar -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>

	<!-- search bar -->
	<jsp:include page="search.jsp" flush="false"></jsp:include>

	<!-- category -->
	<jsp:include page="category.jsp" flush="false"></jsp:include>

	<%
		String logOk = (String)session.getAttribute("logOk");
		String user = (String) session.getAttribute("user");
		String productURL = null;
	
		if(logOk.equals("login") && user.equals("common"))
			productURL = "mostPopularForUser.jsp";
		else 
			productURL = "mostPopular.jsp";			
	%>

	<!-- product page -->
	<jsp:include page="<%=productURL%>" flush="false"></jsp:include>

</body>
</html>