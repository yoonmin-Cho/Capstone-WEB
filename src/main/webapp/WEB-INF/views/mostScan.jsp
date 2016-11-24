<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="java.util.*"%>
<%@page import="kr.ac.zebra.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">

<spring:url value="/resources/core/css/bootstrap.min.css" var="coreCss" />
<spring:url value="/resources/core/css/3-col-portfolio.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/css/heroic-features.css"
	var="heroicfeatures" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<link href="${heroicfeatures}" rel="stylesheet" />
<title>product</title>
</head>
<body>

	<style>
		#titles {
			color: black;
		}
	
		.review_btn {	
			background-Color: #2f72f7;   
			font:15px Arial;     
			font-weight:bold;  
			color:#ffffff;    
			border: 0;
			outline: 0;
			width:90px;
			height:35px; 
		}
		
		.reviewPurchase_btn{	
			background-Color: #65a2f7;   
			font:15px Arial;     
			font-weight:bold;   
			color:#ffffff;    
			border: 0;
			outline: 0;
			margin-left: 30px;
			width:90px;
			height:35px; 
		}
	</style>

	<!-- header bar -->
	<jsp:include page="productHeader.jsp" flush="false"></jsp:include>

	<%
		String user = (String)session.getAttribute("user");
		if(user.equals("common")){	
	%>
		<div class="container">
		<h3 align="center" style="font-family: fantasy; padding: 30px">
			<small>Most Scan</small>
		</h3>
		<div class="row">
			<c:forEach var="scanProduct" items="${scanProducts}">
				<div class="col-md-4 portfolio-item" style="border: 3">
					<a href="#"> 
						<img class="img-responsive" src="${scanProduct.productUrl}" alt=""
							style="width: 700px; height: 400px; padding: 20px;">
					</a>
					<c:choose>
						<c:when test="${fn:length(scanProduct.productName) >20 }">
							<h1><small style="font-weight: 600">
								<c:out value="${fn:substring(scanProduct.productName,0,19)}"/>...
							</small></h1>
						</c:when>
						<c:otherwise>
							<h1><small style="font-weight: 600">
								<c:out value="${scanProduct.productName}"/>
							</small></h1>
						</c:otherwise>
					</c:choose>
					<img alt="" src="/ZEBRA/resources/images/star${scanProduct.starPoint}.png" width="120px" height="30px" style="padding-top: 6px">		
					
					<div style="margin-top: 20px;">	
						<div style="float:left;">
							<form action="reviewPurchase" method="GET">
								<button type="submit" class="reviewPurchase_btn" name="barcode" value="${scanProduct.barcode}">show Details</button>
							</form>
						</div>
					</div>	
				</div>
			</c:forEach>
		</div>
		<hr>
		<hr>
	</div>
	
	<%
		}else{
	%>
	<div class="container">
		<h3 align="center" style="font-family: fantasy; padding: 30px">
			<small>Most Scan</small>
		</h3>
		<div class="row">
			<c:forEach var="scanProduct" items="${scanProducts}">
				<div class="col-md-4 portfolio-item" style="border: 3">
					<a href="#"> 
						<img class="img-responsive" src="${scanProduct.productUrl}" alt=""
							style="width: 700px; height: 400px; padding: 20px;">
					</a>
					<c:choose>
						<c:when test="${fn:length(scanProduct.productName) >20 }">
							<h1><small style="font-weight: 600">
								<c:out value="${fn:substring(scanProduct.productName,0,19)}"/>...
							</small></h1>
						</c:when>
						<c:otherwise>
							<h1><small style="font-weight: 600">
								<c:out value="${scanProduct.productName}"/>
							</small></h1>
						</c:otherwise>
					</c:choose>
					<img alt="" src="/ZEBRA/resources/images/star${scanProduct.starPoint}.png" width="120px" height="30px" style="padding-top: 6px">		
								
					<div style="margin-top: 20px;">				
						<form action="review" method="GET">
							<button type="submit" class="review_btn" name="barcode" value="${scanProduct.barcode}">Review</button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		<hr>
		<hr>
	</div>
	<%
		}
	%>
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>