<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%><html>
<head>
<meta charset="utf-8">
<title>My Page</title>
</head>
<body>
	<!-- navigation bar -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
	
	<img src="/ZEBRA/resources/images/myPage.jpeg"/>
	
	<div class="container">
		<h3 align="center" style="font-family: fantasy; padding: 30px">
			<small>MY Page</small>
		</h3>
		
		<div class="row">
			<c:forEach var="userInfo" items="${userInfo}">
				<div class="col-md-4 portfolio-item" style="border: 3">
					<a href="#"> 
						<img class="img-responsive" src="${userInfo.memberUrl}" alt=""
							style="width: 700px; height: 400px;">
					</a>
					<h1>
						<small style="font-weight: 800">
							<c:out value="${userInfo.name}"></c:out>
						</small></br> 
						<img alt="" src="/ZEBRA/resources/images/${userInfo.level}.png" width="120px" height="30px" style="padding-top: 6px">		
					</h1>
				</div>
			</c:forEach>
		</div>
		<hr>
		<hr>
	</div>
</body>
</html>