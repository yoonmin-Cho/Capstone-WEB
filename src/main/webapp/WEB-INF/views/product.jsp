<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<title>Product</title>
</head>
<body>

	<%
		String subCategory = (String)session.getAttribute("subCategory");
		String pageString = null;
		
		if(subCategory.equals("0"))
			pageString = "mostPopular.jsp";
		else if(subCategory.equals("1"))
			pageString = "mostReview.jsp";
		else if(subCategory.equals("2"))
			pageString = "mostScan.jsp";
	%>

	<jsp:include page="<%=pageString%>" flush="false"></jsp:include>

</body>
</html>