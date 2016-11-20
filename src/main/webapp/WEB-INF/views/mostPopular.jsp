<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		
		.purchase_btn{	
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
			<small>Popularity</small>
		</h3>
		<div class="row">
			<c:forEach var="popularProduct" items="${popularProducts}">
				<div class="col-md-4 portfolio-item" style="border: 3">
					<a href="#"> 
						<img class="img-responsive" src="${popularProduct.productUrl}" alt=""
							style="width: 700px; height: 400px;">
					</a>
					<h1>
						<small style="font-weight: 800">
							<c:out value="${popularProduct.productName}"></c:out>
						</small>
						</br>	
						<img alt="" src="/ZEBRA/resources/images/star${popularProduct.starPoint}.png" width="120px" height="30px" style="padding-top: 6px">		
					</h1>
					<div>	
						<div style="margin-top: 20px;">	
							<div style="float:left;">
								<form action="review" method="GET">
									<button type="submit" class="review_btn" name="barcode" value="${popularProduct.barcode}">
										Review
									</button>
								</form>
							</div>
							<div>
								<form action="purchase" method="GET">
									<button type="submit" class="purchase_btn" name="barcode" value="${popularProduct.barcode}">	
										Purchase
									</button>
								</form>
							</div>
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
			<small>Popularity</small>
		</h3>
		<div class="row">
			<c:forEach var="popularProduct" items="${popularProducts}">
				<div class="col-md-4 portfolio-item" style="border: 3">
					<a href="#"> 
						<img class="img-responsive" src="${popularProduct.productUrl}" alt=""
							style="width: 700px; height: 400px;">
					</a>
					<h1>
						<small style="font-weight: 800">
							<c:out value="${popularProduct.productName}"></c:out>
						</small></br> 
						<img alt="" src="/ZEBRA/resources/images/star${popularProduct.starPoint}.png" width="120px" height="30px" style="padding-top: 6px">		
					</h1>
					<div style="margin-top: 20px;">				
						<form action="review" method="GET">
							<button type="submit" class="review_btn" name="barcode" value="${popularProduct.barcode}">Review</button>
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
</body>
</html>