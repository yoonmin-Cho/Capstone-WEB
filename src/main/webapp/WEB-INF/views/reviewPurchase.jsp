<%@page import="java.util.*"%>
<%@page import="kr.ac.zebra.dto.*"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:700' rel='stylesheet' type='text/css'>

<script src="js/bootstrap.min.js"></script>

<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapmincss" />
<spring:url value="/resources/core/css/shop-item.css" var="cssshopitemcss" />
<spring:url value="/resources/core/css/blog-home" var="bloghome" />

<link href="${bloghome}" rel="stylesheet" />
<link href="${bootstrapmincss}" rel="stylesheet" />
<link href="${cssshopitemcss}" rel="stylesheet" />

<spring:url value="/resources/core/js/jquery.js" var="jsjqueryjs" />
<script src="${jsjqueryjs}"></script>

<spring:url value="/resources/core/js/bootstrap.min.js" var="jsbootstrapminjs" />
<script src="${jsbootstrapminjs}"></script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<spring:url value="/resources/core/css/heroic-features" var="heroicfeatures" />
<link href="${heroicfeatures}" rel="stylesheet" />

<title>Review</title>
</head>
<body>
	<style>
		#reviewDiv {
			-webkit-box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
			-moz-box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
			box-shadow: 2px 4px 5px 0px rgba(0, 0, 0, 0.29);
		}
		#aa:hover {
			background-color: #c6def5;
		}
		z
		
		.auction_btn{
			margin-top: 50px;
			margin-right: 30px;
			margin-bottom: 20px;
			width: 200px;
			height: 70px;
			font-weight:bold;   
			color:#ffffff;    
			border: 0;
			outline: 0;
		}
		
		.g_market_btn{
			margin-top: 30px;
			margin-right: 30px;
			margin-bottom: 20px;
			width: 200px;
			height: 70px;
			font-weight:bold;   
			color:#ffffff;    
			border: 0;
			outline: 0;
		}
		
		.eleven_st_btn{
			margin-top: 30px;
			margin-right: 30px;
			margin-bottom: 20px;		
			width: 200px;
			height: 70px;
			font-weight:bold;   
			color:#ffffff;    
			border: 0;
			outline: 0;
		}
	</style>

	<!-- navigation bar -->
	<jsp:include page="topNavigation.jsp" flush="false"></jsp:include>
	
	<%
		String productName = (String)session.getAttribute("productName");
		
		int productStarPoint = (int)request.getAttribute("productStarPoint");
		String starStr = "";	
	
		if(productStarPoint == 5) starStr = "star5";
		if(productStarPoint == 4) starStr = "star4";
		if(productStarPoint == 3) starStr = "star3";
		if(productStarPoint == 2) starStr = "star2";
		if(productStarPoint == 1) starStr = "star1";
		
		String star1,star2,star3,star4,star5 = "";
		
		
		List<Integer> starPoints = (List<Integer>)request.getAttribute("starPoints");
		int totalStarPoints = starPoints.get(5);
		
		if(starPoints == null){
			star5 = "0%";
			star4 = "0%";
			star3 = "0%";
			star2 = "0%";
			star1 = "0%";
		}else{
			if(starPoints.get(0)!=0)
				star5 = (int)(totalStarPoints/starPoints.get(0))*10+"%";
			else star5 ="0%";
			if(starPoints.get(1)!=0)
				star4 = (int)(totalStarPoints/starPoints.get(1))*10+"%";
			else star4 ="0%";
			if(starPoints.get(2)!=0)
				star3 = (int)(totalStarPoints/starPoints.get(2))*10+"%";
			else star3 ="0%";
			if(starPoints.get(3)!=0)
				star2 = (int)(totalStarPoints/starPoints.get(3))*10+"%";
			else star2 ="0%";
			if(starPoints.get(4)!=0)
				star1 = (int)(totalStarPoints/starPoints.get(4))*10+"%";
			else star1 ="0%";
		}
	%>
	
	<!-- product Info print -->
	<div class="container" style="padding-top: 50px">
		<div class="row">
			<div class="col-md-8">
				<h1 class="page-header" style="font-family: 'Anton', sans-serif;">Product reviews</h1>
				<div class="row">
					<div class="col-md-6">
						<img class="img-responsive" src="${productInfo.productUrl}" alt="" align="middle" style="width: 300px; height: 350px;">
					</div>
					
					<div class="col-md-6">
						<img alt="" src="/ZEBRA/resources/images/<%=starStr%>.png" style="width: 200px; height: 40px;">
						<br/>
						<h2 style="font-weight: bolder;">
							<c:out value="${productInfo.productName}"></c:out>
						</h2>
						<p>
							<c:out value="${productInfo.description}"></c:out>
						</p>
					</div>
					
					<div class="col-md-6" align="left">
						<div class="col-md-3" align="left">
							<img alt="" src="/ZEBRA/resources/images/star5.png" width="80px" height="20px" align="left">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width:<%=star5%>">
									<span class="sr-only"> 80% Complete (danger) </span>
									<p align="center"><%=star5%></p>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/images/star4.png" width="80px" height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: <%=star4%>">
									<span class="sr-only"> 60% Complete (danger) </span>
									<p><%=star4%></p>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/images/star3.png" width="80px" height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: <%=star3%>">
									<span class="sr-only"> 40% Complete (danger) </span>
									<p><%=star3%></p>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/images/star2.png" width="80px" height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: <%=star2%>">
									<span class="sr-only">20% Complete (danger) </span>
									<p><%=star2%></p>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<img alt="" src="/ZEBRA/resources/images/star1.png" width="80px" height="20px">
						</div>
						<div class="col-md-9">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: <%=star1%>">
									<span class="sr-only"> 10% Complete (danger) </span>
									<p><%=star1%></p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>

				<div style="margin-top: 30px; margin-bottom: 50px;">					
					<input type="button" class="btn btn-danger btn-lg" style="width:220px; margin-right: 25px; padding: 15px;"
						value="옥션에서 구매하기 "
						onclick="location.href='http://search.auction.co.kr/search/search.aspx?keyword=<%=URLEncoder.encode(productName,"euc-kr")%>'">
				
					<input  type="button" class="btn btn-success btn-lg" style="width:220px; margin-right: 25px; padding: 15px;"
						value="G-market 에서 구매하기"
						onclick="location.href='http://search.gmarket.co.kr/search.aspx?keyword=<%=URLEncoder.encode(productName,"euc-kr")%>'">
					
					<input type="button" class="btn btn-warning btn-lg" style="width:220px; margin-right: 25px; padding: 15px;"
						value="11번가에서 구매하기"
						onclick="location.href='http://search.11st.co.kr/SearchPrdAction.tmall?method=getTotalSearchSeller&kwd=<%=URLEncoder.encode(productName,"euc-kr")%>'">
				</div>

				<%
					List<Integer> i = new ArrayList();
					List<Review> reviewList = (List<Review>) request.getAttribute("reviews");
					
					for (int j = 0; j < reviewList.size(); j++) {
						i.add(j, reviewList.get(j).getStarPoint());
					}
					
					List<Integer> similarProductStar = new ArrayList();
					List<Product> similarProducts = (List<Product>) request.getAttribute("similarProducts");
					
					for (int j = 0; j < similarProducts.size(); j++) {
						similarProductStar.add(j, similarProducts.get(j).getStarPoint());
					}
					int z = 0;
				%>
				
				<!-- Print Review -->
				<h3 style="font-family: 'Anton', sans-serif;">Reviews</h3>
				<c:forEach var="reviewList" items="${reviews}">
					<div style="padding-top: 5px">
						<hr>
						<div class="row" id="aa">
							<div class="col-md-12" id="reviewDiv">
								<p></p>
								<p>
									<img
										src="${reviewList.memberUrl}"
										alt="..." class="img-circle" width="50px" height="50px"
										style="padding-left:; padding-top:">
									<c:out value="${reviewList.email}"></c:out>
								</P>
								<%
									int starimg = i.get(z).intValue();
									if (starimg == 5) {
								%>
								<img alt="" src="/ZEBRA/resources/images/star5.png" width="80px"
									height="20px">
								<%
									} if (starimg == 4) {
								%>
								<img alt="" src="/ZEBRA/resources/images/star4.png" width="80px"
									height="20px">
								<%
									}if (starimg == 3) {
								%>
								<img alt="" src="/ZEBRA/resources/images/star3.png" width="80px"
									height="20px">
								<%
									}if (starimg == 2) {
								%>
								<img alt="" src="/ZEBRA/resources/images/star2.png" width="80px"
									height="20px">
								<%
									}if (starimg == 1) {
								%>
								<img alt="" src="/ZEBRA/resources/images/star1.png" width="80px"
									height="20px">
								<%
									}
									z++;
								%>
								</br>
								</br>
								<p style="padding-left: 5px">
									<c:out value="${reviewList.reviewText}"></c:out>
									</br>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<%
				z = 0;
			%>
			<!-- Blog Sidebar Widgets Column -->
			<div class="col-md-4" style="padding-top: 80px; padding-left: 60px;">
				<h3 style=" font-family: 'Anton', sans-serif; padding-bottom: 40px;">Related Products</h3>
				<c:forEach var="similarProducts" items="${similarProducts}">
					<div class="col-md-4 portfolio-item" style="width: 250px; height: 300px">
						<a href="/ZEBRA/review?barcode=${similarProducts.barcode}"> <img
							class="img-responsive" src="${similarProducts.productUrl}" alt="" style="width: 150px; height: 170px;"></a>
						<div class="caption">
							<h5>
								<h5 style="font-weight: bolder; font-size: 15px">
									<c:out value="${similarProducts.productName}"></c:out>
								</h5>
							</h5>
								
							<%
								int starimg = similarProductStar.get(z).intValue();
								if (starimg == 5) {
							%>
							<img alt="" src="/ZEBRA/resources/images/star5.png" width="80px" height="20px">
							<%
								}if (starimg == 4) {
							%>
							<img alt="" src="/ZEBRA/resources/images/star4.png" width="80px" height="20px">
							<%
								}if (starimg == 3) {
							%>
							<img alt="" src="/ZEBRA/resources/images/star3.png" width="80px" height="20px">
							<%
								}if (starimg == 2) {
							%>
							<img alt="" src="/ZEBRA/resources/images/star2.png" width="80px" height="20px">
							<%
								}if (starimg == 1) {
							%>
							<img alt="" src="/ZEBRA/resources/images/star1.png" width="80px" height="20px">
							<%
								}
								z++;
							%>
							<hr>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		</div>
</body>
</html>